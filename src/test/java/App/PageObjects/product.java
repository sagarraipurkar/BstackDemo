package App.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class product {

	WebDriver driver;

	public product(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='shelf-item']")
	List<WebElement> productList;

	By productname = By.cssSelector("p[class='shelf-item__title']");

	By addtocart = By.cssSelector("div[class='shelf-item__buy-btn']");

	@FindBy(css = "div[class='buy-btn']")
	WebElement checkoutButton;

	public List<WebElement> getProductList() {
		return productList;

	}

	public WebElement getProductByName(String ProductName) {
		WebElement prod = getProductList().stream().filter(product -> product
				.findElement(By.cssSelector("p[class='shelf-item__title']")).getText().equals(ProductName))
				.findFirst().orElse(null);
		return prod;
	}

	public void addtoCart(String ProductName ) {
		WebElement prod = getProductByName(ProductName);
		prod.findElement(addtocart).click();
	}

	public void clickOnCheck() {
		checkoutButton.click();
	}

}
