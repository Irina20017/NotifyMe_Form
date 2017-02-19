package testcase;



import dms.dmsHome;
import dms.dmsHome2;
import dmsDealers.Dealers;
import notifyMePage.NotifyMe;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utility.PropertyLoader;
import webdriver.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Home on 28.01.2017.
 */
public class TestBase2 {


    protected WebDriver driver;
    public String baseUrl;
    protected NotifyMe notifyMe;
    protected dms.dmsHome dmsHome;
    protected dms.dmsHome2 dmsHome2;
    protected dmsDealers.Dealers dealers;


    @BeforeClass
    @Parameters({ "browserName" })
    public void setup(String browserName) throws Exception {

        //  LOG.info("Navigating to test url");
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        baseUrl = PropertyLoader.loadProperty("site.url");
       // driver.get(baseUrl+"/notify");
       // driver.get(PropertyLoader.loadProperty("dws.url"));
        notifyMe = PageFactory.initElements(driver, NotifyMe.class);
        dmsHome = PageFactory.initElements(driver, dmsHome.class);
        dmsHome2 = PageFactory.initElements(driver, dmsHome2.class);


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            //   LOG.info("Killing web driver");
            WebDriverFactory.killDriverInstance();
        }
    }

    protected String getBaseUrl() {
        return baseUrl;
    }
}
