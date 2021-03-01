package com.nagarro.msa.service.provider.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.msa.service.provider.model.User;


@FeignClient(name="signupservice")
public interface UserClient {

	@RequestMapping(method = RequestMethod.GET, value = "/spList")
    List<User> spList(@RequestParam("cityId") int cityId);
	
}
