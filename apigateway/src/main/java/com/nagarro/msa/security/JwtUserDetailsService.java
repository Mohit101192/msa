package com.nagarro.msa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.nagarro.msa.security.model.MSAUser;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		try
		{
		String baseUrl = loadBalancerClient.choose("signupservice").getUri().toString() + "/user";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<MSAUser> response = null;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl)
									   .queryParam("username",username);
		response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, null,
				MSAUser.class);
		System.out.println(response.getBody());
		return response.getBody();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}

}