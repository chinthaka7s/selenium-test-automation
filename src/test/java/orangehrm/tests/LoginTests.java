package orangehrm.tests;


import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {

    @Test(description = "KAN-5 TC01- Login with valid credentials" )
    public void tc01_validLogin(){
        WebDriver driver =new ChromeDriver();
        //“Selenium, wait up to 10 seconds when trying to find an element.”
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //  Read JSON file
        JsonObject data = JsonReader.readJson("src/test/resources/testdata/loginData.json");


        driver.get("http://localhost/orangehrm/orangehrm-5.8/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("@Chika160774o");
        driver.findElement(By.xpath("//button[@type='submit' and contains(normalize-space(),'Login')]")).click();
    }
    @Test(description = "KAN-11 TC02 - Login with invalid password")
    public void tc02_invalidPassword() {

    }
    @Test(description = "KAN-17 TC03 – Login with blank username & blank password")
    public void tc03_blankCredentials(){

    }


}
