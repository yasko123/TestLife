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

    // ������ PAY � header �� �������� ����� �����������
    private WebElement payButton;

    // ������ LIFE � header �� �������� ����� �����������
    private WebElement lifeButton;

    // ������ BOX � header �� �������� ����� �����������
    private WebElement boxButton;

    // ������ CLUB � header �� �������� ����� �����������
    private WebElement clubButton;

    // ������ PASS � header �� �������� ����� �����������
    private WebElement passButton;

    // ������ ��������� � header �� �������� ����� �����������
    private WebElement settingsButton;

    // ������ "�����" � header �� �������� ����� ����������� ����� ������� ������ ���������
    private WebElement awayButton;

    // ������ "�������" �� ����� ������� �� �������� ����� �����������
    public WebElement mainButton;

    // ����� "�������" � ������� PAY
    private WebElement payCabinetButton;

    // ����� "������ �� ����������" � ������� PAY
    private WebElement payFreePaymentButton;

    // ����� "�������� ������" � ������� PAY
    private WebElement payServiceButton;

    // ����� "��������" � ������� PAY
    private WebElement payTransferButton;

    // ����� "����� ����������" � ������� PAY
    private WebElement payPointReplenishmentButton;

    // ����� "���������� �������" � ������� PAY
    private WebElement payRefillCabinetButton;

    //�������: .payCabinet
    //������ �� ����������: .payFreePayment          closeButton: .freePaymentParamsExt .indexCloseButton.popup-closeButton
    //�������� ������: .payService
    //��������: .payTransfer                         closeButton: .transferPopup .indexCloseButton.popup-closeButton
    //����� ����������: .payPointReplenishment       closeButton: .popupPointRecharge .indexCloseButton
    //���������� �������: .payRefillCabinet          closeButton: .payRefillCabinetPopup .indexCloseButton.popup-closeButton

    // ������ �������� �� �������
    private WebElement ava;

    // ���� �� �������� PAY (�������, �������, ����������, �������)
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
        String[] qqq = {".payCabinet", ".payService"}; // css locators ��������� ��� closeButton
        String[] www = {".payFreePayment", ".payTransfer", ".payPointReplenishment", ".payRefillCabinet"}; // css locators ��������� � closeButton

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
        String[] menuTitles = {"�������", "�������", "����������", "�������"};
        WebElement elementInMenu;
        for(int i = 0; i < 4; i++) {
            elementInMenu = findCSS(".contentMenu-list>li:nth-of-type(" + (i + 1) + ")");
            Assert.assertEquals("Something wrong in menu titles", menuTitles[i], elementInMenu.getText());
        }
    }
}
