package com.jd.libra.BPT_Auto.Libra_Stage_One_Iteration_2.Libra_Club;

import java.io.IOException;
import java.util.Properties;

import Utils.DriverUtilFunctions;
import Utils.LogUtilFunctions;
import com.jd.libra.BPT_Auto.TestParams.ProjectParams;
import Utils.TestUtilFunctions;
import com.jd.libra.BPT_Auto.PageFactory.*;

import junit.framework.Assert;
import org.junit.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by changxuliang on 2015/3/17.
 * Latest Updated by changxuliang on 2015/7/16
 * This java file is used for the auto ui test of the test case 167543 on the Matrix
 * It covers Chrome browser
 */
public class TestCase_167543 {


    @Test
    /**
     *-> 话题页_首页侧滑条调整测试_Chrome_HomePage_Test() is used for test the homepage go top function
     */
    public void 话题页_首页侧滑条调整测试_首页_Chrome_Test() throws IOException {

        //create the testUtilFunctions instance
        TestUtilFunctions testUtil = new TestUtilFunctions();

        //初始化DriverUtilFunctions类，在其构造函数中设置driver启动路径
        new DriverUtilFunctions("Chrome");

        // 创建一个 Chrome 的浏览器实例
        WebDriver chromeDriver = new ChromeDriver();

        //初始化LogUtilFunctions类，创建此类实例并设置当前测试用例的日志配置
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_167543", ProjectParams.ChromeTest_167543_HomePage_LayOut, ProjectParams.ChromeDriverLocalPath);

        Libra_Page_PreIndex libraPagePreIndex = new Libra_Page_PreIndex();
        Libra_Page_Index libraPageIndex = new Libra_Page_Index();

        // 让浏览器访问 Libra 京友邦首页
        libraPagePreIndex.OpenTargetURL(chromeDriver, ProjectParams.LibraURL);

        //最大化浏览器窗口
        libraPagePreIndex.MaxPageWindow(chromeDriver);


        //先获取用户指南页页面元素
        libraPagePreIndex.getLibraPagePreIndexElement(chromeDriver);
        //判断用户教程浮层是否出现，若出现则直接关闭
        if (libraPagePreIndex.Btn_Tutorial_Close != null) {
            testUtil.waitForTime(2000);
            libraPagePreIndex.Btn_Tutorial_Close.click();
        } else {
            System.out.println("There is no tutorial pop-up!");
        }

        //判断21号限时类型勋章浮层是否出现，若出现则直接关闭
        /*testUtil.waitForElement(driver, By.id("simplemodal-data"), (long)5000);
        if (testUtil.isElementPresent(driver, By.id("simplemodal-data"))) {

            WebElement Btn_PopUp21Medal_Close = driver.findElement(By.xpath("/*//*[@id=\"simplemodal-data\"]/span[1]"));
            testUtil.waitForTime(2000);
            Btn_PopUp21Medal_Close.click();

        } else {
            System.out.println("The 21 metal is not located!");
        }*/

        //execute the JS to simulate the scroll action which jump to the bottom of the homepage
        testUtil.waitForTime(3000);
        ((JavascriptExecutor)chromeDriver).executeScript("scrollTo(0,10000)");

        //先获取首页页面元素
        libraPageIndex.getLibraPageIndexElement(chromeDriver);
        Assert.assertTrue((libraPageIndex.Btn_GoTop.isDisplayed()));

        if (libraPageIndex.Btn_GoTop.isDisplayed()) {

            libraPageIndex.Btn_GoTop.click();
            testUtil.waitForTime(3000);
            //验证当模拟用户点击“返回顶部”按钮后，首页“请您帮忙”部件出现
            Assert.assertTrue(libraPageIndex.Banner_tab_left.isDisplayed());

        } else {
            System.out.println("the button [Jump to Top] is not found");
        }

        // 关闭浏览器
        chromeDriver.quit();

    }


    @Test
    /**
     *-> 话题页_首页侧滑条调整测试_盖楼话题_Chrome_Test() is used for test the standard topic go top function
     */
    public void 话题页_首页侧滑条调整测试_盖楼话题_Chrome_Test() throws IOException {

        //create the testUtilFunctions instance
        TestUtilFunctions testUtil = new TestUtilFunctions();

        //初始化DriverUtilFunctions类，在其构造函数中设置driver启动路径
        new DriverUtilFunctions("Chrome");

        // 创建一个 Chrome 的浏览器实例
        WebDriver chromeDriver = new ChromeDriver();

        //初始化LogUtilFunctions类，创建此类实例并设置当前测试用例的日志配置
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_167543", ProjectParams.ChromeTest_167543_StdTopic_LayOut, ProjectParams.ChromeDriverLocalPath);

        Libra_Page_PreIndex libraPagePreIndex = new Libra_Page_PreIndex();
        Libra_Page_StandardTopic libraPageStandardTopic = new Libra_Page_StandardTopic();

        // 让浏览器访问 Libra 京友邦盖楼话题页
        libraPagePreIndex.OpenTargetURL(chromeDriver, ProjectParams.StandardTopicURL);

        //最大化浏览器窗口
        libraPagePreIndex.MaxPageWindow(chromeDriver);

        //先获取用户指南页页面元素
        libraPagePreIndex.getLibraPagePreIndexElement(chromeDriver);
        //判断用户教程浮层是否出现，若出现则直接关闭
        if (libraPagePreIndex.Btn_Tutorial_Close != null) {
            testUtil.waitForTime(2000);
            libraPagePreIndex.Btn_Tutorial_Close.click();
        } else {
            System.out.println("There is no tutorial pop-up!");
        }

        //判断21号限时类型勋章浮层是否出现，若出现则直接关闭
        /*testUtil.waitForElement(driver, By.id("simplemodal-data"), (long)5000);
        if (testUtil.isElementPresent(driver, By.id("simplemodal-data"))) {

            WebElement Btn_PopUp21Medal_Close = driver.findElement(By.xpath("/*//*[@id=\"simplemodal-data\"]/span[1]"));
            testUtil.waitForTime(2000);
            Btn_PopUp21Medal_Close.click();

        } else {
            System.out.println("The 21 metal is not located!");
        }*/

        //execute the JS to simulate the scroll action which jump to the bottom of the homepage
        testUtil.waitForTime(3000);
        ((JavascriptExecutor)chromeDriver).executeScript("scrollTo(0,10000)");

        //先获取盖楼页页面元素
        libraPageStandardTopic.getLibraPageStandardTopicElement(chromeDriver);
        Assert.assertTrue((libraPageStandardTopic.Btn_GoTop.isDisplayed()));

        if (libraPageStandardTopic.Btn_GoTop.isDisplayed()) {

            libraPageStandardTopic.Btn_GoTop.click();
            testUtil.waitForTime(3000);
            //验证当模拟用户点击“返回顶部”按钮后，盖楼话题页内容部件出现
            Assert.assertTrue(libraPageStandardTopic.Dlg_Share_Title.isDisplayed());

        } else {
            System.out.println("the button [Jump to Top] is not found");
        }

        // 关闭浏览器
        chromeDriver.quit();

    }


    @Test
    /**
     *-> 话题页_首页侧滑条调整测试_PK话题_Chrome_Test() is used for test the PK topic go top function
     */
    public void 话题页_首页侧滑条调整测试_PK话题_Chrome_Test() throws IOException {

        //create the testUtilFunctions instance
        TestUtilFunctions testUtil = new TestUtilFunctions();

        //初始化DriverUtilFunctions类，在其构造函数中设置driver启动路径
        new DriverUtilFunctions("Chrome");

        // 创建一个 Chrome 的浏览器实例
        WebDriver chromeDriver = new ChromeDriver();

        //初始化LogUtilFunctions类，创建此类实例并设置当前测试用例的日志配置
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_167543", ProjectParams.ChromeTest_167543_PKTopic_LayOut, ProjectParams.ChromeDriverLocalPath);

        Libra_Page_PreIndex libraPagePreIndex = new Libra_Page_PreIndex();
        Libra_Page_PKTopic libraPagePkTopic = new Libra_Page_PKTopic();

        // 让浏览器访问 Libra 京友邦首页
        libraPagePreIndex.OpenTargetURL(chromeDriver, ProjectParams.PKTopicURL);

        //最大化浏览器窗口
        libraPagePreIndex.MaxPageWindow(chromeDriver);

        //先获取用户指南页页面元素
        libraPagePreIndex.getLibraPagePreIndexElement(chromeDriver);
        //判断用户教程浮层是否出现，若出现则直接关闭
        if (libraPagePreIndex.Btn_Tutorial_Close != null) {
            testUtil.waitForTime(2000);
            libraPagePreIndex.Btn_Tutorial_Close.click();
        } else {
            System.out.println("There is no tutorial pop-up!");
        }

        //判断21号限时类型勋章浮层是否出现，若出现则直接关闭
        /*testUtil.waitForElement(driver, By.id("simplemodal-data"), (long)5000);
        if (testUtil.isElementPresent(driver, By.id("simplemodal-data"))) {

            WebElement Btn_PopUp21Medal_Close = driver.findElement(By.xpath("/*//*[@id=\"simplemodal-data\"]/span[1]"));
            testUtil.waitForTime(2000);
            Btn_PopUp21Medal_Close.click();

        } else {
            System.out.println("The 21 metal is not located!");
        }*/

        //execute the JS to simulate the scroll action which jump to the bottom of the homepage
        testUtil.waitForTime(3000);
        ((JavascriptExecutor)chromeDriver).executeScript("scrollTo(0,10000)");

        //先获取PK页页面元素
        libraPagePkTopic.getLibraPagePKTopicElement(chromeDriver);
        Assert.assertTrue((libraPagePkTopic.Btn_GoTop.isDisplayed()));

        if (libraPagePkTopic.Btn_GoTop.isDisplayed()) {

            libraPagePkTopic.Btn_GoTop.click();
            testUtil.waitForTime(3000);
            //验证当模拟用户点击“返回顶部”按钮后，PK话题页内容部件出现
            Assert.assertTrue(libraPagePkTopic.PK_Logo.isDisplayed());

        } else {
            System.out.println("the button [Jump to Top] is not found");
        }

        // 关闭浏览器
        chromeDriver.quit();

    }


    @Test
    /**
     *-> 话题页_首页侧滑条调整测试_Firefox_HomePage_Test() is used for test the homepage go top function
     */
    public void 话题页_首页侧滑条调整测试_首页_Firefox_Test() throws IOException {

        //create the testUtilFunctions instance
        TestUtilFunctions testUtil = new TestUtilFunctions();

        //初始化DriverUtilFunctions类，在其构造函数中设置driver启动路径
        new DriverUtilFunctions("Firefox");

        // 创建一个 firefox 的浏览器实例
        WebDriver firefoxDriver = new FirefoxDriver();

        //初始化LogUtilFunctions类，创建此类实例并设置当前测试用例的日志配置
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_167543", ProjectParams.FirefoxTest_167543_HomePage_LayOut, ProjectParams.FireFoxDriverLocalPath);

        Libra_Page_PreIndex libraPagePreIndex = new Libra_Page_PreIndex();
        Libra_Page_Index libraPageIndex = new Libra_Page_Index();

        // 让浏览器访问 Libra 京友邦首页
        libraPagePreIndex.OpenTargetURL(firefoxDriver, ProjectParams.LibraURL);

        //最大化浏览器窗口
        libraPagePreIndex.MaxPageWindow(firefoxDriver);


        //先获取用户指南页页面元素
        libraPagePreIndex.getLibraPagePreIndexElement(firefoxDriver);
        //判断用户教程浮层是否出现，若出现则直接关闭
        if (libraPagePreIndex.Btn_Tutorial_Close != null) {
            testUtil.waitForTime(2000);
            libraPagePreIndex.Btn_Tutorial_Close.click();
        } else {
            System.out.println("There is no tutorial pop-up!");
        }

        //判断21号限时类型勋章浮层是否出现，若出现则直接关闭
        /*testUtil.waitForElement(driver, By.id("simplemodal-data"), (long)5000);
        if (testUtil.isElementPresent(driver, By.id("simplemodal-data"))) {

            WebElement Btn_PopUp21Medal_Close = driver.findElement(By.xpath("/*//*[@id=\"simplemodal-data\"]/span[1]"));
            testUtil.waitForTime(2000);
            Btn_PopUp21Medal_Close.click();

        } else {
            System.out.println("The 21 metal is not located!");
        }*/

        //execute the JS to simulate the scroll action which jump to the bottom of the homepage
        testUtil.waitForTime(3000);
        ((JavascriptExecutor)firefoxDriver).executeScript("scrollTo(0,10000)");

        //先获取首页页面元素
        libraPageIndex.getLibraPageIndexElement(firefoxDriver);
        Assert.assertTrue((libraPageIndex.Btn_GoTop.isDisplayed()));

        if (libraPageIndex.Btn_GoTop.isDisplayed()) {

            libraPageIndex.Btn_GoTop.click();
            testUtil.waitForTime(3000);
            //验证当模拟用户点击“返回顶部”按钮后，首页“请您帮忙”部件出现
            Assert.assertTrue(libraPageIndex.Banner_tab_left.isDisplayed());

        } else {
            System.out.println("the button [Jump to Top] is not found");
        }

        // 关闭浏览器
        firefoxDriver.quit();

    }


    @Test
    /**
     *-> 话题页_首页侧滑条调整测试_盖楼话题_Firefox_Test() is used for test the standard topic go top function
     */
    public void 话题页_首页侧滑条调整测试_盖楼话题_Firefox_Test() throws IOException {

        //create the testUtilFunctions instance
        TestUtilFunctions testUtil = new TestUtilFunctions();

        //初始化DriverUtilFunctions类，在其构造函数中设置driver启动路径
        new DriverUtilFunctions("Firefox");

        // 创建一个 firefox 的浏览器实例
        WebDriver firefoxDriver = new FirefoxDriver();

        //初始化LogUtilFunctions类，创建此类实例并设置当前测试用例的日志配置
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_167543", ProjectParams.FirefoxTest_167543_StdTopic_LayOut, ProjectParams.FireFoxDriverLocalPath);

        Libra_Page_PreIndex libraPagePreIndex = new Libra_Page_PreIndex();
        Libra_Page_StandardTopic libraPageStandardTopic = new Libra_Page_StandardTopic();

        // 让浏览器访问 Libra 京友邦盖楼话题页
        libraPagePreIndex.OpenTargetURL(firefoxDriver, ProjectParams.StandardTopicURL);

        //最大化浏览器窗口
        libraPagePreIndex.MaxPageWindow(firefoxDriver);

        //先获取用户指南页页面元素
        libraPagePreIndex.getLibraPagePreIndexElement(firefoxDriver);
        //判断用户教程浮层是否出现，若出现则直接关闭
        if (libraPagePreIndex.Btn_Tutorial_Close != null) {
            testUtil.waitForTime(2000);
            libraPagePreIndex.Btn_Tutorial_Close.click();
        } else {
            System.out.println("There is no tutorial pop-up!");
        }

        //判断21号限时类型勋章浮层是否出现，若出现则直接关闭
        /*testUtil.waitForElement(driver, By.id("simplemodal-data"), (long)5000);
        if (testUtil.isElementPresent(driver, By.id("simplemodal-data"))) {

            WebElement Btn_PopUp21Medal_Close = driver.findElement(By.xpath("/*//*[@id=\"simplemodal-data\"]/span[1]"));
            testUtil.waitForTime(2000);
            Btn_PopUp21Medal_Close.click();

        } else {
            System.out.println("The 21 metal is not located!");
        }*/

        //execute the JS to simulate the scroll action which jump to the bottom of the homepage
        testUtil.waitForTime(3000);
        ((JavascriptExecutor)firefoxDriver).executeScript("scrollTo(0,10000)");

        //先获取盖楼页页面元素
        libraPageStandardTopic.getLibraPageStandardTopicElement(firefoxDriver);
        Assert.assertTrue((libraPageStandardTopic.Btn_GoTop.isDisplayed()));

        if (libraPageStandardTopic.Btn_GoTop.isDisplayed()) {

            libraPageStandardTopic.Btn_GoTop.click();
            testUtil.waitForTime(3000);
            //验证当模拟用户点击“返回顶部”按钮后，盖楼话题页内容部件出现
            Assert.assertTrue(libraPageStandardTopic.Dlg_Share_Title.isDisplayed());

        } else {
            System.out.println("the button [Jump to Top] is not found");
        }

        // 关闭浏览器
        firefoxDriver.quit();

    }


    @Test
    /**
     *-> 话题页_首页侧滑条调整测试_PK话题_Firefox_Test() is used for test the PK topic go top function
     */
    public void 话题页_首页侧滑条调整测试_PK话题_Firefox_Test() throws IOException {

        //create the testUtilFunctions instance
        TestUtilFunctions testUtil = new TestUtilFunctions();

        //初始化DriverUtilFunctions类，在其构造函数中设置driver启动路径
        new DriverUtilFunctions("Firefox");

        // 创建一个 firefox 的浏览器实例
        WebDriver firefoxDriver = new FirefoxDriver();

        //初始化LogUtilFunctions类，创建此类实例并设置当前测试用例的日志配置
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_167543", ProjectParams.FirefoxTest_167543_PKTopic_LayOut, ProjectParams.FireFoxDriverLocalPath);

        Libra_Page_PreIndex libraPagePreIndex = new Libra_Page_PreIndex();
        Libra_Page_PKTopic libraPagePkTopic = new Libra_Page_PKTopic();

        // 让浏览器访问 Libra 京友邦首页
        libraPagePreIndex.OpenTargetURL(firefoxDriver, ProjectParams.PKTopicURL);

        //最大化浏览器窗口
        libraPagePreIndex.MaxPageWindow(firefoxDriver);

        //先获取用户指南页页面元素
        libraPagePreIndex.getLibraPagePreIndexElement(firefoxDriver);
        //判断用户教程浮层是否出现，若出现则直接关闭
        if (libraPagePreIndex.Btn_Tutorial_Close != null) {
            testUtil.waitForTime(2000);
            libraPagePreIndex.Btn_Tutorial_Close.click();
        } else {
            System.out.println("There is no tutorial pop-up!");
        }

        //判断21号限时类型勋章浮层是否出现，若出现则直接关闭
        /*testUtil.waitForElement(driver, By.id("simplemodal-data"), (long)5000);
        if (testUtil.isElementPresent(driver, By.id("simplemodal-data"))) {

            WebElement Btn_PopUp21Medal_Close = driver.findElement(By.xpath("/*//*[@id=\"simplemodal-data\"]/span[1]"));
            testUtil.waitForTime(2000);
            Btn_PopUp21Medal_Close.click();

        } else {
            System.out.println("The 21 metal is not located!");
        }*/

        //execute the JS to simulate the scroll action which jump to the bottom of the homepage
        testUtil.waitForTime(3000);
        ((JavascriptExecutor)firefoxDriver).executeScript("scrollTo(0,10000)");

        //先获取PK页页面元素
        libraPagePkTopic.getLibraPagePKTopicElement(firefoxDriver);
        Assert.assertTrue((libraPagePkTopic.Btn_GoTop.isDisplayed()));

        if (libraPagePkTopic.Btn_GoTop.isDisplayed()) {

            libraPagePkTopic.Btn_GoTop.click();
            testUtil.waitForTime(3000);
            //验证当模拟用户点击“返回顶部”按钮后，PK话题页内容部件出现
            Assert.assertTrue(libraPagePkTopic.PK_Logo.isDisplayed());

        } else {
            System.out.println("the button [Jump to Top] is not found");
        }

        // 关闭浏览器
        firefoxDriver.quit();

    }


    @Test
    /**
     *-> 话题页_首页侧滑条调整测试_IE_HomePage_Test() is used for test the homepage go top function
     */
    public void 话题页_首页侧滑条调整测试_首页_IE_Test() throws IOException {

        //create the testUtilFunctions instance
        TestUtilFunctions testUtil = new TestUtilFunctions();

        //初始化DriverUtilFunctions类，在其构造函数中设置driver启动路径
        new DriverUtilFunctions("IE");

        // 设置 IEdriver 的路径属性
        DesiredCapabilities ieCapabilities = testUtil.setIEdriverProperties(ProjectParams.IEDriverLocalPath);

        // 创建一个 IE 的浏览器实例
        WebDriver IEDriver = new InternetExplorerDriver(ieCapabilities);

        //初始化LogUtilFunctions类，创建此类实例并设置当前测试用例的日志配置
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_167543", ProjectParams.IETest_167543_HomePage_LayOut, ProjectParams.IEDriverLocalPath);


        Libra_Page_PreIndex libraPagePreIndex = new Libra_Page_PreIndex();
        Libra_Page_Index libraPageIndex = new Libra_Page_Index();

        // 让浏览器访问 Libra 京友邦首页
        libraPagePreIndex.OpenTargetURL(IEDriver, ProjectParams.LibraURL);

        //最大化浏览器窗口
        libraPagePreIndex.MaxPageWindow(IEDriver);

        //先获取用户指南页页面元素
        libraPagePreIndex.getLibraPagePreIndexElement(IEDriver);
        //判断用户教程浮层是否出现，若出现则直接关闭
        if (libraPagePreIndex.Btn_Tutorial_Close != null) {
            testUtil.waitForTime(2000);
            libraPagePreIndex.Btn_Tutorial_Close.click();
        } else {
            System.out.println("There is no tutorial pop-up!");
        }

        //判断21号限时类型勋章浮层是否出现，若出现则直接关闭
        /*testUtil.waitForElement(driver, By.id("simplemodal-data"), (long)5000);
        if (testUtil.isElementPresent(driver, By.id("simplemodal-data"))) {

            WebElement Btn_PopUp21Medal_Close = driver.findElement(By.xpath("/*//*[@id=\"simplemodal-data\"]/span[1]"));
            testUtil.waitForTime(2000);
            Btn_PopUp21Medal_Close.click();

        } else {
            System.out.println("The 21 metal is not located!");
        }*/

        //execute the JS to simulate the scroll action which jump to the bottom of the homepage
        testUtil.waitForTime(3000);
        ((JavascriptExecutor)IEDriver).executeScript("scrollTo(0,10000)");

        //先获取首页页面元素
        libraPageIndex.getLibraPageIndexElement(IEDriver);
        Assert.assertTrue((libraPageIndex.Btn_GoTop.isDisplayed()));

        if (libraPageIndex.Btn_GoTop.isDisplayed()) {

            libraPageIndex.Btn_GoTop.click();
            testUtil.waitForTime(3000);
            //验证当模拟用户点击“返回顶部”按钮后，首页“请您帮忙”部件出现
            Assert.assertTrue(libraPageIndex.Banner_tab_left.isDisplayed());

        } else {
            System.out.println("the button [Jump to Top] is not found");
        }

        // 关闭浏览器
        IEDriver.quit();

    }



    @Test
    /**
     *-> 话题页_首页侧滑条调整测试_盖楼话题_IE_Test() is used for test the standard topic go top function
     */
    public void 话题页_首页侧滑条调整测试_盖楼话题_IE_Test() throws IOException {

        //create the testUtilFunctions instance
        TestUtilFunctions testUtil = new TestUtilFunctions();

        //初始化DriverUtilFunctions类，在其构造函数中设置driver启动路径
        new DriverUtilFunctions("IE");

        // 设置 IEdriver 的路径属性
        DesiredCapabilities ieCapabilities = testUtil.setIEdriverProperties(ProjectParams.IEDriverLocalPath);

        // 创建一个 IE 的浏览器实例
        WebDriver IEDriver = new InternetExplorerDriver(ieCapabilities);

        //初始化LogUtilFunctions类，创建此类实例并设置当前测试用例的日志配置
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_167543", ProjectParams.IETest_167543_StdTopic_LayOut, ProjectParams.IEDriverLocalPath);

        Libra_Page_PreIndex libraPagePreIndex = new Libra_Page_PreIndex();
        Libra_Page_StandardTopic libraPageStandardTopic = new Libra_Page_StandardTopic();

        // 让浏览器访问 Libra 京友邦盖楼话题页
        libraPagePreIndex.OpenTargetURL(IEDriver, ProjectParams.StandardTopicURL);

        //最大化浏览器窗口
        libraPagePreIndex.MaxPageWindow(IEDriver);

        //先获取用户指南页页面元素
        libraPagePreIndex.getLibraPagePreIndexElement(IEDriver);
        //判断用户教程浮层是否出现，若出现则直接关闭
        if (libraPagePreIndex.Btn_Tutorial_Close != null) {
            testUtil.waitForTime(2000);
            libraPagePreIndex.Btn_Tutorial_Close.click();
        } else {
            System.out.println("There is no tutorial pop-up!");
        }

        //判断21号限时类型勋章浮层是否出现，若出现则直接关闭
        /*testUtil.waitForElement(driver, By.id("simplemodal-data"), (long)5000);
        if (testUtil.isElementPresent(driver, By.id("simplemodal-data"))) {

            WebElement Btn_PopUp21Medal_Close = driver.findElement(By.xpath("/*//*[@id=\"simplemodal-data\"]/span[1]"));
            testUtil.waitForTime(2000);
            Btn_PopUp21Medal_Close.click();

        } else {
            System.out.println("The 21 metal is not located!");
        }*/

        //execute the JS to simulate the scroll action which jump to the bottom of the homepage
        testUtil.waitForTime(3000);
        ((JavascriptExecutor)IEDriver).executeScript("scrollTo(0,10000)");

        //先获取盖楼页页面元素
        libraPageStandardTopic.getLibraPageStandardTopicElement(IEDriver);
        Assert.assertTrue((libraPageStandardTopic.Btn_GoTop.isDisplayed()));

        if (libraPageStandardTopic.Btn_GoTop.isDisplayed()) {

            libraPageStandardTopic.Btn_GoTop.click();
            testUtil.waitForTime(3000);
            //验证当模拟用户点击“返回顶部”按钮后，盖楼话题页内容部件出现
            Assert.assertTrue(libraPageStandardTopic.Dlg_Share_Title.isDisplayed());

        } else {
            System.out.println("the button [Jump to Top] is not found");
        }

        // 关闭浏览器
        IEDriver.quit();

    }



    @Test
    /**
     *-> 话题页_首页侧滑条调整测试_PK话题_IE_Test() is used for test the PK topic go top function
     */
    public void 话题页_首页侧滑条调整测试_PK话题_IE_Test() throws IOException {

        //create the testUtilFunctions instance
        TestUtilFunctions testUtil = new TestUtilFunctions();

        //初始化DriverUtilFunctions类，在其构造函数中设置driver启动路径
        new DriverUtilFunctions("IE");

        // 设置 IEdriver 的路径属性
        DesiredCapabilities ieCapabilities = testUtil.setIEdriverProperties(ProjectParams.IEDriverLocalPath);

        // 创建一个 IE 的浏览器实例
        WebDriver IEDriver = new InternetExplorerDriver(ieCapabilities);

        //初始化LogUtilFunctions类，创建此类实例并设置当前测试用例的日志配置
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_167543", ProjectParams.IETest_167543_PKTopic_LayOut, ProjectParams.IEDriverLocalPath);

        Libra_Page_PreIndex libraPagePreIndex = new Libra_Page_PreIndex();
        Libra_Page_PKTopic libraPagePkTopic = new Libra_Page_PKTopic();

        // 让浏览器访问 Libra 京友邦首页
        libraPagePreIndex.OpenTargetURL(IEDriver, ProjectParams.PKTopicURL);

        //最大化浏览器窗口
        libraPagePreIndex.MaxPageWindow(IEDriver);

        //先获取用户指南页页面元素
        libraPagePreIndex.getLibraPagePreIndexElement(IEDriver);
        //判断用户教程浮层是否出现，若出现则直接关闭
        if (libraPagePreIndex.Btn_Tutorial_Close != null) {
            testUtil.waitForTime(2000);
            libraPagePreIndex.Btn_Tutorial_Close.click();
        } else {
            System.out.println("There is no tutorial pop-up!");
        }

        //判断21号限时类型勋章浮层是否出现，若出现则直接关闭
        /*testUtil.waitForElement(driver, By.id("simplemodal-data"), (long)5000);
        if (testUtil.isElementPresent(driver, By.id("simplemodal-data"))) {

            WebElement Btn_PopUp21Medal_Close = driver.findElement(By.xpath("/*//*[@id=\"simplemodal-data\"]/span[1]"));
            testUtil.waitForTime(2000);
            Btn_PopUp21Medal_Close.click();

        } else {
            System.out.println("The 21 metal is not located!");
        }*/

        //execute the JS to simulate the scroll action which jump to the bottom of the homepage
        testUtil.waitForTime(3000);
        ((JavascriptExecutor)IEDriver).executeScript("scrollTo(0,10000)");

        //先获取PK页页面元素
        libraPagePkTopic.getLibraPagePKTopicElement(IEDriver);
        Assert.assertTrue((libraPagePkTopic.Btn_GoTop.isDisplayed()));

        if (libraPagePkTopic.Btn_GoTop.isDisplayed()) {

            libraPagePkTopic.Btn_GoTop.click();
            testUtil.waitForTime(3000);
            //验证当模拟用户点击“返回顶部”按钮后，PK话题页内容部件出现
            Assert.assertTrue(libraPagePkTopic.PK_Logo.isDisplayed());

        } else {
            System.out.println("the button [Jump to Top] is not found");
        }

        // 关闭浏览器
        IEDriver.quit();

    }




}