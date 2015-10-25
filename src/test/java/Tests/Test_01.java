package Tests;

import DataDrivenPack.DataDrivenClass;
import core.BaseTest;
import org.testng.Reporter;
import org.testng.annotations.Test;
import ui_Layer.HomePage;
import ui_Layer.Wall;

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

        Reporter.log("<b>TEST CASE name: Создать пост на стене</b>");


        // ������� �� "�����" �� ������� ��������
        homePage.wallButtonOnTheMainPageClick();
        // ��������� ������� ���� ��� �������� �����
        wall.checkNewPostFld();
        // ��������� ����� ���� � ��������� �������
        wall.createNewPost(randomText);
        // ������� �� ������ ������������
        wall.clickAddPostButton();
        // ��������� ������� ���������� ����� �� �����
        wall.checkNewPost(randomText);


        Reporter.log("<br>Test was successful. ���� � ������� ������ �� �����.</br>");
    }
}
