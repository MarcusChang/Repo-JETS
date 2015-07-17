package com.jd.libra.BPT_Auto.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by changxuliang on 2015/7/14.
 */
public class Libra_Page_PreIndex extends CommonPageModel {

    public WebElement Btn_Tutorial_Close; //首页用户指南关闭按钮

    public void  getLibraPagePreIndexElement(WebDriver driver) {
        Btn_Tutorial_Close = getPageElementByXpath(driver, By.xpath("/html/body/div/div/div/span[text()='自己溜达']"));
    }

}
