@Regression
Feature: BMI Calculation
	Calculate BMI for five different users
	
	@Regression
	Scenario Outline: Calculate BMI value 
	Given launch bmi calculator
	Then verify title of the page
	When click on BMI calculator
	Then verify title of bmi calculator page
	When  enter values for "<age>","<height>","<weight>" and click on Calculate
	And   retrieve corresponding BMI value
	Then  close the browser
		
	Examples:
			| age | height | weight |
			| 10 | 127 | 40 |
			| 30 | 156 | 70 |
			| 25 | 152 | 55 |
			| 20 | 160 | 45 |
			| 35 | 160 | 70 |