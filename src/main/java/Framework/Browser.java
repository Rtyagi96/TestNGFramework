package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Browser {
    public WebDriver driver;
    String baseUrl = "https://google.com";
    String driverPath= "//driver//chromedriver.exe";

    @BeforeMethod
    public void openBrowser(){
        System.out.println("Inside Before Test, Opening the chrome browser...");
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath: "+ projectPath);
        System.setProperty("webdriver.chrome.driver",projectPath + driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Assert.assertTrue(true);
    }

    @Test(priority = 0, threadPoolSize = 2, invocationCount = 3)
    public void openGoogle(){
        System.out.println("Inside test 1 |" + Thread.currentThread().getId());
        //System.setProperty("webdriver.gecko.driver",projectPath + "//driver//geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
//        Assert.assertEquals(actualTitle, expectedTitle);
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
    }
    @Test(priority = 1)
    public void search() throws InterruptedException {
        System.out.println("Inside test 2 |" + Thread.currentThread().getId());
        Assert.assertTrue(false);
//        driver.findElement(By.name("q")).sendKeys("selenium");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/a/h3")).click();
//        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void closeBrowser(){

        System.out.println("Inside After Test, Closing the chrome browser...");
        driver.close();
    }
}