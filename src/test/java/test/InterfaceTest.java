package test;

import base.Base;
import org.testng.ITestListener;
import org.testng.annotations.*;
import pages.HomePage;
import pages.CareersPage;
import pages.OpenPositionsPage;

@Listeners(Listener.class)
public class InterfaceTest extends Base implements ITestListener {

    HomePage homePage;
    CareersPage careersPage;
    OpenPositionsPage openPositionsPage;

    @BeforeTest
    public void beforeTest(){
        homePage = new HomePage(getWebDriver());
        careersPage = new CareersPage(getWebDriver());
        openPositionsPage = new OpenPositionsPage(getWebDriver());
    }

    @Test (priority = 1)
    public void homePageTest(){
        homePage.checkPage().
                goCareers();

    }

    @Test (priority = 2)
    public void careersPageTest(){
        careersPage.checkPage().
                ourLocations().
                lifeAtInsider().
                teams().
                qualityAssurance();
    }

    @Test (priority = 3)
    public void openPositionsPageTest(){
        openPositionsPage.checkPage().
                chooseFilters().
                opportunities().
                jobDescription();
    }

}
