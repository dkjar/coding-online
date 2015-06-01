package com.dragon.codingol.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.Environment;
import reactor.bus.Event;
import reactor.bus.EventBus;
import reactor.rx.Promise;
import reactor.rx.Promises;


/**
 * @author Jon Brisbin
 */
@Controller
public class PromiseController {



    @RequestMapping(value="/get", method = RequestMethod.GET)
    public String getInfo() {
        return "view";
    }
}
