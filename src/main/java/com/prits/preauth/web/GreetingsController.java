package com.prits.preauth.web;

import com.prits.preauth.entity.Greeting;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by 3ppat on 1/8/2017.
 */
@RestController
public class GreetingsController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public @ResponseBody Greeting sayHello(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated()) {
            Greeting g = new Greeting();
            g.setId(11111L);
            g.setMessage("Hello From Spring Security Framework");
            return g;
        } else {
            throw new AccessDeniedException("User is not authenticated!!!");
        }


    }
}
