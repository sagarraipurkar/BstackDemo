package App.PageObjects;

import java.util.ResourceBundle.Control;

import javax.swing.text.html.CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[class = 'Navbar_link__3Blki logout-link']")
	WebElement signLink;

	@FindBy(xpath = "//*[@id=\"username\"]/div/div[1]")
	WebElement usernameDropDownClick;

	@FindBy(css = "input[id='react-select-2-input']")
	WebElement enterUserName;

	@FindBy(css = "div[class=' css-1uccc91-singleValue']")
	WebElement enteredUsername;

	@FindBy(css = "input[id='react-select-2-input']")
	WebElement selectUserName;

	@FindBy(css = "#password > div > div.css-1hwfws3 > div.css-1wa3eu0-placeholder")
	WebElement clickPassword;

	@FindBy(css = "input[id='react-select-3-input']")
	WebElement selectPassword;

	@FindBy(id = "login-btn")
	WebElement clickLogin;

	@FindBy(css = "span[class='username']")
	WebElement UserName;
	
	@FindBy (css = "div[class=' css-1uccc91-singleValue']")
	WebElement EnteredUserName;
	
	public void Login(String username) {
		signLink.click();
		usernameDropDownClick.click();
		enterUserName.sendKeys(username);
		selectUserName.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
		clickPassword.click();
		selectPassword.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
		clickLogin.click();

	}

	public String getUserName() {
		return UserName.getText();
	}

	public String EnteredUserName() {
		return EnteredUserName.getText();
		
	}

}
