import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Zalangolounge2 {

    @Test
    public void zalandoLounge2() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.zalando-lounge.pl/campaigns/ZZO2WWA/categories/118750576/articles/AS142A16Y-Q11?catalog-type=campaign&navigationSource=catalog");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean isClickable = false;

        while (!isClickable) {
            try {
                // Znajdź dokładnie interesujący Cię przycisk
                WebElement button = driver.findElement(By.xpath("//button[@aria-checked='false']/span[contains(text(), 'Zarezerwowane')]"));

                // Poczekaj, aż przycisk będzie widoczny i włączony
                wait.until(ExpectedConditions.visibilityOf(button));
                wait.until(ExpectedConditions.elementToBeClickable(button));

                // Kliknij przycisk, jeśli jest klikalny
                if (button.isEnabled() && button.isDisplayed()) {
                    System.out.println("Przycisk jest klikalny! Klikanie...");
                    button.click();
                    isClickable = true; // ustawienie flagi zakończenia pętli
                }
            } catch (Exception e) {
                System.out.println("Przycisk nie jest jeszcze klikalny. Odświeżanie strony...");
                // Odśwież stronę
                driver.navigate().refresh();
                // Poczekaj na załadowanie strony
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-checked='false']/span[contains(text(), 'Zarezerwowane')]")));
            }
        }

        // Zamknij przeglądarkę
        driver.quit();
    }
}
