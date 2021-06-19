
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTestAll {
    protected static WebDriver driver;
    protected static String device;


    @BeforeScenario
    public void setUp()  {

        device = "web";

        if (device.equals("mobile")) {
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "iPhone 8");
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("mobileEmulation", mobileEmulation);

            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

            driver = new ChromeDriver(options);
            driver.get("https://www.hepsiemlak.com/");
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        }
        else if(device.equals("web"))
        {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            driver = new ChromeDriver(options);
            driver.get("https:www.google.com");
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        }
    }

    @AfterScenario
    public void tearDown() {
         driver.quit();

    }
}
