package com.kh.java.member.model.service;

import com.kh.java.member.model.dao.MemberDao;
import com.kh.java.member.model.vo.MemberVo;

public class MemberService {
	public MemberService(){
		
	}
	
	public MemberVo signin(String id, String pw){
		return new MemberDao().signin(id, pw); // 접근하고 가져온다.
	}
}
