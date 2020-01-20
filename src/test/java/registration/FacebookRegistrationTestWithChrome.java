package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class FacebookRegistrationTestWithChrome {

    public WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        // 1. Launch google chrome
        System.setProperty("webdriver.chrome.driver",
                "/Users/faizhamid/IdeaProjects/facebook/src/main/java/Driver/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().window().fullscreen();
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    // 10. Close the browser
    public void setClosing(){
        this.driver.close();
    }

    @Test
    public void testUserCannotRegisterIfEmailIsNotProvided() {

        // 2. Navigate to facebook.com
        String facebookUrl = "https://www.facebook.com/";
        driver.get(facebookUrl);

        // 3. Provide in first name
        driver.findElement(By.name("firstname")).sendKeys("John");

        // 4. Provide in last name
        driver.findElement(By.name("lastname")).sendKeys("Doe");

        // 5. Provide in password
        driver.findElement(By.name("reg_passwd__")).sendKeys("Test123");

        // 6. Provide in Date of Birth
        // July 21, 1994
        Select monthDropdown = new Select(driver.findElement(By.id("month")));
        Select dayDropdown = new Select(driver.findElement(By.name("birthday_day")));
        Select yearDropdown = new Select(driver.findElement(By.id("year")));

        monthDropdown.selectByValue("7");
        dayDropdown.selectByValue("21");
        yearDropdown.selectByValue("1994");

        // 7. Provide in gender (male).
        driver.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();

        // 8. Click on the submit button.
        driver.findElement(By.name("websubmit")).click();

        // 9. Assert that the popup is shown.
        // WebElement popup = driver.findElement(By.name(""));
        // boolean popUpIsDisplayed = popup.isDisplayed();
        // Assert.assertEquals(popUpIsDisplayed, true);
    }
}
