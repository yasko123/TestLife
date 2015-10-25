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

        Reporter.log("<b>TEST CASE name: ������� ���� � ������� � 1 ������ ����������� � ����������</b>");

        // ������� �� "�����" �� ������� ��������
        homePage.wallButtonOnTheMainPageClick();

        // ��������� ������� ���� ��� �������� �����
        wall.checkNewPostFld();

        // ��������� ����� ���� � ��������� �������
        wall.createNewPost(randomText);

        // ��������� 1 ���� � ���� � ����������
        wall.uploadFileComputersClick();

        // ��������� 1 ���� � ����������
        wall.uploadFileToPost(file1);

        // ������� �� ������ ������������
        wall.clickAddPostButton();

        // �������� ��������������� �����
        wall.checkNewPost(randomText);
        wall.checkPostFail(randomText, file1);

        Reporter.log("<br>Test was successful. ���� � ������� � 1 ������, ����������� � ����������, ������ �� ����� .</br>");
    }
}
