package pages;

import static org.junit.Assert.*;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {

    WebDriver driver = Driver.get();
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[id=postcode]") /*#######*/ public WebElement postCodeInput;

    @FindBy(className = "btn-gets") /*#######*/ public WebElement getStartedBtn;

    @FindBy(xpath = "//h1") /*#######*/ public WebElement pageText;
    String expectedPageText ="Fresh milk and groceries delivered plastic free";

    @FindBy(xpath = "//*[starts-with(@class,'btn-signin')]") /*#######*/ public WebElement signInBtn;

    @FindBy(id = "phoneNo") /*#######*/ public WebElement phoneInput;

    @FindBy(id = "password") /*#######*/ public WebElement passwordInput;

   @FindBy(id = "btn_submit") /*#######*/ public WebElement loginBtn;

   @FindBy(xpath = "//*[@class=\"swal2-header\"]/h2") public WebElement errorTxt;
   String expectedErrorTxt="Error!";

   @FindBy(xpath = "//*[@class=\"swal2-content\"]/div") public WebElement errorDetailsTxt;
   String errorExpectedErrorDetail="The Phone Number or Password is incorrect. Please enter valid login details.";

   @FindBy(css = "[class=buy-btn-cat]") /*#######*/ public WebElement okBtn;

   @FindBy(css = "[class='col-6 col-sm-3']") /*#######*/ public List<WebElement> products;

   @FindBy(css = "[class='account dropdown']") /*#######*/ public WebElement accountIcon;

   @FindBy(xpath = "//*[@class=\"dropdown-menu show\"]/li") /*#######*/ public List<WebElement> accountOptions;

   @FindBy(xpath = "//*[@class=\"top-hading-accoutn\"]/a") /*#######*/ public WebElement editAccountBtn;

   @FindBy(xpath = "//*[text()=\"Save\"]")  /*#######*/ public WebElement editSaveBtn;

   @FindBy(xpath = "//*[@id=\"swal2-title\"]")  public WebElement savedSuccess;




   public void navigateLandingPage(){
       String actualPageText = pageText.getText();
       assertEquals(expectedPageText,actualPageText);
       assertTrue(getStartedBtn.isDisplayed());
   }

   public void clickSignIn(){
       signInBtn.click();
       String pageUrl="https://tst.themodernmilkman.co.uk/Users/login";

       assertEquals(pageUrl,driver.getCurrentUrl());
   }

   public void enterCredentials(String mobile, String password){
       phoneInput.sendKeys(mobile);
       passwordInput.sendKeys(password);
   }

   public void login(){
       loginBtn.click();
   }


   public void verifyLogin(){
       assertEquals(products.get(0).getText(),"Milk");

   }

   public void verifyErrorLoginWithInvalidCred(String error, String errorDetails){

       assertEquals(error,errorTxt.getText());
       assertEquals(errorDetails,errorDetailsTxt.getText());
   }


   public void clickAccountIconAndSelectMyAccount(){
       accountIcon.click();

       for (int i = 0; i <accountOptions.size() ; i++) {

           if (accountOptions.get(i).getText().equals("My account")){
               accountOptions.get(i).click();
           }
       }
   }

   public void verifyAccountDetailsAndClickEditButton(){
       WebElement accountDetails= driver.findElement(By.xpath("//*[@class=\"account-information\"]/h2[1]"));
       String actualDetailsText =accountDetails.getText();
       String expectedText = "Account details";

       assertEquals(expectedText,actualDetailsText);

       editAccountBtn.click();
   }

   public void enterNewEmailAndClickSave(){

       WebElement emailInput= driver.findElement(By.cssSelector("[id=email]"));

       BrowserUtils.setAttribute(emailInput,"value",new Faker().internet().emailAddress());

       editSaveBtn.click();

   }
   public void emailUpdateVerification(){
       BrowserUtils.waitForVisibility(savedSuccess,10);
       assertEquals("Success",savedSuccess.getText());
   }
}
