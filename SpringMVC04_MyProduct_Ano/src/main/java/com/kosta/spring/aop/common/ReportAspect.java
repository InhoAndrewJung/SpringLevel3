package com.kosta.spring.aop.common;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kosta.spring.aop.model.ReportService;

@Component
@Aspect
public class ReportAspect {//POJO
	@Autowired
	private ReportService reportService;
	
	@Around("execution(public * com.kosta.spring.model.impl.*Service*.find*(..))")
	public Object report(ProceedingJoinPoint pjp) throws Throwable{
		Object retValue = null;
		
		retValue = pjp.proceed();//find류 메서드가 돌아감
		System.out.println(pjp.getSignature().getName()+"() target method call..");
		List list = (List)retValue;
		
		if(!list.isEmpty()) {
			Object[] params = pjp.getArgs();
			reportService.saveReport(params[0].toString());
		}
		return list;
	}
	
}
