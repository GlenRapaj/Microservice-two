package com.glen.GetBookListMicroService2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.glen.GetBookListMicroService2.model.Book;

public interface BookRepo extends JpaRepository<Book,Integer>{
	
	@Query(" from Book where isbn=?1 and sasia>0")
	Book findByIsbn(int isbn);
	
	@Query(" from Book where sasia=?1 and sasia>0")
	Book findBySasia(int sasia);
	
	@Query("select sasia from Book where id=?1 and sasia>0")
	int jepSasine(int id);
	
	

}
