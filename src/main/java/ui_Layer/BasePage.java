package ui_Layer;

import core.Driver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by YaskoYA on 27.07.2015.
 */
public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);

    }
}
