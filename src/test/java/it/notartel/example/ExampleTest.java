package it.notartel.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExampleTest {

    private WebDriver driver;

    @BeforeAll
    void setupWebDriver(){
        WebDriverManager.firefoxdriver().setup(); //setup webdriver for Firefox, only once per class
        //alternatively, you can also try using one of the following:
        //WebDriverManager.chromedriver().setup();
        //WebDriverManager.edgedriver().setup();
    }

    @BeforeEach
    void setup(){
        //create new instance of webdriver before each test
        this.driver = new FirefoxDriver();
        // alternatively, you can try using one of the following:
        // this.driver = new ChromeDriver();
        // this.driver = new EdgeDriver();
    }

    @AfterEach
    void teardown(){
        //close webdriver after each test
        this.driver.quit();
    }

    @Test
    void performDuckDuckGoSearch(){
        this.driver.get("http://www.duckduckgo.com/");
        WebElement searchField = driver.findElement(By.id("search_form_input_homepage"));
        searchField.sendKeys("End-to-end Testing");
        WebElement searchButton = driver.findElement(By.id("search_button_homepage"));
        searchButton.click();
        //assert that the first result contains the substring "End-to-End"
        WebElement firstResult = driver.findElement(By.id("r1-0"));
        String title = firstResult.findElement(By.cssSelector("h2")).getText();
        assertThat(title, containsStringIgnoringCase("end-to-end"));
    }
}
