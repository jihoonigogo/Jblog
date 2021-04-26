package com.bitacademy.jblog.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVo {
 private Long userNo;
 
// @NotEmpty	//	name 필드는 null이 아니어야 하고
// @Length(min=2, max=8)		//	길이가 2글자 ~ 8글자
 private String id;
 
// @NotEmpty	//	name 필드는 null이 아니어야 하고
//@Length(min=2, max=8)		//	길이가 2글자 ~ 8글자
 private String userName;
 
// @NotEmpty	//	password 필드는 null이 아니어야 하고
//	@Length(min=4, max=20)	//	길이가 4 ~ 20글자여야 한다
 private String password;
 private Date joinDate;
 
 public UserVo() {
	 
 }

public Long getUserNo() {
	return userNo;
}

public void setUserNo(Long userNo) {
	this.userNo = userNo;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Date getJoinDate() {
	return joinDate;
}

public void setJoinDate(Date joinDate) {
	this.joinDate = joinDate;
}

@Override
public String toString() {
	return "UserVo [userNo=" + userNo + ", id=" + id + ", userName=" + userName + ", password=" + password
			+ ", joinDate=" + joinDate + "]";
}
 
 
 
 
 
 
}
