package orangehrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

        WebDriver driver; //declared as public
    @BeforeMethod
    public void openLinkPage(){
        //Open the browser/site
        driver=new ChromeDriver();
        driver.get("https://www.leafground.com/link.xhtml");
    }
    @Test
    public void linkTests(){
        //1.Take me to dashboard (click the link)
        WebElement homelink= driver.findElement(By.linkText("Go to Dashboard"));
        homelink.click();
        driver.navigate().back(); //go back to dashboard

        //2.find my destination link (without clicking it)
        WebElement notClick= driver.findElement(By.partialLinkText("Find the URL"));
        String path = notClick.getAttribute("href");
        System.out.println("This is the path "+path);

        //3.i'm I broken link

        WebElement brokenLink=driver.findElement(By.linkText("Broken?"));
        brokenLink.click();
        String title= driver.getTitle();
        if (title.contains("404")){
            System.out.println("Link is broken");
        } else{
            System.out.println("link is not broken");
            }
        driver.navigate().back();
        //4.Duplicate link
        WebElement dupLink= driver.findElement(By.linkText("Go to Dashboard"));
        dupLink.click();
        driver.navigate().back();

        //5.Count Links (in the page)
        List<WebElement> countFullPageLinks= driver.findElements(By.tagName("a"));
        int pageLinks= countFullPageLinks.size();
        System.out.println("Count of full page links "+pageLinks);

        //6.Count layout links (in certian layoout)
        WebElement layoutElement= driver.findElement(By.className("layout-main-content"));
        List<WebElement> countoflayoutLinks= layoutElement.findElements(By.tagName("a"));
        System.out.println("Count of layout links "+ countoflayoutLinks.size());

    }




    }



