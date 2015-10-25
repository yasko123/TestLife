package Tests;

import DataDrivenPack.DataDrivenClass;
import core.BaseTest;
import core.Utils;
import org.testng.Reporter;
import org.testng.annotations.Test;
import ui_Layer.HomePage;
import ui_Layer.Wall;

import static core.Utils.findCSS;
import static core.Utils.leftBarOnPay;

/**
 * Created by YaskoYA on 27.07.2015.
 */
public class Test_01 extends BaseTest{

    private HomePage homePage;
    private Wall wall;


    @Test(dataProvider = "Test_01", dataProviderClass = DataDrivenClass.class)

    public void test_01(String randomText) {
        homePage = new HomePage();
        wall = new Wall();

        Reporter.log("<b>TEST CASE name: Создать пост с текстом</b>");


        // Кликаем по "Стена" на Главной странице
        homePage.wallButtonOnTheMainPageClick();
        // Проверяем наличее поля для создания поста
        wall.checkNewPostFld();
        // Добавляем новый пост с рандомным текстом
        wall.createNewPost(randomText);
        // кликаем по кнопке Опубликовать
        wall.clickAddPostButton();
        // Проверяем наличие созданного поста на стене
        wall.checkNewPost(randomText);


        Reporter.log("<br>Test was successful. Пост с текстом создан на стене.</br>");
    }
}
