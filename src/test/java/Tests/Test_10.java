package Tests;

import DataDrivenPack.DataDrivenClass;
import core.BaseTest;
import org.testng.Reporter;
import org.testng.annotations.Test;
import ui_Layer.HomePage;
import ui_Layer.NewPostActiv;
import ui_Layer.Wall;

/**
 * Created by YaskoYA on 06.10.2015.
 */
public class Test_10 extends BaseTest {
    private HomePage homePage;
    private Wall wall;
    private NewPostActiv newPostActiv;


    @Test(dataProvider = "Test_10", dataProviderClass = DataDrivenClass.class)

    public void test_10(String randomText){
        homePage = new HomePage();
        wall = new Wall();
        newPostActiv = new NewPostActiv();

        Reporter.log("<b>TEST CASE name: Создать пост с текстом (4000 имволов)</b>");

        homePage.wallButtonOnTheMainPageClick();
        wall.checkNewPostFld();

        wall.createNewPost(randomText);

        newPostActiv.checkCounter();
        newPostActiv.checkCounter1(randomText);
        wall.clickAddPostButton();
        wall.checkNewPost(randomText);
    }
}
