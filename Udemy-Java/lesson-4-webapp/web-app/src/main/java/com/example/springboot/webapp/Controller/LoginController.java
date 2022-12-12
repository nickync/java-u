package com.example.springboot.webapp.Controller;

import com.example.springboot.webapp.Service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(){
//        logger.info("Request param is {}", name);
//
//        modelMap.put("name", name);
        return "login";
    }

    @PostMapping(value = "login")
    public String postLogin(@RequestParam String name, @RequestParam String password, ModelMap modelMap){

        if (authenticationService.authenticate(name, password)){
            modelMap.put("name", name);
            modelMap.put("password", password);
            return "welcome";
        }

        modelMap.put("err", "Invalid credentials!!!");
        return "login";
    }
}
