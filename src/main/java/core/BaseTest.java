package core;

/**
 * Created by YaskoYA on 27.07.2015.
 */

import ui_Layer.GuessPage;
import org.testng.annotations.*;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static core.Utils.*;
import static core.Utils.findCSS;
import static core.Utils.waitSleep;

//@Listeners(ScreenshotListener.class)
public class BaseTest {

    private GuessPage guessPage;

    @BeforeSuite
    public void init() {
        Driver.init();
        //System.out.println(Config.getBaseURL());
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().get(Config.getBaseURL());
        findCSS(".indexPreviewMenu-item-link.life").click();
        guessPage = new GuessPage();
        guessPage.authorization(Config.getProperty("test.login"), Config.getProperty("test.passwd"));
    }



    public void openURL() {

        Driver.get().get(Config.getBaseURL());

    }


    @AfterSuite
    public void cleanup() {
        if (Config.getProperty("test.browser") == "iexplore") {
            try {
                Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Driver.tearDown();
    }

    @AfterMethod
    public void backToHome() {
        /*Driver.get().navigate().refresh();
        waitSleep(1000);

        // Кликаем по "колесику" в верхнем правом углу
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".head-user-setting"))).click();

        // "Выйти"-button
        waitSleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".settingList-item-link.button"))).click();*/
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".head-logo"))).click();
//        waitSleep(1000);
//        Driver.get().get("http://wideup.net/profile/home");
        waitSleep(2000);
        Driver.get().get(Config.getBaseURL() + "/life/home");
//        findCSS(leftBarOnPay(1)).click();
    }

    @BeforeMethod
    public void waitALittle() {
        waitSleep(1000);
    }


}
