package com.urbanladder.definitions;

import org.testng.Assert;

import com.urbanladder.actions.BookshelvesPageActions;
import com.urbanladder.actions.HeaderActions;
import com.urbanladder.utils.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class homePageDefinitions {

	HeaderActions objHeaderAction = new HeaderActions();
	BookshelvesPageActions objBookShelfPageAction = new BookshelvesPageActions();
	@Given("navigate to home page")
	public void navigate_to_home_page() {
		
		HelperClass.openPage("https://www.urbanladder.com/");
		
	}
	@Given("handle banner")
	public void handle_banner() {
		
		
	}
	
	@When("searched for bookshelves")
	public void searched_for_bookshelves() {
		// TODO: check whether fn name crt
		try {
		
		Assert.assertEquals(objHeaderAction.CheckSearch(), true,"Search input not found");
		objHeaderAction.SendInput("BookShelves");
			
		Assert.assertEquals(objHeaderAction.CheckSearchButton(), true, "Search button not found");
		objHeaderAction.ClickSearchButton();
		}catch (AssertionError e) {
			System.err.println(e);
			searched_for_bookshelves();
		}
	}
	@Then("display searched results")
	public void display_searched_results() {
		try {
			Assert.assertEquals(objBookShelfPageAction.checkBookShelfUrl(), true,"Page Not Redirected");
			
		}catch (AssertionError e) {
			
			System.err.println(e);
			display_searched_results();
		}
		
	}



}