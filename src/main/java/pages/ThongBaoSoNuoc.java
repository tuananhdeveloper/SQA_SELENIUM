package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class ThongBaoSoNuoc {
    private final WebDriver webDriver;

    @FindBy(id = "mat-input-0")
    private WebElement date;

    @FindBy(id = "mat-input-1")
    private WebElement district;

    @FindBy(id = "btn_filter")
    private WebElement btnFilter;

    @FindBy(id = "btn_send")
    private WebElement btnSend;

    @FindBy(id = "btn_notify")
    private WebElement btnNotify;

    @FindBy(id = "content")
    private WebElement content;

    public ThongBaoSoNuoc(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

    }


    public String getData() {

        try {
            return content.getText();
        }
        catch (NoSuchElementException e) {
            return null;
        }
    }
    public ThongBaoSoNuoc enterDate(String date) {
        SeleniumUtils.waitForElementToClickable(webDriver, this.date);

        this.date.click();
        this.date.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        this.date.sendKeys(date);

        return this;
    }

    public ThongBaoSoNuoc enterDistrict(String district) {
        SeleniumUtils.waitForElementToClickable(webDriver, this.district);
        this.district.click();
        this.district.clear();
        this.district.sendKeys(district);
        return this;
    }

    public ThongBaoSoNuoc filter() {
        SeleniumUtils.waitForElementToClickable(webDriver, this.btnFilter);
        this.btnFilter.click();
        return this;
    }

}
