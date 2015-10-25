package ui_Layer;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static core.Utils.progressBarWait;
import static core.Utils.waitSleep;

/**
 * Created by YaskoYA on 06.10.2015.
 */
public class NewPostActiv extends BasePage {
    private String postCounter = new String();

    public void setPostCounter(String basketId) {
        this.postCounter = basketId;
    }

    public String getPostCounter() {

        return postCounter;
    }

    Actions action = new Actions(Driver.get());

    @FindBy(xpath = "//div[@class='textarea_counter']")
    private static WebElement counter;

    private static WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

    public void checkCounter(){
        progressBarWait();
        postCounter = wait.until(ExpectedConditions.visibilityOf(counter)).getText();
//        wait.until(ExpectedConditions.elementToBeClickable(counter)).click();
        waitSleep(3000);
//        Assert.assertEquals(counter.getText(), "10", "test");
    }
    public void checkCounter1(String randomText){
        int length = ((4000) - randomText.length());

        Assert.assertEquals(counter.getText(), length, "test");
    }

    public void getCounter(){
        progressBarWait();
        wait.until(ExpectedConditions.visibilityOf(counter)).getText();
    }
}
