package Tests;

import DataDrivenPack.DataDrivenClass;
import core.BaseTest;
import org.testng.Reporter;
import org.testng.annotations.Test;
import ui_Layer.HomePage;
import ui_Layer.UploadFilePopUp;
import ui_Layer.Wall;

import java.awt.*;

/**
 * Created by YaskoYA on 02.09.2015.
 */
public class Test_04 extends BaseTest {
    private HomePage homePage;
    private Wall wall;
    private UploadFilePopUp uploadFilePopUp;


    @Test(dataProvider = "Test_04", dataProviderClass = DataDrivenClass.class)

    public void test_04(String randomText) throws AWTException, InterruptedException {
        homePage = new HomePage();
        wall = new Wall();
        uploadFilePopUp = new UploadFilePopUp();

        Reporter.log("<b>TEST CASE name: Создать пост с текстом и 1 файлом загруженным с WideBox</b>");

        homePage.wallButtonOnTheMainPageClick();
        wall.checkNewPostFld();
        wall.createNewPost(randomText);
        wall.uploadFileBoxClick();

        uploadFilePopUp.uploadFailBox1();

        Reporter.log("<br>Test was successful. Пост с текстом и 1 файлом, загруженным с WideBox, создан на стене .</br>");
    }
}
