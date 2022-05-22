
//import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class Example {
	
	static Playwright playwright;
	static Browser browser;
	static Page page;
	
	/** navigate to the homepage */
	
	public static void TC_001()
	{
		playwright = Playwright.create();
	    browser = playwright.chromium().launch(
	    		new BrowserType.LaunchOptions() 
	    			.setHeadless(false)
	    			.setSlowMo(100));
	    page = browser.newPage();
	    page.navigate("https://demo.guru99.com/v4/index.php");
	}
	
	/** Login */
	
	public static void TC_002()
	{
		TC_001();
		page.fill("input[name=\"uid\"]", "mngr408769");
		page.fill("input[name=\"password\"]", "anasAgA");
		page.locator("xpath = /html/body/form/table/tbody/tr[3]/td[2]/input[1]").click();
	}
	
	/** logout */
	
	public static void TC_003()
	{
		TC_002();
		page.locator("xpath = /html/body/div[3]/div/ul/li[15]/a").click(); //click logout button
	}
	
	/** edit customer */
	
	public static void TC_004()
	{
		TC_002();
		page.locator("text=Edit Customer").click(); //click edit customer button from left sidebar
		page.fill("input[name=\"cusid\"]", "22055"); //entry customer id
		page.locator("xpath = /html/body/div[2]/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input[1]").click(); //click submit
		page.fill("input[name=\"city\"]", "Barisal"); //edit city
		page.fill("textarea[name=\"addr\"]", "Pallabi!!!");	 //edit address
		page.locator("xpath = /html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input[1]").click(); //click submit
	}
	
	/** Delete Customer */
	public static void TC_005()
	{
		TC_002();
		page.locator("xpath = /html/body/div[3]/div/ul/li[4]/a").click(); //click delete customer button from left sidebar
		page.fill("input[name=\"cusid\"]", "68628"); //entry customer id
		page.locator("xpath = /html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input[1]").click(); //click submit
		page.onDialog(dialog -> dialog.accept());
	}
	
	public static void main(String[] args) {
		TC_005();
	  }
}