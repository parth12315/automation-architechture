package unicodeTech.Module2;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import unicodeTech.BasePackage.BaseInit;
import unicodeTech.Utility.MyLibrary;

public class SearchProduct extends BaseInit{

	@BeforeTest
	public void setUP() throws Exception {
		
		startUP();
	}
	
	
	@Test(dataProvider="gettestData")
	public void testSearchProduct(String keyword) {
		
		driver.get(storage.getProperty("url"));
		isElementPresent("ip_quickfind_name").sendKeys(keyword);
		isElementPresent("ip_quickfind_name").sendKeys(Keys.ENTER);
		
		
	}
	
	@DataProvider
	public Object[][] gettestData() {
		
		return MyLibrary.getTestData(data, "SearchProduct");
	}
	
}
