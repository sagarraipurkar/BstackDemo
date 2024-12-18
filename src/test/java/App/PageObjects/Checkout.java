package App.PageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
	WebDriver driver;

	public Checkout(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstNameInput")
	WebElement firtnameInput;

	@FindBy(id = "lastNameInput")
	WebElement lastNameInput;

	@FindBy(id = "addressLine1Input")
	WebElement addressLine1Input;

	@FindBy(id = "provinceInput")
	WebElement provinceInput;

	@FindBy(id = "postCodeInput")
	WebElement postCodeInput;

	@FindBy(id = "checkout-shipping-continue")
	WebElement checkoutButton;
	
	@FindBy (id = "confirmation-message")
	WebElement successMessage;


	public void enterCheckoutDetails(String firtname, String lastName, String address, String province, String postalocde) {
		firtnameInput.sendKeys(firtname);
		lastNameInput.sendKeys(lastName);
		addressLine1Input.sendKeys(address);
		provinceInput.sendKeys(province);
		postCodeInput.sendKeys(postalocde);
	}
	
	public void clickOnCheckout() {
		checkoutButton.click();
	}
	
	public String getSuccessMessage() {
		return	successMessage.getText();
	}

}

