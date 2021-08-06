package com.wy.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "consumer3")
public class Consumer3 {

	@RabbitHandler
	public void getMsg(String msg) {
		System.out.println("consumer3：" + msg);
	}
}