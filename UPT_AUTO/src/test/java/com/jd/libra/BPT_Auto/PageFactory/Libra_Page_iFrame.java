package com.jd.libra.BPT_Auto.PageFactory;

import Utils.TestUtilFunctions;
import com.jd.libra.BPT_Auto.TestParams.ProjectParams;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by changxuliang on 2015/7/16.
 */
public class Libra_Page_iFrame extends CommonPageModel {

    public WebElement Dlg_Frame_FormLogin; //首页弹出登录校验框
    public WebElement Ipt_LoginName; //登录校验框用户姓名输入栏
    public WebElement Ipt_LoginPass; //登录校验框用户密码输入栏
    public WebElement Btn_LoginSubmit; //登录校验框提交登录按钮
    public WebElement Ckb_SecurityCheckBox; //登录校验框安全控件checkbox


    public void getLibraPagePopUpLoginIframeElement(WebDriver driver) {
        Dlg_Frame_FormLogin = getPageElementByXpath(driver, By.xpath("//*[@id=\"thickconr\"]/iframe"));
        Ipt_LoginName = getPageElementByXpath(driver, By.xpath("//*[@id=\"loginname\"]"));
        Ipt_LoginPass = getPageElementById(driver, By.xpath("//*[@id=\"nloginpwd\"]"));
        Btn_LoginSubmit = getPageElementById(driver, By.xpath("//*[@id=\"loginsubmit\"]"));
        Ckb_SecurityCheckBox = getPageElementById(driver, By.xpath("//*[@id=\"chkOpenCtrl\"]"));
    }

    public void switchToIframe(WebDriver driver, WebElement targetIframe) {
        //使driver进入Frame_FormLogin内联框架进行元素定位
        driver.switchTo().frame(targetIframe);
    }

    public void switchOutIframe(WebDriver driver) {
        //登录完成后使driver跳出Frame_FormLogin内联框架
        driver.switchTo().defaultContent();
    }

    public void cleanAndLoginPopUpIframe(WebDriver driver, TestUtilFunctions testUtil, WebElement loginName, WebElement loginPass, WebElement loginSubmit) {

        testUtil.clearInputs(driver, loginName);
        testUtil.clearInputs(driver, loginPass);
        loginName.sendKeys(ProjectParams.SimLoginUserName_1);
        loginPass.sendKeys(ProjectParams.SimLoginUserPass);
        testUtil.waitForTime(1000);
        loginSubmit.click();
        testUtil.waitForTime(2000);

    }






}
