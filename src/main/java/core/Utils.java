package core;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by YaskoYA on 27.07.2015.
 */
public class Utils {
    private static Actions actions;

    public static WebDriverWait wait = new WebDriverWait(Driver.get(), 100, 500);

    public static String groupeName = null;

    public static final String progressBarCSS = ".common-pending-img";

    // Находим элемент по его CSS локатору
    public static WebElement findCSS(String cssLocator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssLocator)));
//        waitSleep(2000);
//        return Driver.get().findElement(By.cssSelector(cssLocator));
    }

    // Находим элемент по его XPATH локатору
    public static WebElement findXpath(String xpathLocator)  {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLocator)));
//        waitSleep(2000);
//        return Driver.get().findElement(By.xpath(xpathLocator));
    }

    // Получаем элемент по порядковому номеру на левой панели PAY
    public static String leftBarOnPay(int i) {
        Map<Integer, String> a = new HashMap<Integer, String>();
        a.put(1, ".contentMenu-list-item.main");
        a.put(2, ".contentMenu-list-item.cabinet");
        a.put(3, ".contentMenu-list-item.biller");
        a.put(4, ".contentMenu-list-item.pay_cart");
        return a.get(i);
    }




    // Выбор всплывающих значков справа от названия шаблона (i - порядковый номер: редактировать, оплатить, удалить)
    public static void templates(int i) {
        waitSleep(2000);
        // Не могу объяснить почему, но так работает
        if(i == 3) {
            waitSleep(4000);
        }
        findCSS("#pay_template_table tr.tablePayTr:nth-of-type(1) .pbmButtonEditIcon").click();
        String[] variants = new String[] {".editTemplateSpan", ".showSavedTemplateData", ".deleteTemplateSpan"};

        findCSS(variants[i - 1]).click();
    }





    private static Collection<Class> getColl() {
        Collection<Class> coll = new ArrayList<Class>();
        coll.add(NoSuchElementException.class);
        coll.add(StaleElementReferenceException.class);
        coll.add(ElementNotVisibleException.class);
        return coll;
    }

    public static Wait<WebDriver> qqq = new FluentWait<WebDriver>(Driver.get())
            .withTimeout(30, TimeUnit.SECONDS)
            .pollingEvery(1000, TimeUnit.MILLISECONDS)
            .ignoring(NoSuchElementException.class)
//            .ignoring(WebDriverException.class)
            .ignoring(StaleElementReferenceException.class)
            .ignoring(ElementNotVisibleException.class);
//            .ignoreAll(getColl());

    private static Wait<WebDriver> megawait = new FluentWait<>(Driver.get()).withTimeout(10,TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);


    public static boolean isElementExist(By locator) {
        Driver.get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> elements = Driver.get().findElements(locator);
        Driver.get().manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("test.timeouts")), TimeUnit.SECONDS);
        return elements.size() > 0;
    }

    public static boolean isElementPresent(By locator, int timeout) {
        Driver.get().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        List<WebElement> elements = Driver.get().findElements(locator);
        Driver.get().manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("test.timeouts")), TimeUnit.SECONDS);
        return elements.size() > 0 && elements.get(0).isDisplayed();
    }


    public static void waitSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignore) {
        }
    }

    public static void checkLogOut() {

        while (!isElementPresent(By.cssSelector(".indexRegPreview-enter"), 1)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".head-user-setting")));
            waitSleep(500);
            Driver.get().findElement(By.cssSelector(".head-user-setting")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href=\"/auth/logout\"]")));
            waitSleep(500);
            Driver.get().findElement(By.cssSelector("[href=\"/auth/logout\"]")).click();
        }
    }

    public static void checkLogin(String logIn, String pass) {
        //пока элемент .head-logo не станет false
        while (!isElementPresent(By.cssSelector(".head-user-setting"), 1)) {

            Driver.get().findElement(By.cssSelector(".indexPreviewMenu-item-link.pass")).click();
            Driver.get().findElement(By.cssSelector(".indexRegPreview-enter")).click();
            waitSleep(500);
            Driver.get().findElement(By.cssSelector("#indexLogin-email")).sendKeys(logIn);
            Driver.get().findElement(By.cssSelector("#indexLogin-pass")).sendKeys(pass);

            Driver.get().findElement(By.cssSelector(".formButtons-submit.loginButton")).click();
            waitSleep(500);

        }
    }







    public void clearCache() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void clickJS(WebElement someButton) {
        //if (Config.getProperty("test.browser").equals("iexplore")) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", someButton);
        //} else {
        //     someButton.click();
        //}
    }


    public static WebElement setCheckbox(WebElement checkbox, boolean check) {
        if (true == check) {
            if (!checkbox.isSelected()) {
                clickJS(checkbox);
                //checkbox.click();
            }
        } else {
            if (checkbox.isSelected()) {
                clickJS(checkbox);
                //checkbox.click();
            }
        }
        return checkbox;
    }


    public static JSONArray getJson(String url) {

        JSONArray jsonArray = null;
        try {
            HttpGet request = new HttpGet(url);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String entityContents = EntityUtils.toString(entity);
            Object obj = JSONValue.parse(entityContents);
            jsonArray = (JSONArray) obj;
        } catch (Exception e) {
        }
        return jsonArray;
    }



    public static WebElement setTextJS(WebElement someField, String someText) {
        //if (Config.getProperty("test.browser").equals("iexplore")) {
        //    someField.clear();
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].value='" + someText + "';", someField);
        // } else {
        //     someField.sendKeys(someText);
        //  }
        return someField;
    }

    public static void openBaseUrl(){
        Driver.get().get("http://sso.wideup.dev");
    }

    public static String genRandomNum(int digitQuantity){
        int min = 0;
        int max = 0;

        Random r = new Random();
        switch (digitQuantity){
            case (1):
                min = 1;
                max = 9;
                break;
            case (2):
                min = 11;
                max = 99;
                break;
            case (3):
                min = 101;
                max = 999;
                break;
            case (4):
                min = 1001;
                max = 9999;
                break;
            case (5):
                min = 10001;
                max = 99999;
                break;
            case (6):
                min = 100001;
                max = 999999;
                break;
            case (7):
                min = 1000001;
                max = 9999999;
                break;
            case (8):
                min = 10000001;
                max = 99999999;
                break;
            case (9):
                min = 100000001;
                max = 999999999;
                break;
        }
        int random = r.nextInt((max - min) + 1) + min;
        return  String.valueOf(random);

    }

    /*public static ExpectedCondition<WebElement> elementToBeClickable(
            final By locator) {
        return new ExpectedCondition<WebElement>() {

            public ExpectedCondition<WebElement> visibilityOfElementLocated =
                    ExpectedConditions.visibilityOfElementLocated(locator);

            @Override
            public WebElement apply(WebDriver driver) {
                WebElement element = visibilityOfElementLocated.apply(driver);
                try {
                    if (element != null && element.isEnabled()) {
                        return element;
                    } else {
                        return null;
                    }
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return "element to be clickable: " + locator;
            }
        };
    }*/

    public static String genRandomText(int Length) {
        String[] lettersName = {"a", "b", "c", "d", "f", "g", "h", "i", "j", "k", "l", "m", "n",
                "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " ", " ", " "};
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(Length);
        for (int i = 0; i < Length; i++) sb.append(lettersName[rnd.nextInt(lettersName.length)]);
        return sb.toString();
    }

    public static void progressBarWait() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(progressBarCSS)));
    }

}
