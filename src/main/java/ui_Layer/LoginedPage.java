package ui_Layer;

import core.Driver;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;

import static core.Utils.findCSS;
import static core.Utils.waitSleep;

/**
 * Created by YaskoYA on 27.07.2015.
 */
public class LoginedPage {

    // Иконка PAY в header на странице после авторизации
    private WebElement payButton;

    // Иконка LIFE в header на странице после авторизации
    private WebElement lifeButton;

    // Иконка BOX в header на странице после авторизации
    private WebElement boxButton;

    // Иконка CLUB в header на странице после авторизации
    private WebElement clubButton;

    // Иконка PASS в header на странице после авторизации
    private WebElement passButton;

    // Иконка настройки в header на странице после авторизации
    private WebElement settingsButton;

    // Кнопка "Выйти" в header на странице после авторизации после нажатия иконки настройки
    private WebElement awayButton;

    // Кнопка "Главная" на левом виджете на странице после авторизации
    public WebElement mainButton;

    // Севис "КАБИНЕТ" в разделе PAY
    private WebElement payCabinetButton;

    // Севис "ПЛАТЕЖ ПО РЕКВИЗИТАМ" в разделе PAY
    private WebElement payFreePaymentButton;

    // Севис "ОПЛАТИТЬ УСЛУГИ" в разделе PAY
    private WebElement payServiceButton;

    // Севис "ПЕРЕВОДЫ" в разделе PAY
    private WebElement payTransferButton;

    // Севис "ТОЧКИ ПОПОЛНЕНИЯ" в разделе PAY
    private WebElement payPointReplenishmentButton;

    // Севис "ПОПОЛНЯЙТЕ КАБИНЕТ" в разделе PAY
    private WebElement payRefillCabinetButton;

    //Кабинет: .payCabinet
    //Платеж по реквизитам: .payFreePayment          closeButton: .freePaymentParamsExt .indexCloseButton.popup-closeButton
    //Оплатить услуги: .payService
    //Переводы: .payTransfer                         closeButton: .transferPopup .indexCloseButton.popup-closeButton
    //Точки пополнения: .payPointReplenishment       closeButton: .popupPointRecharge .indexCloseButton
    //Пополняйте кабинет: .payRefillCabinet          closeButton: .payRefillCabinetPopup .indexCloseButton.popup-closeButton

    // Значек аватарки на главной
    private WebElement ava;

    // Меню на странице PAY (Главная, Кабинет, Провайдеры, Корзина)
    private WebElement menu;


    public void logOut() {
        waitSleep(1000);
        findCSS(".head-user-mail+span").click();
        waitSleep(1000);
        findCSS(".settingList-item-link.button").click();
    }

    public void checkHeaderServices() {
        lifeButton = findCSS(".head-menu-list-item-link.life");
        lifeButton.click();

        passButton = findCSS(".head-menu-list-item-link.pass");
        passButton.click();

        boxButton = findCSS(".head-menu-list-item-link.box");
        boxButton.click();

        clubButton = findCSS(".head-menu-list-item-link.club");
        clubButton.click();

        payButton = findCSS(".head-menu-list-item-link.pay");
        payButton.click();
    }

    public void checkPayServices() {
        payCabinetButton = findCSS(".payCabinet");
        payFreePaymentButton = findCSS(".payFreePayment");
        payServiceButton = findCSS(".payService");
        payTransferButton = findCSS(".payTransfer");
        payPointReplenishmentButton = findCSS(".payPointReplenishment");
        payRefillCabinetButton = findCSS(".payRefillCabinet");

        WebElement[] withCloseButton = { payFreePaymentButton, payTransferButton, payPointReplenishmentButton, payRefillCabinetButton };
        String[] closeButtons = {".freePaymentParamsExt .indexCloseButton.popup-closeButton",
                ".transferPopup .indexCloseButton.popup-closeButton",
                ".popupPointRecharge .indexCloseButton",
                ".payRefillCabinetPopup .indexCloseButton.popup-closeButton"};
        String[] qqq = {".payCabinet", ".payService"}; // css locators элементов без closeButton
        String[] www = {".payFreePayment", ".payTransfer", ".payPointReplenishment", ".payRefillCabinet"}; // css locators элементов с closeButton

        mainButton = findCSS(".contentMenu-list>li:nth-of-type(1)>a");

        for(int i = 0; i < 4; i++) {
            waitSleep(1000);
            findCSS(www[i]).click();
            waitSleep(1000);
            findCSS(closeButtons[i]).click();
        }

        for(int i = 0; i < 2; i++) {
            waitSleep(1000);
            findCSS(qqq[i]).click();
            Driver.get().navigate().back();
        }
    }

    public void checkAva() {
        ava = findCSS(".contentMenu-ava");
        String attr = ava.getAttribute("src");
        System.out.println(attr);
        boolean isAva = attr.startsWith("https://pass.wideup.net");
        Assert.assertEquals("THERE IS NO AVA PICTURE!!!", true, isAva);
    }

    public void checkMenu() {
        menu = findCSS(".contentMenu-list");
        String[] menuTitles = {"Главная", "Кабинет", "Провайдеры", "Корзина"};
        WebElement elementInMenu;
        for(int i = 0; i < 4; i++) {
            elementInMenu = findCSS(".contentMenu-list>li:nth-of-type(" + (i + 1) + ")");
            Assert.assertEquals("Something wrong in menu titles", menuTitles[i], elementInMenu.getText());
        }
    }
}
