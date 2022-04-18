package com.training.aspects;

import java.time.LocalDate;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class TestAspect {

	Logger log = LoggerFactory.getLogger(TestAspect.class);
	
	@Before(value="execution(* com.training.services.AOPService.get*(..))")
	public void logBefore(JoinPoint joinPoint)
	{
		log.info("This is before aspect");
		String className = joinPoint.getTarget().getClass().toString();
		log.info(className);
		log.info(""+joinPoint.getSignature());
		
	}
	
	@Around(value="execution(* com.training.services.AOPService.get*())")
	public Object logAround(ProceedingJoinPoint joinPoint)
	{
		log.info("This is start of around advice");
		log.info("ClassName :"+joinPoint.getTarget().getClass().toString());
		log.info(""+joinPoint.getSignature());
		
		log.info(LocalDate.now()+"");
		
		Object value="";
		
		try {
			value = joinPoint.proceed();
			log.info("Value inside the method="+value);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		log.info("Back to Aspect");
		return value;
		
	}
	
	
}
