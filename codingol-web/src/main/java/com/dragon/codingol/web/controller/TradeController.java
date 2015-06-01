package com.dragon.codingol.web.controller;

import com.dragon.codingol.domain.Client;
import com.dragon.codingol.service.reactor.TradeServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import reactor.Environment;
import reactor.bus.Event;
import reactor.bus.EventBus;
import reactor.rx.Promise;
import reactor.rx.Promises;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Callable;


/**
 * @author Jon Brisbin
 */
@Controller
public class TradeController {
    @Autowired
    Environment env;
    @Autowired
	EventBus    eventBus;
    @Autowired
	TradeServer tradeServer;


	@RequestMapping(value = "/trade", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Iterable<Client> listClients() {
		return null;
	}

	@RequestMapping(value = "/trade/{clientId}", method = RequestMethod.GET, produces = "text/plain")
	@ResponseBody
	public String trade(@PathVariable Long clientId) {
		// Retrieve client by id
		Client cl = new Client("a");

		eventBus.notify("trade.execute", Event.wrap(tradeServer.nextTrade()));

		// Update trade count

		// Return result
		return "Hello " + cl.getName() + "! You now have " + cl.getTradeCount() + " trades.";
	}


    @RequestMapping(value="/promise", method = RequestMethod.GET)
    @ResponseBody
    public Promise<ResponseEntity<String>> get(HttpServletRequest request, HttpServletResponse response) {
        Promise<ResponseEntity<String>> d = Promises.<ResponseEntity<String>>prepare(env);

        eventBus.notify("test", Event.wrap(d));

       return d;
    }


    @RequestMapping("/custom")
    public  String callableWithCustomTimeoutHandling(Model model) {

    	System.out.println( "custom: "+Thread.currentThread().getName());
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        model.addAttribute("foo", "bar");
        model.addAttribute("fruit", "apple");
        return "admin/index";
    }

    @RequestMapping("/view")
    public Callable<String> callableWithView(final Model model) {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
            	System.out.println("view:	"+Thread.currentThread().getName());
                Thread.sleep(10000);
                model.addAttribute("foo", "bar");
                model.addAttribute("fruit", "apple");
                return "admin/index";
            }
        };
    }


}
