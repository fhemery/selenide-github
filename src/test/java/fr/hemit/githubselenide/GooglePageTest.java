package fr.hemit.githubselenide;

import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class GooglePageTest extends BaseTest {

	@Test
	public void testGoogleHomePage(){
		open("http://www.google.fr");
		$("#hplogo").shouldBe(visible);
	}
}
