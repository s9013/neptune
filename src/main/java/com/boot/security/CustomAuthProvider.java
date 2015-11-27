package com.boot.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthProvider implements AuthenticationProvider {
	Logger logger=LoggerFactory.getLogger(CustomAuthProvider.class);

	@Autowired
	//@Qualifier("userDetailsService")
	 UserDetailsService userDetailsService;



	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		  System.out.println("user name: "+authentication.getName());
	        //password
	        System.out.println("password: "+authentication.getCredentials());
	        System.out.println("getPrincipal: "+authentication.getPrincipal());
	        System.out.println("getAuthorities: "+authentication.getAuthorities());
	        System.out.println("getDetails: "+authentication.getDetails());
		
		logger.debug("登录名为密码为"+authentication.getCredentials());
		UserDetails userDetails=userDetailsService.loadUserByUsername(authentication.getName());
		if (!userDetails.getPassword().equals(authentication.getCredentials())) {
			throw new BadCredentialsException("登录失败");
		}

		return authentication;
	}


	public boolean supports(Class<?> authentication) {
		return true;
	}

}
