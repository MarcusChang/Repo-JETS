package com.jd.libra.BPT_Auto.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by changxuliang on 2015/7/15.
 */
public class Libra_Page_StandardTopic extends CommonPageModel {

    public WebElement Btn_GoTop; //“返回顶部”按钮
    public WebElement Dlg_Share_Title; //话题页标题

    public void getLibraPageStandardTopicElement(WebDriver driver) {
        Btn_GoTop = getPageElementById(driver, By.id("gotop"));
        Dlg_Share_Title = getPageElementByXpath(driver, By.xpath("//h2[@id='share_topic_title']"));
    }

}
