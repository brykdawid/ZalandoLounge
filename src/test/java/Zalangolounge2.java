import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/*
CMD
cd C:\Program Files (x86)\Google\Chrome\Application
chrome.exe --remote-debugging-port=9222 --user-data-dir=Y:\ChromeProfile

clothing
reserved xpath = "//button[@class='styles__ArticleSizeButton-sc-1n1fwgw-0 iiqbEt']"Et
available xpath = "//button[@class='styles__ArbuttticleSizeButton-sc-1n1fwgw-0 duljHq'] //span[text()='XXS']"

shoes
available class = styles__ArticleSizeButton-sc-1n1fwgw-0 XKwBF
reserved class = same as clothing

 */
public class Zalangolounge2 {

    @Test
    public void zalandoLounge2() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.zalando-lounge.pl/campaigns/ZZO2Y1Q/categories/60457365/articles/PA412O091-Q11?catalog-type=campaign&navigationSource=catalog");
        while (true) {
            try {
                WebElement sizeContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='styles__ArticleSizeItemList-sc-dt4c4z-2 eaaKLK']")));
                List<WebElement> sizeButtons = sizeContainer.findElements(By.xpath("//button[@role='radio'] //span[text()='40']"));

                boolean sizeAvailable = false;

                for (WebElement sizeButton : sizeButtons) {
                    String sizeText = sizeButton.getText();
                    System.out.printf("Checking size: %s\n", sizeText);

                    if (sizeButton.isEnabled()) {
                        System.out.printf("Size is available and enabled. Attempting to click.\n");
                        sizeButton.click();
                        sizeAvailable = true;
                        break;
                    }
                    break;
                }

                if (sizeAvailable) {
                    WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='addToCartButton']//button[contains(@class, 'auto-tests-add-to-cart-button')]")));
                    addToCartButton.click();
                    System.out.printf("PRODUCT ADDED TO CART\n");
                    break;
                } else {
                    driver.navigate().refresh();
                    System.out.printf("SIZE NOT AVAILABLE, REFRESHING\n");
                    Thread.sleep(1000);
                }
            } catch (StaleElementReferenceException e) {
                driver.navigate().refresh();
                System.out.printf("STALE ELEMENT EXCEPTION, REFRESHING\n");
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.printf("An unexpected error occurred: %s\n", e.getMessage());
                driver.navigate().refresh();
                Thread.sleep(1000);
            }
        }

    }
}
