package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (id= "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='a-section aok-relative s-image-square-aspect']")
    public WebElement firstResult;

    @FindBy(xpath = "//input[@class='a-button-input celwidget']")
    public WebElement acceptCookies;

    @FindBy(xpath = "//div[@id='corePriceDisplay_desktop_feature_div']")
    public WebElement priceOfProduct;


}
