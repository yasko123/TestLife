package ui_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.Utils.*;

/**
 * Created by YaskoYA on 27.07.2015.
 */
public class GuessPage extends BasePage {

    //  нопка ¬ход на гостевой странице
    @FindBy(css = ".indexRegPreview-enter")
    private WebElement enterButton_1;

    //  нопка –егистраци€ на гостевой странице
    @FindBy(css = ".indexRegPreview-reg")
    private WebElement regButton;

    //  нопка выбора €зыка на гостевой странице в header
    @FindBy(css = "#head-user-lang")
    private WebElement chooseLang;

    //  нопка вкладки PAY на гостевой странице
    @FindBy(css = ".indexPreviewMenu-item-link.pay")
    private WebElement payButton;

    // ѕоле ввода email или телефона после нажатис€ кнопки ¬ход на гостевой странице
    @FindBy(css = "#indexLogin-email")
    private WebElement fillEmailOrPhoneInput;

    // ѕоле ввода парол€ после нажатис€ кнопки ¬ход на гостевой странице
    @FindBy(css = "#indexLogin-pass")
    private WebElement fillPassInput;

    //  нопка ¬ход после нажатис€ кнопки ¬ход на гостевой странице
    @FindBy(css = ".formButtons-submit")
    private  WebElement enterButton_2;

    //  нопка faceBook после нажатис€ кнопки ¬ход на гостевой странице
    @FindBy(css = ".fb-login")
    private WebElement fbButton;

    // »конка закрыть (крестик в верхнем правом углу) после нажатис€ кнопки ¬ход на гостевой странице
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

