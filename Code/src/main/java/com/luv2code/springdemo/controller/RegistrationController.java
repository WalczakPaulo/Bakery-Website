package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.BakeryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegistrationController {


    @Autowired
    private UserDetailsManager userDetailsManager;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel) {
        theModel.addAttribute("bakeryUser", new BakeryUser());
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("crmUser") BakeryUser theBakeryUser,
            BindingResult theBindingResult,
            Model theModel) {

        if(theBindingResult.hasErrors()) {
            theModel.addAttribute("bakeryUser", new BakeryUser());
            theModel.addAttribute("registrationError",
                    "User name/password can not be empty.");
            return "registration-form";
        }

        if(doesUserExist(theBakeryUser.getUserName()))
        {
            theModel.addAttribute("bakeryUser", new BakeryUser());
            theModel.addAttribute("registrationError",
                    "User name exists");
            return "registration-form";
        }

        String password = "{noop}" + theBakeryUser.getPassword();

        List<GrantedAuthority> authorities =
                AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");

        User tempUser = new User(theBakeryUser.getUserName(), password, authorities);

        userDetailsManager.createUser(tempUser);

        return "registration-confirmation";

    }

        private boolean doesUserExist(String userName){
            boolean exists = userDetailsManager.userExists(userName);
            return exists;
        }

}