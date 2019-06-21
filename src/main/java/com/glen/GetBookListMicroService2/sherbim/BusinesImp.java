package com.glen.GetBookListMicroService2.sherbim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.glen.GetBookListMicroService2.model.Book;
import com.glen.GetBookListMicroService2.repository.BookRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class BusinesImp implements Busines{
	

	@Autowired
	private BookRepo bookRepo;

	@Override
	@HystrixCommand(fallbackMethod = "bliLiberSapstitude" )	
	public String bliLiber(int isbn) {

		Book book =	bookRepo.findByIsbn(isbn);
		System.out.println(book);
		
		if(book != null) {
			
			
				//int i = book.getSasia();
				// System.out.println(i);
				
				
				int i = book.getSasia()- 1;
				book.setSasia(i);
				bookRepo.save(book);
				return "true";
				
				/*
				if(i>0) {
					
				}
				else {
					return "false";
				}
				*/
				//System.out.println("ok");
				
				
		}
		else
		{
			return " libri nuk u gjet ";
		}
		
	}
	
	
	
	public String	bliLiberSapstitude(int isbn){
		
		return " Sistemi i ngarkuar provo perseri me vone.  ";
	}

}
