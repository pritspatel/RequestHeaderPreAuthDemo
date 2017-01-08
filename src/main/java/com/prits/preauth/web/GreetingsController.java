package com.prits.preauth.web;

import com.prits.preauth.entity.Greeting;
import org.springframework.http.MediaType;
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
        Greeting g = new Greeting();
        g.setId(11111L);
        g.setMessage("Hello From Spring Security Framework");
        return g;
    }
}
