package com.kosta.spring.aop.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private ReportDAO reportDAO;
	
	@Override
	public List selectReport() throws Exception {
		// TODO Auto-generated method stub
		return reportDAO.selectReport();
	}

	@Override
	public void saveReport(String word) throws Exception {
		int row =reportDAO.updateReport(word);
		if(row==0)
			reportDAO.insertReport(word);
	}

}
