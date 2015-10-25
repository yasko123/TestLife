package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by YaskoYA on 27.07.2015.
 */
public class Driver {

    private static WebDriver driver;

    public static WebDriver get() {
        return driver;
    }

    public static void set(WebDriver driverInput) {
        driver = driverInput;
    }

    public WebDriverWait wait = new WebDriverWait(driver, 200);


    public static void init() {
        WebDriver driverInput;
//        org.apache.commons.logging.LogFactory lll;
        String s = Config.getProperty("test.browser");
        if (s.equals("firefox")) {
            driverInput = new FirefoxDriver();

        } else if (s.equals("iexplore")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\driver\\IEDriverServer.exe");
            driverInput = new InternetExplorerDriver();

        } else if (s.equals("chrome")) {

            DesiredCapabilities capabilities = DesiredCapabilities.chrome();

            ChromeOptions options = new ChromeOptions();

            options.addArguments("test-type");
//            capabilities.setCapability("chrome.binary", "<Path to binary>");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
            driverInput = new ChromeDriver(capabilities);


//            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
//            driverInput = new ChromeDriver();

        } else if (s.equals("htmlunit")) {
            driverInput = new HtmlUnitDriver();

        } else if (s.equals("safari")) {
            DesiredCapabilities safariCapabilities = DesiredCapabilities.safari();
            safariCapabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
            safariCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
            //safariCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            driverInput = new SafariDriver(safariCapabilities);

            //USING only for Selenium >v2.35.0
            //case "ghost":
            //    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            //    System.out.print(System.getProperty("user.dir"));
            //    String path = System.getProperty("user.dir") + "\\phantomjs\\phantomjs.exe";
            //    desiredCapabilities.setCapability("phantomjs.binary.path", path);
            //    driverInput = new PhantomJSDriver(desiredCapabilities);
            //    break;
        } else {
            throw new AssertionError("Unsupported browser: " + Config.getProperty("test.browser"));
        }
        driverInput.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("test.timeouts")), TimeUnit.SECONDS);
        driverInput.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        Driver.set(driverInput);
        get().manage().window().maximize();
        //get().manage().window().setSize(new Dimension(1260, 768));
    }

   /* public static void logOut() {
        if (false == isElementPresent(By.cssSelector(".enter"), 1)) {
            //clickJS(Driver.get().findElement(By.xpath("//a[text()='Выход']")));
            clickJS(Driver.get().findElement(By.cssSelector("#logout>a")));
        }
    }*/

    public static void tearDown() {
        Driver.get().quit();

    }
}
