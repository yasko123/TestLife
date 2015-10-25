package ui_Layer;

import com.thoughtworks.selenium.webdriven.commands.DoubleClick;
import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.*;


import static core.Utils.clickJS;
import static core.Utils.findXpath;
import static core.Utils.progressBarWait;

/**
 * Created by YaskoYA on 02.09.2015.
 */
public class UploadFilePopUp extends BasePage {

    @FindBy(xpath = "//div[text()='ForTest']")
    private static WebElement forTestFail;

    @FindBy(xpath = "//div[text()='3251_html_32fb9451.jpg']")
    private static WebElement forq;

    @FindBy(xpath = "html/body/div[45]/div[2]/div[5]/input[2]")
    private static WebElement e;


    private static WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

    public void uploadFailBox1(){
        progressBarWait();
        wait.until(ExpectedConditions.elementToBeClickable(forq)).click();
        wait.until(ExpectedConditions.elementToBeClickable(e)).click();
    }
}
