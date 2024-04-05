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

public class Test2 {

    private WebDriver driver;

    @Before
    public void setUp() {
        // WebDriver'ı başlat
        driver = new ChromeDriver();
        // Demoqa sitesine git
        driver.get("https://demoqa.com/webtables");
    }

    @Test
    public void testAddAndEditRecord() {
        WebElement addButton = driver.findElement(By.cssSelector(".btn-primary"));
        addButton.click();

        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Oya");

        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Demirtola");

        WebElement userEmail = driver.findElement(By.cssSelector("#userEmail"));
        userEmail.sendKeys("oyademirtola@gmail.com.tr");

        WebElement age = driver.findElement(By.cssSelector("#age"));
        age.sendKeys("30");

        WebElement salary = driver.findElement(By.cssSelector("#salary"));
        salary.sendKeys("99000");

        WebElement department = driver.findElement(By.cssSelector("#department"));
        department.sendKeys("IT");

        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        submitButton.click();

        // Düzenleme düğmesini bul
        WebElement editButton = driver.findElement(By.cssSelector("#edit-record-4"));

        // Düzenleme düğmesinin tıklanabilir olmasını bekleyin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(editButton));

        // Düzenleme düğmesine tıkla
        editButton.click();

        WebElement editFirstName = driver.findElement(By.cssSelector("#firstName"));
        editFirstName.clear();
        editFirstName.sendKeys("Nefise");

        WebElement editSubmitButton = driver.findElement(By.cssSelector("#submit"));
        editSubmitButton.click();

    }

    @After
    public void tearDown() {
        // WebDriver'ı kapat
        if (driver != null) {
            driver.quit();
        }
    }
}
