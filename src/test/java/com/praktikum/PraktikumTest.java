import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Paths;

public class PraktikumTest {

    private WebDriver driver;

    @Test
    public void test() {
        // Указываем путь к chromedriver (для Mac M1)
        String chromedriverPath = "/usr/local/bin/chromedriver"; // или "/opt/homebrew/bin/chromedriver"
        System.setProperty("webdriver.chrome.driver", chromedriverPath);

        // Настройки Chrome для Mac M1
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        // options.addArguments("--headless"); // Раскомментируйте для запуска без GUI после проверки

        try {
            driver = new ChromeDriver(options);
            driver.get("https://qa-mesto.praktikum-services.ru/");

            // Авторизация
            driver.findElement(By.id("email")).sendKeys("versaria.o@yandex.ru");
            driver.findElement(By.id("password")).sendKeys("qaswef-ketped-3motKo");
            driver.findElement(By.className("auth-form__button")).click();

            // Ожидание загрузки страницы и клик по аватару
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".profile__image")))
                    .click();

            // Ввод ссылки на аватар
            driver.findElement(By.id("owner-avatar"))
                    .sendKeys("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenium.png");

            // Сохранение
            driver.findElement(By.xpath(".//form[@name='edit-avatar']/button[text()='Сохранить']")).click();

            // Добавляем небольшую задержку для визуальной проверки
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}