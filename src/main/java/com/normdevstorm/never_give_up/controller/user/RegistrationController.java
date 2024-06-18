package com.normdevstorm.never_give_up.controller.user;

import com.normdevstorm.never_give_up.event.RegistrationCompleteEvent;
import com.normdevstorm.never_give_up.model.User;
import com.normdevstorm.never_give_up.model.UserModel;
import com.normdevstorm.never_give_up.service.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private final UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String  registerUser(@RequestBody UserModel userModel, final HttpServletRequest request){

        User user = userService.registerUser(userModel);

        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrlCreate(request)));

        return "Success";
    }

    private String applicationUrlCreate(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    @GetMapping("/verifyToken")
    public String verifyToken(@PathParam("token") String token){
        return userService.verifyToken(token);
    }

}
