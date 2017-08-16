package com.gemasu.controller;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
	private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

	@Autowired
	private MyMessage newMessage;

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@JmsListener(destination = "${destination.boot}")
	public void receive(String message) {
		newMessage.setMessage(message);
		System.out.println(message);
		LOGGER.info("received message='{}'", message);
		latch.countDown();
	}

}
