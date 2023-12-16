package com.spring.agenciaDeViagenstest.customer;



public class CustomerRequest {
	
	private String name;
	
	
	private String cpf;
	

	private String email;
	
	private String passportNumber;
	
	private String password;

	public CustomerRequest(String name, String cpf, String email, String passportNumber, String password) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.passportNumber = passportNumber;
		this.password = password;
	}

	public CustomerRequest() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
