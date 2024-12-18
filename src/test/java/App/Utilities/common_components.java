package App.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class common_components {

	protected static WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	public void lauchBrowser() throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Eclipse New\\NewWorkSpace\\BStackPageObjectModel\\src\\test\\java\\App\\Utilities\\global.properties");
		Properties prop = new Properties();
		prop.load(file);
		String url = prop.getProperty("baseurl");
		String browser = prop.getProperty("browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);

		if (browser.equalsIgnoreCase("chromer")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.bstackdemo.com/");

	}
	
	@AfterMethod (alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	public String getScreenshot(String TestCaseName , WebDriver driver) throws IOException {
		File file = new File(System.getProperty("user.dir")+ "\\target\\" + TestCaseName +".jpg");
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, file);
		return  System.getProperty("user.dir")+ "\\target\\" + TestCaseName +".jpg";
	}

}
