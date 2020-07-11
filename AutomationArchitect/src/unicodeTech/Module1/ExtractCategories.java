package unicodeTech.Module1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import unicodeTech.BasePackage.BaseInit;

public class ExtractCategories extends BaseInit{

	@BeforeTest
	public void setUP() throws Exception {
		
		startUP();
	}
	
	@Test
	public void testExtractCategories() {
		
		driver.get(storage.getProperty("url"));
		
		WebElement category = isElementPresent("div_category_xpath");
		
		List<WebElement> categoryList = category.findElements(By.tagName("a"));
		
		for(int count=0;count<categoryList.size();count++) {
			
			logs.info(categoryList.get(count).getText());
		}
		
		
	}
}
