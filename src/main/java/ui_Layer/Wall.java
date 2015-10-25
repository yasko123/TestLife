package ui_Layer;

import core.Driver;
import core.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import static core.Utils.*;

/**
 * Created by YaskoYA on 27.07.2015.
 */
public class Wall extends BasePage{
    Actions action = new Actions(Driver.get());


    // поле "что у вас нового?"
    @FindBy(css = ".textarea.wall_field.new_life_post")
    private static WebElement newPostFld;

    // кнопка Опубликовать
    @FindBy(xpath = "//div[@class='wall_field_buttons']//div[7]")
    private static WebElement addPost;

    // добавить файлы
    @FindBy(css = ".wall_field_button_download")
    private static WebElement addFailes;

    // загрузить с компьютера
    @FindBy(css = ".wall_list_item.wall_downloading_list_item")
    private static WebElement downloadingFromComp;

    @FindBy(css = "wallUploadFileInput")
    private static WebElement test;

    // загрузить с WIDEBOX
    @FindBy(css = ".wall_list_item.box_wall_post_upload")
    private static WebElement downloadingFromWIDEBOX;

    // кнопка Локация
    @FindBy(xpath = "//div[@class='wall_places_button'][ancestor::div[@id='new_post_options_section_wrapper']]")
    private static WebElement locations;

    // кнопка тэг
    @FindBy(xpath = "//div[@class='wall_tag_button'][ancestor::div[@id='new_post_options_section_wrapper']]")
    private static WebElement tags;

    // кнопка Поделиться
    @FindBy(xpath = "//div[@class='wall_field_button_share_wrapper'][ancestor::div[@id='new_post_options_section_wrapper']]")
    private static WebElement share;

    // чек бокс - опубликовать в facebook
    @FindBy(css = ".lockSelect-list-item.facebook")
    private static WebElement sharefacebook;

    // чек бокс - Комментирование
    @FindBy(css = ".wall_field_button_permission.permissionComment")
    private static WebElement checkBoxComment;

    // чек бокс - Репост
    @FindBy(css = ".wall_field_button_permission.permissionRepost")
    private static WebElement checkBoxRepost;





    private static WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

    public void checkNewPostFld(){
        progressBarWait();
        wait.until(ExpectedConditions.visibilityOf(newPostFld));
        Assert.assertTrue(newPostFld.isDisplayed());
    }

    public void createNewPost(String randomText){

        progressBarWait();
        wait.until(ExpectedConditions.elementToBeClickable(newPostFld)).sendKeys(randomText);
//        wait.until(ExpectedConditions.elementToBeClickable(addPost)).click();

    }

    public void clickAddPostButton(){
        progressBarWait();
        wait.until(ExpectedConditions.elementToBeClickable(addPost)).click();
    }

    // Проверка опубликованного поста с текстом
    public void checkNewPost(String randomText){

        progressBarWait();
        wait.until(ExpectedConditions.visibilityOf
                (findXpath("//span[contains(@class,'widelifePostWrapper lifePostWrapper')]/div[contains(@class,'wall_post widelife')]//pre[text()=\'" + randomText + "\']")));
        Assert.assertTrue((findXpath("//span[contains(@class,'widelifePostWrapper lifePostWrapper')]/div[contains(@class,'wall_post widelife')]//pre[text()=\'" + randomText + "\']").isDisplayed()));
    }

    public void checkPostFail(String randomText, String file1){
        progressBarWait();
        wait.until(ExpectedConditions.visibilityOf(findXpath("//img[contains(@name, \'" + file1 + "\')][ancestor::div[@class='post_content']/pre[text()=\'" + randomText + "\']]")));
        Assert.assertTrue((findXpath("//img[contains(@name, \'" + file1 + "\')][ancestor::div[@class='post_content']/pre[text()=\'" + randomText + "\']]")).isDisplayed());
    }



    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(stringSelection, null);
    }

    // Добавление 1 файла с компьютера
    public void uploadFileToPost(String file1) throws InterruptedException, AWTException {

        progressBarWait();

        File file = new File(file1);

        setClipboardData(file.getAbsolutePath());
        //
        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(300);
    }

    // Клик по добавить файл и загрузить с компьютера
    public void uploadFileComputersClick(){
        progressBarWait();
        wait.until(ExpectedConditions.elementToBeClickable(addFailes)).click();
        wait.until(ExpectedConditions.elementToBeClickable(downloadingFromComp)).click();
    }

    // Клик по добавить файл и загрузить с Box
    public void uploadFileBoxClick(){
        progressBarWait();
        wait.until(ExpectedConditions.elementToBeClickable(addFailes)).click();
        wait.until(ExpectedConditions.elementToBeClickable(downloadingFromWIDEBOX)).click();
    }

    // Добавить 4 файла(фото) в пост
    public void uploadFileToPost4(String file1, String file2, String file3, String file4) throws InterruptedException, AWTException {

        progressBarWait();
        wait.until(ExpectedConditions.elementToBeClickable(addFailes)).click();
        File files = new File(file1);

        wait.until(ExpectedConditions.elementToBeClickable(downloadingFromComp)).click();
        setClipboardData(files.getAbsolutePath());

        //
        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(300);

        wait.until(ExpectedConditions.elementToBeClickable(addFailes)).click();
        File files2 = new File(file2);
        wait.until(ExpectedConditions.elementToBeClickable(downloadingFromComp)).click();

        setClipboardData(files2.getAbsolutePath());
        //
        Robot robot2 = new Robot();
        robot2.delay(1000);
        robot2.keyPress(KeyEvent.VK_CONTROL);
        robot2.delay(300);
        robot2.keyPress(KeyEvent.VK_V);
        robot2.delay(300);
        robot2.keyRelease(KeyEvent.VK_V);
        robot2.delay(300);
        robot2.keyRelease(KeyEvent.VK_CONTROL);
        robot2.delay(300);
        robot2.keyPress(KeyEvent.VK_ENTER);
        robot2.delay(300);
        robot2.keyRelease(KeyEvent.VK_ENTER);
        robot2.delay(300);

        wait.until(ExpectedConditions.elementToBeClickable(addFailes)).click();
        File files3 = new File(file3);
        wait.until(ExpectedConditions.elementToBeClickable(downloadingFromComp)).click();

        setClipboardData(files3.getAbsolutePath());
        //
        Robot robot3 = new Robot();
        robot3.delay(1000);
        robot3.keyPress(KeyEvent.VK_CONTROL);
        robot3.delay(300);
        robot3.keyPress(KeyEvent.VK_V);
        robot3.delay(300);
        robot3.keyRelease(KeyEvent.VK_V);
        robot3.delay(300);
        robot3.keyRelease(KeyEvent.VK_CONTROL);
        robot3.delay(300);
        robot3.keyPress(KeyEvent.VK_ENTER);
        robot3.delay(300);
        robot3.keyRelease(KeyEvent.VK_ENTER);
        robot3.delay(300);

        wait.until(ExpectedConditions.elementToBeClickable(addFailes)).click();
        File files4 = new File(file4);
        wait.until(ExpectedConditions.elementToBeClickable(downloadingFromComp)).click();

        setClipboardData(files4.getAbsolutePath());
        //
        Robot robot4 = new Robot();
        robot4.delay(1000);
        robot4.keyPress(KeyEvent.VK_CONTROL);
        robot4.delay(300);
        robot4.keyPress(KeyEvent.VK_V);
        robot4.delay(300);
        robot4.keyRelease(KeyEvent.VK_V);
        robot4.delay(300);
        robot4.keyRelease(KeyEvent.VK_CONTROL);
        robot4.delay(300);
        robot4.keyPress(KeyEvent.VK_ENTER);
        robot4.delay(300);
        robot4.keyRelease(KeyEvent.VK_ENTER);
        robot4.delay(300);

    }


}
