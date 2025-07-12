import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FormValidationTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/pramod/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
    }

    @Test
    public void testRequiredFieldsValidation() {
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        WebElement errorMsg = driver.findElement(By.xpath("//small[contains(text(),'Please supply your first name')]"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not shown!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
