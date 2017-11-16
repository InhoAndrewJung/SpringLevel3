package com.kosta.spring.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Resource	
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MemberVO findMemberById(String id){
		return sqlSession.selectOne("memberMapper.findMemberById",id);
	}
	@Override
	public List<String> getAddressList(){
		return sqlSession.selectList("memberMapper.getAddressList");
	}
	@Override
	public List<MemberVO> findMemberListByAddress(String address){
		return sqlSession.selectList("memberMapper.findMemberListByAddress",address);
	}
	@Override
	public MemberVO login(MemberVO memberVO){
		return sqlSession.selectOne("memberMapper.login",memberVO);
	}
	@Override
	public int getMemberCount(){
		return sqlSession.selectOne("memberMapper.getMemberCount");
	}
	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update("memberMapper.updateMember",vo);			
	}	
	@Override
	public void registerMember(MemberVO vo) {
		sqlSession.insert("memberMapper.registerMember",vo);			
	}
	@Override
	public int idcheck(String id) {
		return sqlSession.selectOne("memberMapper.idcheck",id);				
	}
	
}



















