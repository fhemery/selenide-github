package fr.hemit.githubselenide;

import static com.codeborne.selenide.Configuration.browser;

import org.junit.Before;

public class BaseTest {
	@Before
	public void setUp(){
		browser = "chrome";
		System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver.exe");
	}
}
