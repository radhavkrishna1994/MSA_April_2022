package com.training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.training.services.BookServiceI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootBookProducerApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private BookServiceI bookService;
	
	@Test
	public void testHello()
	{
		String actualResult = bookService.sayHello();
		String expResult="Hello";
		
		assertEquals("REsult wrong",expResult,actualResult);
	}

}
