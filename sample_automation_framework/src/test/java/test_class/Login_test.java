package test_class;

import org.testng.Assert;
import org.testng.annotations.Test;

import base_class.Base_class;
import page_object.Login_page_object;

public class Login_test extends Base_class {
	
	@Test(priority = 1)
	public void valid_login()
	{
		Login_page_object obj = new Login_page_object(driver);
		obj.enter_username("student");
		obj.enter_password("Password123");
		obj.click_submit();
		
		// validation
		String actual_url = obj.get_url();
		String expected = "https://practicetestautomation.com/logged-in-successfully/";
		Assert.assertEquals(actual_url, expected);
		System.out.println("Valid login successful");
	}
	
	@Test(priority = 2)
	public void invalid_username()
	{
		Login_page_object obj = new Login_page_object(driver);
		obj.enter_username("dent");
		obj.enter_password("Password123");
		obj.click_submit();
		
		// validation
		String actual = obj.error_message();
		String expected = "Your username is invalid!";
		Assert.assertEquals(actual, expected);
		System.out.println("Invalid login tested");
	}

}
