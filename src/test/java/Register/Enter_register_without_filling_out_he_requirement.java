package Register;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Enter_register_without_filling_out_he_requirement {
    public static void main (String [] args) {

        // the variable to store the message while show
        int counter = 0;
        String[] element = new String[] {"First name", "Last name", "Email", "Password"};
        String[] nameElement = new String[] {"FirstName-error", "LastName-error", "Email-error", "ConfirmPassword-error"};


        // create webDriver to start test
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // Enter all data to Register

        driver.findElement(By.id("register-button")).click();


        // check all message show correct
        for (int i=0; i<nameElement.length; i++)
        {
            String expectedText = element[i] + " is required.";
            String actualText = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(nameElement[i]))).getText();

            if (expectedText.equals(actualText)){
                counter++;
                System.out.println("Message in field " + element[i] + " show correct");
            }
            else
            {
                System.out.println("Message in field " + element[i] + " not show correct");
            }
        }

        if (counter == nameElement.length)
        {
            System.out.println("\nThis test case valid");
        }
        else
        {
            System.out.println("\nThis test case not valid");
        }

        driver.quit();
    }
}
