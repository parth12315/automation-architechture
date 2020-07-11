package unicodeTech.Module1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import unicodeTech.BasePackage.BaseInit;
import unicodeTech.Utility.MyLibrary;

public class ValidateUser extends BaseInit{

	@BeforeTest
	public void setUP() throws Exception {
		
		startUP();
	}
	
	
	@Test(dataProvider="gettestData")
	public void testValidateUSer(String email, String pwd) throws InterruptedException {
		
		driver.get(storage.getProperty("url"));
		
		MyLibrary.signIN(email,pwd);
		
		MyLibrary.getScreenShot("AfterLogin", driver);
		
		Thread.sleep(2000);
		
		try {
		
		if(isElementPresent("lnk_logoff_linkText").isDisplayed()) {
			
			logs.info("User has been logged in...");
			MyLibrary.signOUT();

		}
		
		}catch(Exception e) {
			
			logs.info("Invalid credentials");
			MyLibrary.getScreenShot("InvalidLogin", driver);
		}
		
	}
	
	@DataProvider
	public Object[][] gettestData() {
		
		return MyLibrary.getTestData(data, "ValidateUser");
	}
	
}
