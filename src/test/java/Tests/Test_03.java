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
public class Test_03 extends BaseTest {
    private HomePage homePage;
    private Wall wall;


    @Test(dataProvider = "Test_03", dataProviderClass = DataDrivenClass.class)

    public void test_02(String randomText, String file1, String file2, String file3, String file4) throws AWTException, InterruptedException {
        homePage = new HomePage();
        wall = new Wall();

        Reporter.log("<b>TEST CASE name: Создать пост с текстом и 4 файлами загруженными с компьютера</b>");

        // Кликаем по "Стена" на Главной странице
        homePage.wallButtonOnTheMainPageClick();

        // Проверяем наличее поля для создания поста
        wall.checkNewPostFld();

        // Добавляем новый пост с рандомным текстом
        wall.createNewPost(randomText);

        // Добавляем 1 файл в пост с компьютера
//        wall.uploadFileComputersClick();
        wall.uploadFileToPost4(file1, file2, file3, file4);

        // Кликаем по кнопке Опубликовать
        wall.clickAddPostButton();

        Reporter.log("<br>Test was successful. Пост с текстом и 4 файлами, загруженными с компьютера, создан на стене .</br>");
    }
}
