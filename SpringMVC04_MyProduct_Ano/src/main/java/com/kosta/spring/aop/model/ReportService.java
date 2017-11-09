package com.kosta.spring.aop.model;

import java.util.List;

public interface ReportService {
	
	
	List selectReport() throws Exception;//adivise controlloer에서 출력
	void saveReport(String word) throws Exception;//(insert+update)advise에 weaving
	
}
