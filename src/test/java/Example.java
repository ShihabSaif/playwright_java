
//import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class Example {
	static Playwright playwright;
	static Browser browser;
	static Page page;
	
	//navigate to the homepage
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
	
	//login
	public static void TC_002()
	{
		TC_001();
		page.fill("input[name=\"uid\"]", "mngr408769");
		page.fill("input[name=\"password\"]", "anasAgA");
		page.locator("xpath = /html/body/form/table/tbody/tr[3]/td[2]/input[1]").click();
	}
	
	//logout
	public static void TC_003()
	{
		TC_002();
		page.locator("xpath = /html/body/div[3]/div/ul/li[15]/a").click();
	}
	
	public static void main(String[] args) {
		TC_003();
	  }
}