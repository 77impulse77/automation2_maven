import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Crm_contact {

    public static void main(String[] args) {

        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources//chromedriver.exe"
        );
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user");
        driver.findElement(By.id("prependedInput2")).sendKeys("1234");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        driver.findElement(By.xpath("//span[@class='title'][contains(text(),'Контрагенты')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Контактные лица')]")).click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"btn back icons-holder-text \"]"))).click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.name("crm_contact[lastName]"))).sendKeys("ййй8877");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.name("crm_contact[firstName]"))).sendKeys("4444аааа");


        driver.findElement(By.xpath("//span[@class=\"select2-chosen\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='1234']"))).click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.name("crm_contact[jobTitle]"))).sendKeys("QA");
// по хорошему обращать к елементу нужно по классу  button[class='btn btn-success action-button']
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();









    }
}
