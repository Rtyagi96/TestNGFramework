package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowser {
    WebDriver driver = null;
    String projectPath = System.getProperty("user.dir");

    @Parameters("browserName")
    @BeforeTest
    public void setUp(String browserName){

        if(browserName.equalsIgnoreCase("chrome")){
            System.out.println("Opening" +browserName+ "browser");
            System.setProperty("webdriver.chrome.driver", projectPath + "//driver//chromedriver.exe");
            driver = new ChromeDriver();
        }
        else {
            System.out.println("Opening" +browserName+ "browser");
            System.setProperty("webdriver.gecko.driver", projectPath + "//driver//geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

    @Test
    public void test1() throws InterruptedException {
        System.out.println("Inside test1| " + "thread id " + Thread.currentThread().getId());
        driver.get("https://google.com");
        Thread.sleep(4000);
    }

//    @Test
//    public void test2(){
//        System.out.println("Inside test2 | " + "thread id " + Thread.currentThread().getId());
//        driver.get("https://selenium.org");
//    }

    @AfterTest
    public void tearDown(){
        System.out.println("Test finished, closing the browser");
        driver.close();
    }

}
