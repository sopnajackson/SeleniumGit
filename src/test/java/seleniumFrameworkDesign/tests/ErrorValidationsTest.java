package seleniumFrameworkDesign.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import seleniumFrameworkDesign.TestComponents.BaseTest;
import seleniumFrameworkDesign.TestComponents.RetryTest;
import seleniumFrameworkDesign.pageobjects.ConfirmationPage;
import seleniumFrameworkDesign.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {
	
	
	@Test(groups={"loginValidation"}, retryAnalyzer=RetryTest.class)
	public void loginErrValidation() {
		lp.login("sopna@gmail.com", "Sopna@27301989");
		Assert.assertEquals(lp.errorMessage(), "Incorrect email or password.");
		System.out.println("3");
	}
		
	@Test(dataProvider="dataProvide", retryAnalyzer=RetryTest.class)
	public void productErr(HashMap<String, String> hm) {
		ProductCatalogue pc=lp.login(hm.get("email"), hm.get("password"));
		pc.addToCart(hm.get("pname"));
		ConfirmationPage cp=pc.goToCart();
		String actual=cp.CheckCart();
		Assert.assertNotEquals("NO ITEM IN CART", actual);
			
	}
	
	@DataProvider
	public Object[][] dataProvide() throws IOException {
		List<HashMap<String, String>> li=jsonToMap();
		return new Object[][] {{li.get(0)},{li.get(1)}};
			
		}
	
	
}
