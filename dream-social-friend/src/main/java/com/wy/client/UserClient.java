package com.wy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Component
@FeignClient("social-user")
public interface UserClient {

	@PutMapping("/user/{userid}/{friendid}/{x}")
	void updatefanscountandfollowcount(@PathVariable("userid") String userid, @PathVariable("friendid") String friendid,
			@PathVariable("x") int x);
}