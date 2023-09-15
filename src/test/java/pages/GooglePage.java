package pages;

public class GooglePage extends BasePage{

    private String searchButton = "//body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[1]/div[1]/span[1]";
    private String searchTextField = "//textarea[@id='APjFqb']";
    private String firstResult = "//body/div[@id='main']/div[@id='cnt']/div[@id='rcnt']/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]";

    public GooglePage(){

        super(driver);
    }

    public void navigateToGoogle(){

        navigateTo("https://www.google.com");
    }

    public void clickGoogleSearch(){

        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){

        write(searchTextField, criteria);
    }

    public String firstResult(){

        return textFromElement(firstResult);
    }


}
