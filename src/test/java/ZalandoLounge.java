import net.bytebuddy.asm.Advice;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ZalandoLounge {

    @Test
    public void zalandoLounge() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://accounts.zalando.com/authenticate?redirect_uri=https%3A%2F%2Fwww.zalando-lounge.pl%2Fsso%2Ffs-callback&client_id=lounge&response_type=code&scope=openid&request_id=flow-id%3Abf824fed-b309-4359-9774-b3b2be32aca3%3ALVh+yWSWmOfiJpHP&nonce=470a75a3-9e28-4a5d-94fa-e6bd4f1a3fb1&state=eyJvcmlnaW5hbF9yZXF1ZXN0X3VyaSI6Imh0dHBzOi8vd3d3LnphbGFuZG8tbG91bmdlLnBsLyMvbG9naW4iLCJjbGllbnRfc3RhdGUiOiJleUptYkc5M0lqb2labUZ6YUdsdmJuTjBiM0psSWl3aWIzSnBaMmx1WVhScGJtZFFjbTlxWldOMElqb2lTRzl0WlNCUVlXZGxJaXdpWTJGdGNHRnBaMjVKWkdWdWRHbG1hV1Z5VUdGMGFDSTZJaUo5In0%3D&premise=unified_sso_ui&ui_locales=pl-PL&zalando_client_id=bf824fed-b309-4359-9774-b3b2be32aca3&cid=GA1.1.553112118.1719577447&sales_channel=e5168407-8d6f-4d9d-95e1-7e6fa5a6382c&client_country=PL&client_category=lounge&view=verify-email");
        WebElement emailAdress = driver.findElement(By.xpath("//input[@type='email']"));
        Thread.sleep(5000);
        emailAdress.sendKeys("brykdawid1@gmail.com");
        Thread.sleep(5000);
        emailAdress.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        WebElement password = driver.findElement(By.xpath("//input[@id='login-password']"));
        password.sendKeys("Wyrewolwerowany55");
        Thread.sleep(5000);
        password.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='Zaloguj się']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@id='sso-login-lounge']")).click();
        driver.get("https://www.zalando-lounge.pl/campaigns/ZZO2SL2/categories/253250191/articles/JOC22S04X-K11?catalog-type=campaign&navigationSource=catalog");
        Thread.sleep(5000);
        WebElement rozmiar = driver.findElement(By.xpath("//span[text()='XS']"));
        rozmiar.click();
        driver.findElement(By.xpath("//button[@aria-labelledby='5val-btn-label']")).click();
    }

    @Test
    public void zalandoLounge2(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.facebook.com/");

    }
}
