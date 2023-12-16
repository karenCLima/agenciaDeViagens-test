Feature: Save Customer
	
	Scenario: Customer is not saved
		Given Customer is not saved
		When Customer is saved successfully
		Then Customer is saved
		
		
	Scenario: Customer with invalid cpf
		Given Customer with invalid cpf
		When Customer failed to save
		Then notify cpf is invalid
		And Custumer is still not save
		