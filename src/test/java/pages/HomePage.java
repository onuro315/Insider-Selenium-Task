package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static constant.HomePageConstant.*;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage checkPage(){
        click(ALLOW_COOKIES);
        Assert.assertEquals(HOME_PAGE_TITLE, getTitle());
        Assert.assertEquals(HOME_PAGE_URL, getURL());
        return this;
    }

    public HomePage goCareers(){
        click(MORE_DROPDOWN);
        click(DROPDOWN_CAREERS);
        return this;
    }

}
