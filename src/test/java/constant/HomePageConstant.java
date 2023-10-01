package constant;

import org.openqa.selenium.By;

public class HomePageConstant {

    //URL
    public static final String HOME_PAGE_URL = "https://useinsider.com/";

    //Locators
    public static final By ALLOW_COOKIES = By.id("wt-cli-accept-all-btn");
    public static final By MORE_DROPDOWN = By.xpath("(//li[@class=\"nav-item dropdown\"]/a[contains(text(),'Company')])");
    public static final By DROPDOWN_CAREERS = By.xpath("//a[@href='https://useinsider.com/careers/']");

    //Texts
    public static final String HOME_PAGE_TITLE = "#1 Leader in Individualized, Cross-Channel CX — Insider";

}