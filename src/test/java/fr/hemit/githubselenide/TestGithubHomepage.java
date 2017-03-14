package fr.hemit.githubselenide;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.codeborne.selenide.SelenideElement;

public class TestGithubHomepage {

	@Before
	public void setUp() {
		browser = "chrome";
		System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver.exe");
		open("https://www.github.com");
	}
	
	@Test
	public void testCanReachGithubHomePage() {
		assertTrue(true);
	}
	
	@Test
	public void testBuiltForDeveloppersAppearsOnScreen(){
		$("h1").shouldBe(visible);
		assertEquals("Built for developers", $("h1").text());
	}
	
	@Test
	public void testLinkTermsOfServiceShouldRedirect(){
		SelenideElement link = $(byLinkText("terms of service"));
		link.shouldBe(visible);
		link.click();
		switchTo().window(1);
		$(byText("GitHub Terms of Service")).shouldBe(visible);
		$(".article-body p").shouldBe(visible);
	}

	

}
