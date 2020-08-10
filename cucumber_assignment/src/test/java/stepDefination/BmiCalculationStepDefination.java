package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BmiCalculationStepDefination {

	public WebDriver driver;

	public WebDriverWait wait;

@Given("^launch bmi calculator$")
public void launch_bmi_calculator() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://www.calculator.net/");
    driver.manage().window().maximize();

   
}

@Then("^verify title of the page$")
public void verify_title_of_the_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	wait  = new WebDriverWait(driver,40);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='logo']//a//img")));
    Assert.assertTrue("BMI Calculator title is displayed successfully", driver.findElement(By.xpath("//div[@id='logo']//a//img")).isDisplayed());

}

@When("^click on BMI calculator$")
public void click_on_BMI_calculator() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	wait  = new WebDriverWait(driver,40);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'BMI Calculator')]"))).click();

   
}

@Then("^verify title of bmi calculator page$")
public void verify_title_of_bmi_calculator_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'BMI Calculator')]")));
    Assert.assertTrue("BMI Calculator title is displayed successfully", driver.findElement(By.xpath("//h1[contains(text(),'BMI Calculator')]")).isDisplayed());

    
}

@When("^enter values for \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and click on Calculate$")
public void enter_values_for_and_click_on_Calculate(String age, String height, String weight) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("cage")).clear();
	driver.findElement(By.id("cage")).sendKeys(age);
	driver.findElement(By.id("cheightmeter")).clear();
	driver.findElement(By.id("cheightmeter")).sendKeys(height);
	driver.findElement(By.id("ckg")).clear();
	driver.findElement(By.id("ckg")).sendKeys(weight);
	driver.findElement(By.xpath("//input[@value='Calculate']")).click();

    
}

@When("^retrieve corresponding BMI value$")
public void retrieve_corresponding_BMI_value() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	String bmi_value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Result')]/following::b[1]"))).getText();
	System.out.println(bmi_value);

}

@Then("^close the browser$")
public void close_the_browser() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   driver.quit();
}
}