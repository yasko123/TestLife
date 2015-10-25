package Tests;

import DataDrivenPack.DataDrivenClass;
import core.BaseTest;
import org.testng.Reporter;
import org.testng.annotations.Test;
import ui_Layer.HomePage;
import ui_Layer.Wall;

import java.awt.*;

/**
 * Created by YaskoYA on 01.09.2015.
 */
public class Test_02 extends BaseTest {
    private HomePage homePage;
    private Wall wall;


    @Test(dataProvider = "Test_02", dataProviderClass = DataDrivenClass.class)

    public void test_02(String randomText, String file1) throws AWTException, InterruptedException {
//        System.out.println(Test_02.class.getProtectionDomain().getCodeSource().getLocation().getPath());

        homePage = new HomePage();
        wall = new Wall();

        Reporter.log("<b>TEST CASE name: Создать пост с текстом и 1 файлом загруженным с компьютера</b>");

        // Кликаем по "Стена" на Главной странице
        homePage.wallButtonOnTheMainPageClick();

        // Проверяем наличее поля для создания поста
        wall.checkNewPostFld();

        // Добавляем новый пост с рандомным текстом
        wall.createNewPost(randomText);

        // Добавляем 1 файл в пост с компьютера
        wall.uploadFileComputersClick();

        // Добавляем 1 файл с компьютера
        wall.uploadFileToPost(file1);

        // Кликаем по кнопке Опубликовать
        wall.clickAddPostButton();

        // проверка опубликованного поста
        wall.checkNewPost(randomText);
        wall.checkPostFail(randomText, file1);

        Reporter.log("<br>Test was successful. Пост с текстом и 1 файлом, загруженным с компьютера, создан на стене .</br>");
    }
}
