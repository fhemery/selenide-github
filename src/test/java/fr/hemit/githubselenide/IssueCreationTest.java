package fr.hemit.githubselenide;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import utils.AuthenticationUtils;

@Ignore
public class IssueCreationTest extends BaseTest {

	@Before
	public void setUp() {
		super.setUp();
		AuthenticationUtils.login();
	}
	
	@After
	public void tearDown(){
		AuthenticationUtils.logout();
	}
	
	@Test
	public void test() {		
		open("https://github.com/fhemery/selenide-github/issues/new");
		
		SelenideElement buttonSubmit = $(byText("Submit new issue"));
		buttonSubmit.shouldBe(disabled);
		$(byId("issue_title")).setValue("My first issue");
		$(byId("issue_body")).setValue("This project is awesome!");
		buttonSubmit.shouldNotBe(disabled);
		//buttonSubmit.click();
	}

	
	
	@Test
	public void testIssueShouldBeDisplayed(){
		open("https://github.com/fhemery/selenide-github/issues/8");
		assertEquals("My toto", $(byClassName("js-issue-title")).text());
		
	}

}
