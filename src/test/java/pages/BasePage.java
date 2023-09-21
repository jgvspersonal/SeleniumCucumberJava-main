package pages;

import java.util.List;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
public class PageFactoryPage extends BasePage{

    @FindBy(id="boton")
    WebElement boton;

    public PageFactoryPage(){
        super(driver);
        driver.get("www.google.com");
    }
}
*/

public class BasePage {
    
    protected static WebDriver driver; //Que halla una sola instancia del webdriver compartida para todas las clases
    private static WebDriverWait wait;
    private static Actions action;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\CURSO SELENIUM CON JAVA Y CUCUMBER\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions(); //Estamos creando una instancia
        driver = new ChromeDriver(chromeOptions); //Se crea el objeto del driver
        wait = new WebDriverWait(driver,20); //Se crea el objeto wait
    
    }

    //Ahora necesitamos crear un constructor de la clase BasePage
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
        BasePage.maximizeBrowser();
    }

    //Ahora creamos nuestra primera función
    public static void navigateTo(String url){

        driver.get(url);
    }

    public void goToLinkText(String linkText){

        driver.findElement(By.linkText(linkText)).click();
    }

    public static void maximizeBrowser(){

        driver.manage().window().maximize();
    }

    public static void closeBrowser(){
        driver.quit();
        
    }


    //Creamos un webelement que es una función privada que devuelve un webelement
    //es privada pq no necesito que este afuer a de esta clase, la idea es hacerlo una sola vez
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator));

        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select (Find(locator));

        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator));

        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        return Find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        Find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameIndex){

        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame(){

        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        try{
        driver.switchTo().alert().dismiss();

            }catch(NoAlertPresentException e){
                e.printStackTrace();
            }
    }

    public String textFromElement(String locator){

        return Find(locator).getText();
    }

    public boolean elementEnabled(String locator){
        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }



}
