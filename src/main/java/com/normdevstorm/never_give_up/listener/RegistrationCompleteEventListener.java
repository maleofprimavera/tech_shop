package com.normdevstorm.never_give_up.listener;

import com.normdevstorm.never_give_up.event.RegistrationCompleteEvent;
import com.normdevstorm.never_give_up.model.User;
import com.normdevstorm.never_give_up.model.VerificationToken;
import com.normdevstorm.never_give_up.service.token.TokenService;
import com.normdevstorm.never_give_up.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {

        // create User entity with a token
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveToken(token, user);

        //send mail to user with a token
        String url = event.getApplicationUrl() + "/verifyToken?token=" + token;

        //
        log.info("Click the link to verify your account: {}", url);
    }
}
