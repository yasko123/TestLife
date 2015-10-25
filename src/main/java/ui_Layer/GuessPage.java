package ui_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.Utils.*;

/**
 * Created by YaskoYA on 27.07.2015.
 */
public class GuessPage extends BasePage {

    // ������ ���� �� �������� ��������
    @FindBy(css = ".indexRegPreview-enter")
    private WebElement enterButton_1;

    // ������ ����������� �� �������� ��������
    @FindBy(css = ".indexRegPreview-reg")
    private WebElement regButton;

    // ������ ������ ����� �� �������� �������� � header
    @FindBy(css = "#head-user-lang")
    private WebElement chooseLang;

    // ������ ������� PAY �� �������� ��������
    @FindBy(css = ".indexPreviewMenu-item-link.pay")
    private WebElement payButton;

    // ���� ����� email ��� �������� ����� �������� ������ ���� �� �������� ��������
    @FindBy(css = "#indexLogin-email")
    private WebElement fillEmailOrPhoneInput;

    // ���� ����� ������ ����� �������� ������ ���� �� �������� ��������
    @FindBy(css = "#indexLogin-pass")
    private WebElement fillPassInput;

    // ������ ���� ����� �������� ������ ���� �� �������� ��������
    @FindBy(css = ".formButtons-submit")
    private  WebElement enterButton_2;

    // ������ faceBook ����� �������� ������ ���� �� �������� ��������
    @FindBy(css = ".fb-login")
    private WebElement fbButton;

    // ������ ������� (������� � ������� ������ ����) ����� �������� ������ ���� �� �������� ��������
    @FindBy(css = ".indexLogin-social+span")
    private WebElement closeButton;

    public void authorization(String emailOrPhone, String passwd) {

//        waitSleep(1000);
        findCSS(".indexPreviewMenu-item-link.life").click();
        findCSS(".indexRegPreview-enter").click();
        findCSS("#indexLogin-email").sendKeys(emailOrPhone);
        findCSS("#indexLogin-pass").sendKeys(passwd);
        findCSS(".formButtons-submit").click();

    }
}

