package com.member.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable, Comparable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3142233889468626587L;

	
	//DB에서 가져온 데이터를 받아서 보관하는 것
	private String memberId, memberPwd, memberName, gender;
	
	private int age;
	
	private String email, phone, address, hobby;
	
	private Date enrollDate;
	
	public Member() {
	
	}
	
	public Member(String memberId, String memberPwd, String memberName, String gender, int age, String email,
			String phone, String address, String hobby ,Date enrollDate) {
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.enrollDate = enrollDate;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		
		
		return memberId + "\t" + memberPwd + "\t" + memberName + "\t"
				+ gender + "\t" + age + "\t" + email + "\t" + phone + "\t"
				+ address+ "\t" + hobby ;
	}

	@Override
	public int compareTo(Object o) {
		
		
		if (o instanceof Member) {
		
			Member other = (Member) o;
			
			return other.memberName.compareTo(this.memberName);
		} else {
			
			return 0;
		}
		
	}
	
	
	
	
	
}
