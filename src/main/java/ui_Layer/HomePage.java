package ui_Layer;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static core.Utils.progressBarWait;
import static core.Utils.wait;
import static core.Utils.waitSleep;

/**
 * Created by YaskoYA on 27.07.2015.
 */
public class HomePage extends BasePage{

    // Стена на главной странице
    @FindBy(css = ".buttonInfo.lifeButtonActivity")
    private static WebElement wallButtonOnTheMainPage;


    private static WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

    public void wallButtonOnTheMainPageClick(){

        progressBarWait();
        wait.until(ExpectedConditions.elementToBeClickable(wallButtonOnTheMainPage)).click();
        waitSleep(2000);
    }
}
