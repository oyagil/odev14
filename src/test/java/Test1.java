import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test1 {
    private WebDriver driver;

    @Before
    public void setUp() {
        // WebDriver'ı başlat
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testButtonClick() {

        driver.get("https://demoqa.com/elements");

        WebElement buttonClick = driver.findElement(new By.ByCssSelector(".btn[id=item-4]"));
        buttonClick.click();

        List<WebElement> clickMeButton = driver.findElements(new By.ByCssSelector(".btn-primary"));

        clickMeButton.get(2).click();

        WebElement dynamicText = driver.findElement(new By.ByCssSelector("#dynamicClickMessage"));
        String text = dynamicText.getText();
        System.out.println(text);
    }

    @After
    public void after() {
        driver.quit();
    }
}


