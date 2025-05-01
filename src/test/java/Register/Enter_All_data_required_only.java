package Register;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class Enter_All_data_required_only {
    public static void main (String [] args) {

        // this variable to check the Register valid or not valid
        String ExpectedResults = "Your registration completed";
        String ActualResults;

        // this variable to store the data that well use in test
        String first_name = "FTest";
        String last_name = "LTest";
        String email = "testuser" + System.currentTimeMillis() + "@example.com";
        String password = "test123$";

        // create webDriver to start test
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");


        driver.findElement(By.id("FirstName")).sendKeys(first_name);
        driver.findElement(By.id("LastName")).sendKeys(last_name);
        driver.findElement(By.id("Email")).sendKeys(email);

        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

        driver.findElement(By.id("register-button")).click();

        // check the Register valid or not valid
        ActualResults = driver.findElement(By.className("result")).getText();
        if (ExpectedResults == ActualResults )
        {
            System.out.println("Register correct");
        }
        else
        {
            System.out.println("Register not correct");
        }
    }
}
