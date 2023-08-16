package Stepdefination;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Fbregisernewuser
{
	static WebDriver driver;
	
	@Given("User is on facebook page")
	public void user_is_on_facebook_page() {
	     driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	    driver.get("https://www.facebook.com/reg/");
	    
	}

	@Then("Capture URL and Title of facebook")
	public void capture_url_and_title_of_facebook() {

		String title=driver.getTitle();
		Assert.assertEquals(title.contains("facebook"), true);
		
	}

	@When("User on register page")
	public void user_on_register_page() {
		Assert.assertEquals(driver.getCurrentUrl().contains("/reg/"), true);
	}

	@Then("user enter {string} and {string} and {string} and {string}")
	public void user_enter_and_and_and(String fname, String lname, String email, String mobile) {
	    driver.findElement(By.name("firstname")).sendKeys(fname);
	    driver.findElement(By.name("lastname")).sendKeys(lname);
	    driver.findElement(By.name("reg_email__")).sendKeys(email);
	    driver.findElement(By.name("reg_passwd__")).sendKeys(mobile);
	}

	@Then("caputure Screenshot")
	public void caputure_screenshot() throws IOException {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File f= ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir") + "//foldername//" + date() + ".png";
		FileUtils.copyFile(f, new File (path));
	}

	public String date()
	{
		return new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
	}
	
//	@AfterStep
//	public static void tearDowm(Scenario scenario) {
//		if (scenario.isFailed()) {
//
//			byte[] f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(f,"image/png",scenario.getName());
//		}
//		else {
//			byte[] f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(f,"image/png",scenario.getName());
//		}

	
	
	
}
