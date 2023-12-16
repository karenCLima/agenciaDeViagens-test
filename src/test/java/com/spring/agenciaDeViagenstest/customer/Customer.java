package com.spring.agenciaDeViagenstest.customer;


public class Customer {
	
	private Integer id;
	

	private String name;
	

	private String cpf;
	

	private String email;
	
	private String passportNumber;
	
	private String password;
	
	private Boolean activate;

	public Customer(Integer id, String name, String cpf, String email, String passportNumber, String password,
			Boolean activate) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.passportNumber = passportNumber;
		this.password = password;
		this.activate = activate;
	}
	
	

	public Customer() {
		super();
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getActivate() {
		return activate;
	}

	public void setActivate(Boolean activate) {
		this.activate = activate;
	}


}
