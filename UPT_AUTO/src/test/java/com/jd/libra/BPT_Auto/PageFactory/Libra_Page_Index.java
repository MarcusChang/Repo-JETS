package com.jd.libra.BPT_Auto.PageFactory;

import Utils.TestUtilFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by changxuliang on 2015/7/15.
 */

public class Libra_Page_Index extends CommonPageModel {

    public WebElement Btn_GoTop; //“返回顶部”按钮
    public WebElement Banner_tab_left; //首页‘请您帮忙’banner
    public WebElement Btn_MyTopic; //首页‘我的话题’按钮
    public WebElement Btn_MyTopicContainer_Close; //首页‘我的话题’弹出框
    public WebElement Btn_UserAsk; //首页‘我要提问’按钮
    public WebElement Dlg_PopupAskContainer; //首页弹出‘我要提问’窗口
    public WebElement Ipt_AskUrl; //首页弹出‘我要提问’窗口的URL输入栏
    public WebElement Ipt_AskTextArea; //首页弹出‘我要提问’窗口的内容输入框
    public WebElement Btn_AskSubmit; //首页弹出‘我要提问’窗口的提交按钮
    public WebElement Dlg_ActReturns_CreateTopic; //首页创建话题后的返回结果
    public WebElement Btn_AskClose; //首页‘我要提问’弹出窗口的关闭按钮


    public void getLibraPageIndexElement(WebDriver driver) {
        Btn_GoTop = getPageElementById(driver, By.id("gotop"));
        Banner_tab_left = getPageElementById(driver, By.id("tab_left"));
        Btn_MyTopic = getPageElementById(driver, By.xpath("//span[@id='sidebar_mytopic']"));
        Btn_MyTopicContainer_Close = getPageElementByXpath(driver, By.xpath("//*[@id=\"dialog_mytopic_container\"]/div[1]/i"));
        Btn_UserAsk = getPageElementByXpath(driver, By.xpath("//*[@id=\"sidebar_ask_btn\"]"));
        Dlg_PopupAskContainer = getPageElementByXpath(driver, By.xpath("//*[@id=\"dialog_ask_container\"]"));
        Ipt_AskUrl = getPageElementByXpath(driver, By.xpath("//form[@id='dialog_ask_form']/div[2]/textarea"));
        Ipt_AskTextArea = getPageElementByXpath(driver, By.xpath("//*[@id=\"dialog_ask_form_textarea_wrapper\"]/textarea"));
        Btn_AskSubmit = getPageElementByXpath(driver, By.xpath("//*[@id=\"dialog_ask_form\"]/p/input"));
        Dlg_ActReturns_CreateTopic = getPageElementByXpath(driver, By.xpath("//*[@id=\"dialog_ask_form_textarea_wrapper\"]/p/span"));
        Btn_AskClose = getPageElementByXpath(driver, By.xpath("//*[@id=\"dialog_ask_close\"]"));
    }

    public void cleanMyTopicContainerAskTextArea(WebDriver driver, TestUtilFunctions testUtil){
        testUtil.clearInputs(driver, Ipt_AskTextArea);
        testUtil.waitForTime(1000);
    }



}