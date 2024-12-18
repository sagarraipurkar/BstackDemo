package App.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import App.PageObjects.HomePage;
import App.Utilities.Retry;
import App.Utilities.common_components;

public class login extends common_components {
	
	@Test(retryAnalyzer = Retry.class)
	public void Verifying_login() throws IOException, InterruptedException {
	HomePage HomePage = new HomePage(driver);
	HomePage.Login("demo");	
	String UserName = HomePage.getUserName();
//	Thread.sleep(2000);
//	String EnteredUserName = HomePage.EnteredUserName();
	System.out.println(UserName);
	assertEquals(UserName, "demouser");
	}
}
