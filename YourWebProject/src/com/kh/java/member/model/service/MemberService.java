package com.kh.java.member.model.service;

import com.kh.java.member.model.dao.MemberDao;
import com.kh.java.member.model.vo.MemberVo;

public class MemberService {
	public MemberService(){
		
	}
	
	public MemberVo signin(String id, String pw){
		return new MemberDao().signin(id, pw); // 접근하고 가져온다.
	}
	
	public int signupMember(MemberVo m){
		return new MemberDao().insertMember(m);
	}

	public MemberVo getMemberById(String id) {
		// TODO Auto-generated method stub
		return new MemberDao().selectMemberById(id);
	}

	public int updateMember(MemberVo m) {
		// TODO Auto-generated method stub
		return new MemberDao().updateMember(m);
	}

	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return new MemberDao().deleteMember(id);
	}
}
