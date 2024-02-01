package Utils;

import io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    public WebDriver driver;

    public WebDriver webDriverManager(){
        if(driver==null){
        System.setProperty("webdriver.driver.chrome","C:\\Users\\mansi\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        }
        return driver;

    }
}
