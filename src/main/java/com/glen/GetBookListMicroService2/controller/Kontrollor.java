package com.glen.GetBookListMicroService2.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.glen.GetBookListMicroService2.model.UserKreditData;
import com.glen.GetBookListMicroService2.repository.UserKreditDataRepo;
import com.glen.GetBookListMicroService2.sherbim.Busines;


@EnableCircuitBreaker
//@RestController
@Controller
public class Kontrollor {
	
	@Autowired
	private Busines busines;
	
	@Autowired
	private UserKreditDataRepo userKreditDataRepo;
	
	
	
	//@GetMapping("/buybooks")  ,Model model
	 @GetMapping("/buybooks/{isbn}")
	public ModelAndView bliLiber(@PathVariable(name="isbn") int isbn ) {
	
	
		String str = busines.bliLiber(isbn);
		System.out.println(str);
		
		 ModelAndView mv = new ModelAndView();
		
		
		if("true".equalsIgnoreCase(str) ) 
		{
			
			RestTemplate rt = new RestTemplate();
			
			String url = "http://localhost:8087/economy/{isbn}" ;
			
			
			rt.postForEntity(url, HttpMethod.POST, Void.class, isbn);
		
			 mv.setViewName("user_data_payment");
			 mv.setStatus(HttpStatus.OK);
			
			return mv;
			
			/*
			 model.addAttribute("user", new UserKreditData() );
		        return "user_data_payment";
			*/
			
		}
		
		else if(" Sistemi i ngarkuar provo perseri me vone.  ".equalsIgnoreCase(busines.bliLiber(isbn))) 
				{
				
				mv.setViewName("UNAVAILABLE");
				mv.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
				
				return mv;
			
			 
			//return "UNAVAILABLE";
				
				
			}
			
			else 
				{
				
					 mv.setViewName("NOT_FOUND");
					mv.setStatus(HttpStatus.NOT_FOUND);
					
					return mv;
					
				// return "NOT_FOUND";
				
			}
		
	}
	
	
	// @PostMapping("/buybooks/userdata")
	
	@PostMapping("/userdata")
	public String teDhenatBleresit( UserKreditData kcd) {
		
		//@ModelAttribute("kcd")
		kcd.setId(0);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" post bliLiber");
		System.out.println(kcd);
		
		userKreditDataRepo.saveAndFlush(kcd);
		
		// shif se mos funksionon me save
		//userKreditDataRepo.save(kcd);
		
		return " OK ";
		
	}


}
