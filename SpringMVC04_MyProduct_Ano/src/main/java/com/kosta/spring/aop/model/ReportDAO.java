package com.kosta.spring.aop.model;

import java.util.List;

public interface ReportDAO {
	void insertReport(String word) throws Exception;
	int updateReport(String word) throws Exception;
	List selectReport() throws Exception;
}
