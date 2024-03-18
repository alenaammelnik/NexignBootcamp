import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test2 {

    @Test
    public void testt() {
        System.setProperty("webdriver.chrome.driver", "/Users/alenamelnikova/Desktop/SELENIUM/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://nexign.com/ru");

        String pageContent = driver.findElement(By.tagName("body")).getText();

  
        int count = countWordIgnoreCase(pageContent, "Nord");

       
        driver.quit();

        
        assertEquals(1, count);
    }

    private int countWordIgnoreCase(String text, String word) {
        
        return text.toLowerCase().split(word.toLowerCase()).length - 1;
    }
}
