package App.Test;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.testng.annotations.Test;
import App.PageObjects.Checkout;
import App.PageObjects.product;
import App.Utilities.Retry;
import App.Utilities.common_components;

public class AddToCartProduct extends common_components {

	String ProductName = "iPhone 12 Mini";

	@Test(retryAnalyzer = Retry.class)
	public void Verifying_add_the_product_into_the_cart() throws InterruptedException {
		product product = new product(driver);
		product.getProductList();
		product.getProductByName(ProductName);
		product.addtoCart(ProductName);

	}

	@Test(groups = { "AddToCart" })
	public void checkoutProduct() throws IOException, InterruptedException {
		login Login = new login();
		Login.Verifying_login();
		product product = new product(driver);
		product.getProductList();
		product.getProductByName(ProductName);
		product.addtoCart(ProductName);
		Thread.sleep(2000);
		product.clickOnCheck();
		Checkout checkout = new Checkout(driver);
		checkout.enterCheckoutDetails("John", "Doe", "36 Town china", "Chicago", "453421");
		checkout.clickOnCheckout();
		String message = checkout.getSuccessMessage();
		System.out.println(message);
		assertEquals(message, "Your Order has been successfully placed.");
	}

}
