package core;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by YaskoYA on 27.07.2015.
 */
public class ScreenshotListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        String filename = tr.getName() + "_" + System.currentTimeMillis() + ".png";
        File screenshot = new File("screenshots" + File.separator + filename);
        if (!screenshot.exists()) {
            new File(screenshot.getParent()).mkdirs();
            try {
                screenshot.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            new FileOutputStream(screenshot).write(((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Written screenshot to: http://10.128.6.189:8080/job/WidePay/ws/screenshots/" + filename);
        //Reporter.log("Written screenshot to: http://qatest-int-v.globo-tech.vpn/va-bank/" + filename);
        Reporter.log("Written screenshot to: <a target=\"_blank\" href=\"http://10.128.6.189:8080/job/WidePay/ws/screenshots/" + filename + "\">click to see this screenshot</a>");
        //Reporter.log(Utils.ID);
    }
}
