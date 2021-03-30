package com.mkknowledge.managerportal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkknowledge.managerportal.service.StripeService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	 @Value("${stripe.keys.public}")
	    private String API_PUBLIC_KEY;

	 	@Autowired
	    private StripeService stripeService;
	
		@PostMapping("/charge")
	    public String chargeCard(HttpServletRequest request) throws Exception {
	        String token = request.getHeader("token");
	        Double amount = Double.parseDouble(request.getHeader("amount"));
	        String subscriptionType = request.getHeader("subscriptionType");
	        
	        return stripeService.createCharge(subscriptionType, token, amount);
	    }
	   
}
