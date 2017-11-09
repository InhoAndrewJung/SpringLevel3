package com.kosta.spring.unit.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kosta.spring.model.MyProductVO;

public class MyBatisUnitAppTest {
	
	@Test
	public void mybatisTest() throws Exception{
		Reader r=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(r);
		SqlSession session=factory.openSession();
		
		MyProductVO vo = new MyProductVO("손으로 빡빡세탁기", "대우", 90);
		session.insert("myProductMapper.insertMyProduct", vo);
		session.commit();
	/*	
		List<MyProductVO> list=
			session.selectList("myProductMapper.findByProductName", "세탁기");
	
		for(MyProductVO v : list) {
			System.out.println(v);
		}	*/
	}
}





























