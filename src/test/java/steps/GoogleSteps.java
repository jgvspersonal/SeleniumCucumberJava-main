package steps;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pages.GooglePage;

public class GoogleSteps {

    GooglePage google = new GooglePage(); //Creamos la instancia de la clase GooglePage
    
    @Given("^I am on the Google search page$")
    public void navigateToGoogle(){
        google.navigateToGoogle();//Abre una instancia del webdriver que va a estar navegando a Google
        
    }

    @When("^I enter a search criteria$")
    public void enterSearchCriteria(){

        google.enterSearchCriteria("Colombia");
    }

    @And("^click on the search button$")
    public void clickSearchButton(){

        google.clickGoogleSearch();
    }

    @Then("^the results match the criteria$")
    public void validateResults(){

        Assert.assertEquals("Colombia", google.firstResult());
    }
}
