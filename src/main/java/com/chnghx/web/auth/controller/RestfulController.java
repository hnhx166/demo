package com.chnghx.web.auth.controller;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Irving on 2014/12/10.
 */
@RestController
@Scope("prototype")
@RequestMapping("/rest")
public class RestfulController {

    @RequestMapping(method = RequestMethod.GET)
    //@JsonView(User.WithoutPasswordView.class)
    public String test() {
        return "just rest test!";
    }
}
