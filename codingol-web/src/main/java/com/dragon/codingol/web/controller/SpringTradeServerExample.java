package com.dragon.codingol.web.controller;

import static reactor.bus.selector.Selectors.$;

import com.dragon.codingol.service.reactor.Trade;
import com.dragon.codingol.service.reactor.TradeServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import reactor.Environment;
import reactor.bus.Event;
import reactor.bus.EventBus;
import reactor.spring.context.config.EnableReactor;
import reactor.spring.webmvc.PromiseHandlerMethodReturnValueHandler;

import java.util.List;

/**
 * @author Jon Brisbin
 */
@Configuration
@ComponentScan
@EnableReactor
public class SpringTradeServerExample {

	@Bean
	public TradeServer tradeServer() {
		return new TradeServer();
	}

	@Bean
	public EventBus eventBus(Environment env) {
		EventBus ev = EventBus.create(env);

		// Wire an event handler to execute trades
		/*ev.on($("trade.execute"), (Event<Trade> e) -> {
			tradeServer.execute(e.getData());
			log.info("Executed trade: {}", e.getData());
		});*/

		return ev;
	}

    
}
