package com.kh.java.member.model.vo;

import java.sql.Date; // sql을 쓴다면 이게 더 편하다.
import java.util.List;

public class MemberVo {
	private String userid;
	private String password;
	private String username;
	private char gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private List<String> hobby;
	private Date enrolldate;
	
	public MemberVo(){
		
	}

	public MemberVo(String userid, String password, String username, char gender, int age, String email, String phone,
			String address, List<String> hobby /*String hobbies*/ , Date enrolldate) {
		super();
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		//this.hobbies = hobbies;
		this.enrolldate = enrolldate;
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return userid + " & " + password + " & " + username;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}

	public String getUserid() {
		return userid;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public char getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	
	public List<String> getHobby() {
		return hobby;
	}
	
	
	public String getAllHobby(){
		if(hobby != null){
			StringBuilder allHobby = new StringBuilder();
			for(int index = 0; index < hobby.size(); index++){
				allHobby.append(hobby.get(index));
				if(index != hobby.size() - 1)
					allHobby.append("|");
			}		
			return allHobby.toString();
		}
		return null;
	}

	public Date getEnrolldate() {
		return enrolldate;
	}
}
