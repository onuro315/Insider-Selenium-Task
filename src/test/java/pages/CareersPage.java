package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import static constant.CareersPageConstant.*;

public class CareersPage extends BasePage {

    public CareersPage(WebDriver driver){ super(driver); }

    public CareersPage checkPage(){
        scrollIntoView(OUR_LOCATIONS_PATH);
        Assert.assertNotNull(findElement(OUR_LOCATIONS_PATH));
        Assert.assertEquals(getURL(), CAREERS_PAGE_URL);
        Assert.assertEquals(getTitle(), CAREER_PAGE_TITLE);
        return this;
    }

    public CareersPage ourLocations(){
        Assert.assertEquals(getText(OUR_LOCATIONS_TITLE_PATH), OUR_LOCATIONS_TITLE_TEXT);
        Assert.assertEquals(getText(OUR_LOCATIONS_TEXT_PATH), OUR_LOCATIONS_TEXT);
        Assert.assertNotNull(findElement(OUR_LOCATIONS_SLIDER));
        Assert.assertEquals(findElements(OUR_LOCATIONS_LIST_PATH).size(), OUR_LOCATIONS_LIST_SIZE);
        Assert.assertEquals(findElements(OUR_LOCATIONS_LIST_FIGURE_PATH).size(), OUR_LOCATIONS_LIST_SIZE);
        return this;
    }

    public CareersPage lifeAtInsider(){
        scrollIntoView(LIFE_AT_INSIDER_TITLE_PATH);
        Assert.assertEquals(getText(LIFE_AT_INSIDER_TITLE_PATH), LIFE_AT_INSIDER_TITLE_TEXT);
        Assert.assertEquals(getText(LIFE_AT_INSIDER_TEXT_PATH), LIFE_AT_INSIDER_TEXT);
        Assert.assertNotNull(findElement(LIFE_AT_INSIDER_WRAPPER));
        return this;
    }

    public CareersPage teams(){
        javascriptClick(SEE_ALL_TEAMS_PATH);
        waitToLoad();
        scrollIntoView(SEE_ALL_TEAMS_EXTENDED_PATH);
        Assert.assertNotNull(findElement(SEE_ALL_TEAMS_EXTENDED_PATH));
        Assert.assertEquals(JOB_COUNT, findElements(SEE_ALL_TEAMS_LIST_PATH).size());
        Assert.assertEquals(JOB_COUNT, findElements(SEE_ALL_TEAMS_IMAGES_PATH).size());
        Assert.assertEquals(JOB_COUNT, findElements(SEE_ALL_TEAMS_TITLE_PATH).size());
        Assert.assertEquals(JOB_COUNT, findElements(SEE_ALL_TEAMS_DESCRIPTION_PATH).size());
        javascriptClick(QA_CAREER);
        return this;
    }

    public CareersPage qualityAssurance(){
        scrollIntoView(QUALITY_ASSURANCE_JOBS_PATH);
        Assert.assertEquals(getURL(), QA_CAREER_PAGE_URL);
        Assert.assertNotNull(findElement(QUALITY_ASSURANCE_JOBS_PATH));
        Assert.assertEquals(QUALITY_ASSURANCE_TITLE, getText(QUALITY_ASSURANCE_TITLE_PATH));
        Assert.assertEquals(QUALITY_ASSURANCE_TEXT, getText(QUALITY_ASSURANCE_DESCRIPTION_PATH));
        Assert.assertEquals(QUALITY_ASSURANCE_PAGE_TITLE, getTitle());
        javascriptClick(QUALITY_ASSURANCE_JOBS_PATH);
        return this;
    }
}
