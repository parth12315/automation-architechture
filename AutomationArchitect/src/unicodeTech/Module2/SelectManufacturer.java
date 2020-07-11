package unicodeTech.Module2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import unicodeTech.BasePackage.BaseInit;

public class SelectManufacturer extends BaseInit{

	@BeforeTest
	public void setUP() throws Exception {
		
		startUP();
	}
	
	
	@Test
	public void testSelectManufacturer() {
		
		driver.get(storage.getProperty("url"));
		
		WebElement manufacturer = isElementPresent("dd_manufacturer_name");
		List<WebElement> manufacturerVal = manufacturer.findElements(By.tagName("option"));
		
		
		for(int count=1;count<manufacturerVal.size();count++) {
			
			logs.info(manufacturerVal.get(count).getText());
			
			
		}
		
		
		
		
		
		
	}
}
