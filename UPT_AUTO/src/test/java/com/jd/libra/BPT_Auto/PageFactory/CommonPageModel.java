package com.jd.libra.BPT_Auto.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utils.TestUtilFunctions;


/**
 * Created by changxuliang on 2015/7/14.
 * Latest Updated by changxuliang on 2015/7/16
 * This file is a abstract page object factory which stores all elements and methods on a common page.
 */
public class CommonPageModel {

    TestUtilFunctions testUtil = new TestUtilFunctions();

    public WebElement getPageElementByXpath(WebDriver driver, By byXpath) {

        if (byXpath == null) {
            System.out.println("the input argument :  byXpath is null.");
            return null;
        }
        else if (driver == null) {
            System.out.println("the input argument : driver is null.");
            return null;
        }

        testUtil.waitForElement(driver, byXpath, (long)5000);
        if (testUtil.isElementPresent(driver, byXpath)) {
            WebElement pageElement = driver.findElement(byXpath);
            return pageElement;
        }else{
            System.out.println("the page element : " + byXpath + " is not exist.");
            return null;
        }

    }


    public WebElement getPageElementById(WebDriver driver, By byId){

        if (byId == null) {
            System.out.println("the input argument :  byId is null.");
            return null;
        }
        else if (driver == null) {
            System.out.println("the input argument : driver is null.");
            return null;
        }

        testUtil.waitForElement(driver, byId, (long)5000);
        if (testUtil.isElementPresent(driver, byId)) {
            WebElement pageElement = driver.findElement(byId);
            return pageElement;
        }else{
            System.out.println("the page element : " + byId + " is not exist.");
            return null;
        }
    }


    public WebElement getPageElementByClassName(WebDriver driver, By byClassName){

        if (byClassName == null) {
            System.out.println("the input argument :  byClassName is null.");
            return null;
        }
        else if (driver == null) {
            System.out.println("the input argument : driver is null.");
            return null;
        }

        testUtil.waitForElement(driver, byClassName, (long)5000);
        if (testUtil.isElementPresent(driver, byClassName)) {
            WebElement pageElement = driver.findElement(byClassName);
            return pageElement;
        }else{
            System.out.println("the page element : " + byClassName + " is not exist.");
            return null;
        }

    }


    public WebElement getPageElementByCssSelector(WebDriver driver, By cssSelector){

        if (cssSelector == null) {
            System.out.println("the input argument :  cssSelector is null.");
            return null;
        }
        else if (driver == null) {
            System.out.println("the input argument : driver is null.");
            return null;
        }

        testUtil.waitForElement(driver, cssSelector, (long)5000);
        if (testUtil.isElementPresent(driver, cssSelector)) {
            WebElement pageElement = driver.findElement(cssSelector);
            return pageElement;
        }else{
            System.out.println("the page element : " + cssSelector + " is not exist.");
            return null;
        }

    }


    public WebElement getPageElementByTagName(WebDriver driver, By tagName){

        if (tagName == null) {
            System.out.println("the input argument :  tagName is null.");
            return null;
        }
        else if (driver == null) {
            System.out.println("the input argument : driver is null.");
            return null;
        }

        testUtil.waitForElement(driver, tagName, (long)5000);
        if (testUtil.isElementPresent(driver, tagName)) {
            WebElement pageElement = driver.findElement(tagName);
            return pageElement;
        }else{
            System.out.println("the page element : " + tagName + " is not exist.");
            return null;
        }

    }


    public WebElement getPageElementByName(WebDriver driver, By name){

        if (name == null) {
            System.out.println("the input argument :  tagName is null.");
            return null;
        }
        else if (driver == null) {
            System.out.println("the input argument : driver is null.");
            return null;
        }

        testUtil.waitForElement(driver, name, (long)5000);
        if (testUtil.isElementPresent(driver, name)) {
            WebElement pageElement = driver.findElement(name);
            return pageElement;
        }else{
            System.out.println("the page element : " + name + " is not exist.");
            return null;
        }

    }


    public WebElement getPageElementByPartialLinkText(WebDriver driver, By partialLinkText){

        if (partialLinkText == null) {
            System.out.println("the input argument :  partialLinkText is null.");
            return null;
        }
        else if (driver == null) {
            System.out.println("the input argument : driver is null.");
            return null;
        }

        testUtil.waitForElement(driver, partialLinkText, (long)5000);
        if (testUtil.isElementPresent(driver, partialLinkText)) {
            WebElement pageElement = driver.findElement(partialLinkText);
            return pageElement;
        }else{
            System.out.println("the page element : " + partialLinkText + " is not exist.");
            return null;
        }

    }


    public WebElement getPageElementBylinkText(WebDriver driver, By linkText){

        if (linkText == null) {
            System.out.println("the input argument :  linkText is null.");
            return null;
        }
        else if (driver == null) {
            System.out.println("the input argument : driver is null.");
            return null;
        }

        testUtil.waitForElement(driver, linkText, (long)5000);
        if (testUtil.isElementPresent(driver, linkText)) {
            WebElement pageElement = driver.findElement(linkText);
            return pageElement;
        }else{
            System.out.println("the page element : " + linkText + " is not exist.");
            return null;
        }

    }


    public void OpenTargetURL(WebDriver driver, String url) {
        driver.get(url);
        System.out.println("Start to open the url : " + url);
    }

    public void MaxPageWindow(WebDriver driver){
        driver.manage().window().maximize();
        System.out.println("Page Window is Maximized!");
    }

}
