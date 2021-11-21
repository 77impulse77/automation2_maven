import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Crm_project {
    public static void main(String[] args) throws InterruptedException {

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
        driver.findElement(By.xpath("//span[contains(.,'Проекты')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Все проекты')]")).click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.btn.back.icons-holder-text"))).click();

       // при запуске, изменить имя проекта
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.name("crm_project[name]"))).sendKeys("8877");

        driver.findElement(By.xpath("//span[@class=\"select2-chosen\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='1234']"))).click();
        Select select = new Select(driver.findElement(By.name("crm_project[priority]")));
        select.selectByVisibleText("Высокий");

        Select select1 = new Select(driver.findElement(By.name("crm_project[financeSource]")));
        select1.selectByVisibleText("Инвестиции");

        Select select2 = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        select2.selectByVisibleText("Research & Development");

        Select select3 = new Select(driver.findElement(By.name("crm_project[curator]")));
        select3.selectByVisibleText("Амелин Владимир");

        Select select4 = new Select(driver.findElement(By.name("crm_project[rp]")));
        select4.selectByVisibleText("Гатов Фёдор");

        Select select5 = new Select(driver.findElement(By.name("crm_project[manager]")));
        select5.selectByVisibleText("Амелина Светлана");

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();





      //  new Actions(driver).moveToElement(select).click().pause(Duration.ofSeconds(2)).perform();
      //  List<WebElement> a = driver.findElement(By.name("crm_project[priority]")).findElements(By.xpath("option"));

      //  new Actions(driver).pause(Duration.ofSeconds(2)).moveToElement(a.get(3)).click().perform();


        //driver.findElement(By.xpath("//*[.='Высокий']")).click();
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[.='Высокий']"))).click();



//      driver.quit();

    }
}
