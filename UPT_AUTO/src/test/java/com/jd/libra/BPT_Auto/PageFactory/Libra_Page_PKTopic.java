package com.jd.libra.BPT_Auto.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by changxuliang on 2015/7/15.
 */
public class Libra_Page_PKTopic extends CommonPageModel {
    public WebElement Btn_GoTop; //“返回顶部”按钮
    public WebElement PK_Logo; //PK页logo

    public void getLibraPagePKTopicElement(WebDriver driver) {
        Btn_GoTop = getPageElementById(driver, By.id("gotop"));
        PK_Logo = getPageElementByXpath(driver, By.xpath("/html/body/div/div/div/div/div/table/tbody/tr/td[text()='PK']"));
    }
}

