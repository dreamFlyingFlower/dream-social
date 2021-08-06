package com.wy.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "consumer2")
public class Consumer2 {

	@RabbitHandler
	public void getMsg(String msg) {
		System.out.println("consumer2：" + msg);
	}
}