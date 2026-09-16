package seleniumFrameworkDesign.tests;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import seleniumFrameworkDesign.TestComponents.BaseTest;
import seleniumFrameworkDesign.pageobjects.AllOrdersPage;
import seleniumFrameworkDesign.pageobjects.ConfirmationPage;
import seleniumFrameworkDesign.pageobjects.OrderPlacedPage;
import seleniumFrameworkDesign.pageobjects.PaymentPage;
import seleniumFrameworkDesign.pageobjects.ProductCatalogue;

public class StartingPageTest extends BaseTest {
	
	//public String pname="ZARA COAT 3";

	@Test(dataProvider="dataProvider")
	public void orderFlow(HashMap<String,String> data) throws IOException {
		
		
		String countryName="India";
		String finalmsg="THANKYOU FOR THE ORDER.";
		
		ProductCatalogue pc=lp.login(data.get("email"), data.get("password"));
	
		pc.addToCart(data.get("pname"));
		ConfirmationPage cp=pc.goToCart();
		
		String prodname=cp.CheckCart();
		Assert.assertEquals(prodname, data.get("pname"));
		PaymentPage pp=cp.checkoutprod();

		
		pp.EnterCountry(countryName);
		pp.SelectCountry(countryName);
		OrderPlacedPage opp=pp.submit();
			
		
		String actual=opp.checkmsg();
		Assert.assertEquals(actual, finalmsg);

	}
	
	@Test(dependsOnMethods= {"orderFlow"},dataProvider="dataProvider")
	public void checkingOrders(HashMap<String,String> data) {
		lp.login(data.get("email"), data.get("password"));
		AllOrdersPage aop=lp.goToOrders();
		Assert.assertTrue(aop.OrderInOrders(data.get("pname")));
	}
	
	@DataProvider
	public Object[][] dataProvider() throws IOException {
		List<HashMap<String, String>> li=jsonToMap();
		return new Object[][] {{li.get(0)},{li.get(1)}};
		
	}
	

}
