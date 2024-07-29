package com.example.jpetstore.domain;

import java.io.Serializable;

import java.util.Date;

@SuppressWarnings("serial")
public class Account implements Serializable {

	private String accountId;
	private String password;
	private String nickname;
	private Date joinDate;
	private String phoneNumber;
	private String email;
	private String bankNumber;
	private String bankName;
	private String address;
	private String zipcode;
	private int withdraw;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", password=" + password + ", nickname=" + nickname + ", joinDate="
				+ joinDate + ", phoneNumber=" + phoneNumber + ", email=" + email + ", bankNumber=" + bankNumber
				+ ", bankName=" + bankName + ", address=" + address + ", zipcode=" + zipcode + ", withdraw=" + withdraw
				+ "]";
	}

}
