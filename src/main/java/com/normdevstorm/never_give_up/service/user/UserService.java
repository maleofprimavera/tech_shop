package com.normdevstorm.never_give_up.service.user;

import com.normdevstorm.never_give_up.config.WebConfiguration;
import com.normdevstorm.never_give_up.model.User;
import com.normdevstorm.never_give_up.model.UserModel;
import com.normdevstorm.never_give_up.model.VerificationToken;
import com.normdevstorm.never_give_up.repository.token.TokenRepository;
import com.normdevstorm.never_give_up.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.normdevstorm.never_give_up.config.WebConfiguration.*;

import java.util.Calendar;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenRepository tokenRepository;

    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setName(userModel.getFirstName() + userModel.getLastName());
        user.setUsername(userModel.getUsername());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setRole(User.Role.USER);
        ///todo: find a way to exclude set id method while using @Setter annotation
        user.setEmail(userModel.getEmail());
        return userRepository.save(user);
    }

    public void saveToken(String token, User user) {
        VerificationToken verificationToken = new VerificationToken(token, user);
        tokenRepository.save(verificationToken);
    }

    public String verifyToken(String token) {
        if (tokenRepository.findFirstByTokenContains(token) != null) {
            //check exprirationtime validity
            VerificationToken verificationToken = tokenRepository.findFirstByTokenContains(token);
            Date currentTime = new Date(Calendar.getInstance().getTimeInMillis());
            boolean expiredToken = currentTime.getTime() - verificationToken.getExpirationTime().getTime() > 0;

            if (!expiredToken) {
                User verifiedUser = verificationToken.getUser();
                verifiedUser.setVerified(true);
                userRepository.save(verifiedUser);
                return "User verified successfully !!!";
            }
            return "Token expired !!!";

        } else {
            return "Token not exist !!!";
        }
    }
}
