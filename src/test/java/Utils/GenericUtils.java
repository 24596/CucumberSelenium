package Utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {
    public WebDriver driver;

    public GenericUtils(WebDriver driver){
        this.driver = driver;
    }
    public void switchWindow(){
        Set<String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
    }
}
