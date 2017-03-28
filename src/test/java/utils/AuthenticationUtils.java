package utils;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthenticationUtils {
	public static void login(){
		open("https://github.com/login");
		// $("#login_field")
		$(byId("login_field")).setValue("###CHANGEME#####");
		$(byId("password")).setValue("####CHANGEME####");
		$(byName("commit")).click();
		$(byText("selenide-github")).shouldBe(visible);
	}
	
	public static void logout(){
		$(byAttribute("aria-label", "View profile and more")).click();
		$(byText("Sign out")).click();
	}
}
