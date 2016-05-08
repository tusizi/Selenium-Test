import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by codedrinker on 5/8/16.
 */
public class DajiewangTest {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("http://www.dajie.com/?isLogin=true");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement userNameInput = driver.findElement(By.name("email"));
        WebElement pwInput = driver.findElement(By.name("password"));
        //WebElement checkBox = driver.findElement(By.partialLinkText("p_low_login_enable"));


        WebElement rememberCheckbox = driver.findElement(By.id("J_signinForm")).findElement(By.className("remember")).findElement(By.tagName("div"));
        rememberCheckbox.click();


        // Enter something to search for
        userNameInput.sendKeys("tusizi_xyn@163.com");
        pwInput.sendKeys("*******");
        driver.findElement(new By.ByCssSelector("#J_signinForm > div.btn-box > button")).click();
        // Now submit the form. WebDriver will find the form for us from the element
        //element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the pChromeage to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().equals("大街网_年轻人专属的社交招聘平台！ - 解亚楠");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        //Close the browser
        driver.quit();

    }
}
