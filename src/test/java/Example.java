
import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class Example {
	static Playwright playwright;
	static Browser browser;
	static Page page;
	
	public static void navigate()
	{
		playwright = Playwright.create();
	    browser = playwright.chromium().launch(
	    		new BrowserType.LaunchOptions() 
	    			.setHeadless(false)
	    			.setSlowMo(100));
	    page = browser.newPage();
	    page.navigate("https://demo.guru99.com/v4/index.php");
	}
	
	public static void login()
	{
		navigate();
		page.fill("input[name=\"uid\"]", "mngr408769");
		page.fill("input[name=\"password\"]", "anasAgA");
		page.locator("xpath = /html/body/form/table/tbody/tr[3]/td[2]/input[1]").click();
	}
	
	public static void main(String[] args) {
		login();
	  }
}