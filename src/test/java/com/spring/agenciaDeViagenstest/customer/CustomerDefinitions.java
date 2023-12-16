package com.spring.agenciaDeViagenstest.customer;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CustomerDefinitions {
	
	private RequestSpecification request = RestAssured.given()
            .baseUri("http://localhost:8080")
            .contentType(ContentType.JSON);
    private Response response = null;
    private CustomerRequest customer;
	
	@Given("Customer is not saved")
    public void customerIsNotSaved() {
		customer = new CustomerRequest();
		customer.setName("Name test");
		customer.setCpf("65688331267");
		customer.setEmail("test@gmail.com");
		customer.setPassportNumber("AZ123456");
		customer.setPassword("Password@1");
	}
	
	@When("Customer is saved successfully")
    public void customerIsSavedSuccessfully() {
		response = request.body(customer).when().post("/customer");
        response.then().statusCode(201);
	}
	
	@Then("Customer is saved")
    public void customerIsSaved() {
		response = request.when().get("/customer/cpf/" + customer.getCpf());
	    response.then().statusCode(200);
	    
	    String jsonResponse = response.getBody().asString();
	    System.out.println("JSON Response: " + jsonResponse);
	    Map<String, Object> customerMap = response.jsonPath().get("");
	    Assertions.assertNotNull(customerMap);
	    
	    CustomerResponse savedCustomer = new CustomerResponse();
	    savedCustomer.setName((String) customerMap.get("name"));
	    savedCustomer.setEmail((String) customerMap.get("email"));
	    
	    Assertions.assertEquals(customer.getName(), savedCustomer.getName());
	    Assertions.assertEquals(customer.getEmail(), savedCustomer.getEmail());
	}
	
	@Given("Customer with invalid cpf")
	public void customerWithInvalidCpf() {
		customer = new CustomerRequest();
		customer.setName("Name test");
		customer.setCpf("12345678910");
		customer.setEmail("test2@gmail.com");
		customer.setPassportNumber("TZ123456");
		customer.setPassword("Password@1");
	}
	
	@When("Customer failed to save")
	public void customerFaildToSave() {
		response = request.body(customer).when().post("/customer");
        response.then().statusCode(400);
	}
	
	@Then("notify cpf is invalid")
	public void notifyInvalidCpf() {
		String failReason = response.jsonPath().get("[0].message");
        Assertions.assertEquals("número do registro de contribuinte individual brasileiro (CPF) inválido", failReason);
	}
	
	@And("Custumer is still not save")
	public void customerIsStillNotSave() {
		response = request.when().get("/customer/cpf/" + customer.getCpf());
	    response.then().statusCode(404);
	    
	    String jsonResponse = response.getBody().asString();
	    System.out.println("JSON Response: " + jsonResponse);
	    String failReason = response.getBody().asString();
	    Assertions.assertEquals("CPF not found", failReason);
	    
	    
	}

}
