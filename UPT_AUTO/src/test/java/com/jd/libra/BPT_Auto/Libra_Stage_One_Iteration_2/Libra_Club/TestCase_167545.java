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

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by changxuliang on 2015/3/18.
 * This java file is used for the auto ui test of the test case 167545 on the Matrix
 * It covers Chrome browser
 */
public class TestCase_167545 {
    @Test
    /**
     *-> 话题外链校验测试_Chrome_Test() is used for test the homepage go top function
     */
    public void 话题外链校验测试_Chrome_Test() throws IOException {

        //create the testUtilFunctions instance
        TestUtilFunctions testUtil = new TestUtilFunctions();

        //初始化DriverUtilFunctions类，在其构造函数中设置driver启动路径
        new DriverUtilFunctions("Chrome");

        // 创建一个 Chrome 的浏览器实例
        WebDriver chromeDriver = new ChromeDriver();

        //初始化LogUtilFunctions类，创建此类实例并设置当前测试用例的日志配置
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_167543", ProjectParams.ChromeTest_167545_LayOut, ProjectParams.ChromeDriverLocalPath);

        Libra_Page_PreIndex libraPagePreIndex = new Libra_Page_PreIndex();
        Libra_Page_Index libraPageIndex = new Libra_Page_Index();
        Libra_Page_iFrame libraPageIframe = new Libra_Page_iFrame();

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

        //模拟用户点击 “我的话题” 进行登录
        testUtil.waitForTime(3000);
        libraPageIndex.getLibraPageIndexElement(chromeDriver);
        Assert.assertTrue((libraPageIndex.Btn_MyTopic.isDisplayed()));

        if (libraPageIndex.Btn_MyTopic.isDisplayed()) {
            libraPageIndex.Btn_MyTopic.click();
            testUtil.waitForTime(5000);

            //当登录窗口弹出时，对其进行登录操作,首先获取iFrame框架
            libraPageIframe.getLibraPagePopUpLoginIframeElement(chromeDriver);

            if (libraPageIframe.Dlg_Frame_FormLogin != null) {

                //使driver进入Frame_FormLogin内联框架进行元素定位
                libraPageIframe.switchToIframe(chromeDriver, libraPageIframe.Dlg_Frame_FormLogin);
                //当进入iFrame框架后，再次获取iFrame的页面元素
                libraPageIframe.getLibraPagePopUpLoginIframeElement(chromeDriver);

                if (libraPageIframe.Ckb_SecurityCheckBox != null) {
                    testUtil.waitForTime(1000);
                    //查看安全控件是否被选中，若被选中则取消掉，便于密码输入
                    if (libraPageIframe.Ckb_SecurityCheckBox.isSelected()) {
                        libraPageIframe.Ckb_SecurityCheckBox.click();
                        testUtil.waitForTime(1000);
                    } else {
                        System.out.println("The SecurityCheckBox is not exist!");
                    }

                    if (libraPageIframe.Ipt_LoginName != null && libraPageIframe.Ipt_LoginPass != null && libraPageIframe.Btn_LoginSubmit != null) {
                        libraPageIframe.cleanAndLoginPopUpIframe(chromeDriver, testUtil, libraPageIframe.Ipt_LoginName, libraPageIframe.Ipt_LoginPass, libraPageIframe.Btn_LoginSubmit);
                    } else {
                        System.out.println("The iFrame login name, pass, submit cannot located!");
                    }

                    //登录完成后使driver跳出Frame_FormLogin内联框架
                    libraPageIframe.switchOutIframe(chromeDriver);

                    if (libraPageIndex.Btn_MyTopicContainer_Close != null) {
                        testUtil.waitForTime(2000);
                        libraPageIndex.Btn_MyTopicContainer_Close.click();
                    } else {
                        System.out.println("The MyTopic Contents is not pop-up!");
                    }

                } else {
                    //此分支为libraPageIframe.Ckb_SecurityCheckBox不存在时的操作
                    if (libraPageIframe.Ipt_LoginName != null && libraPageIframe.Ipt_LoginPass != null && libraPageIframe.Btn_LoginSubmit != null) {
                        libraPageIframe.cleanAndLoginPopUpIframe(chromeDriver, testUtil, libraPageIframe.Ipt_LoginName, libraPageIframe.Ipt_LoginPass, libraPageIframe.Btn_LoginSubmit);
                    } else {
                        System.out.println("The iFrame login name, pass, submit cannot located!");
                    }

                    //登录完成后使driver跳出Frame_FormLogin内联框架
                    libraPageIframe.switchOutIframe(chromeDriver);

                    if (libraPageIndex.Btn_MyTopicContainer_Close != null) {
                        testUtil.waitForTime(2000);
                        libraPageIndex.Btn_MyTopicContainer_Close.click();
                    } else {
                        System.out.println("The MyTopic Contents is not pop-up!");
                    }
                }

            } else {
                System.out.println("The user already login!");
                if (libraPageIndex.Btn_MyTopicContainer_Close != null) {
                    testUtil.waitForTime(2000);
                    libraPageIndex.Btn_MyTopicContainer_Close.click();
                }
            }
        } else {
            System.out.println("the button [我的话题] is not located");
        }

        //模拟用户在libra首页发表盖楼话题并测试话题外链校验
        if (libraPageIndex.Btn_UserAsk != null) {
            testUtil.waitForTime(3000);
            libraPageIndex.Btn_UserAsk.click();
        } else {
            System.out.println("The btn [我要提问] is not located");
        }

        //断言此时提问窗口弹出
        testUtil.waitForTime(1000);
        Assert.assertTrue(libraPageIndex.Dlg_PopupAskContainer.isDisplayed());
        if (libraPageIndex.Ipt_AskUrl != null && libraPageIndex.Ipt_AskTextArea != null && libraPageIndex.Btn_AskSubmit != null) {

            libraPageIndex.Ipt_AskUrl.sendKeys(ProjectParams.TargetSkuUrl_1);
            libraPageIndex.Ipt_AskTextArea.sendKeys(ProjectParams.TargetDialogAskInput_4);
            libraPageIndex.Btn_AskSubmit.click();

            //断言点击创建话题后的返回结果
            testUtil.waitForTime(1000);
            if (libraPageIndex.Dlg_ActReturns_CreateTopic != null) {
                Assert.assertEquals(ProjectParams.CreateTopicReturns_1, libraPageIndex.Dlg_ActReturns_CreateTopic.getText());
            }

            //清空URL栏并未下次输入做准备
            libraPageIndex.cleanMyTopicContainerAskTextArea(chromeDriver, testUtil);

            //外链TargetDialogAskInput_5测试
            libraPageIndex.Ipt_AskTextArea.sendKeys(ProjectParams.TargetDialogAskInput_5);
            libraPageIndex.Btn_AskSubmit.click();

            //断言点击创建话题后的返回结果
            testUtil.waitForTime(1000);
            if (libraPageIndex.Dlg_ActReturns_CreateTopic != null) {
                Assert.assertEquals(ProjectParams.CreateTopicReturns_1, libraPageIndex.Dlg_ActReturns_CreateTopic.getText());
            }

            //清空URL栏并未下次输入做准备
            libraPageIndex.cleanMyTopicContainerAskTextArea(chromeDriver, testUtil);

            //外链TargetDialogAskInput_6测试
            libraPageIndex.Ipt_AskTextArea.sendKeys(ProjectParams.TargetDialogAskInput_6);
            libraPageIndex.Btn_AskSubmit.click();

            //断言点击创建话题后的返回结果
            testUtil.waitForTime(1000);
            if (libraPageIndex.Dlg_ActReturns_CreateTopic != null) {
                Assert.assertEquals(ProjectParams.CreateTopicReturns_1, libraPageIndex.Dlg_ActReturns_CreateTopic.getText());
            }

            //清空URL栏并未下次输入做准备
            libraPageIndex.cleanMyTopicContainerAskTextArea(chromeDriver, testUtil);

            //外链TargetDialogAskInput_7测试
            libraPageIndex.Ipt_AskTextArea.sendKeys(ProjectParams.TargetDialogAskInput_7);
            libraPageIndex.Btn_AskSubmit.click();

            //断言点击创建话题后的返回结果
            testUtil.waitForTime(1000);
            if (libraPageIndex.Dlg_ActReturns_CreateTopic != null) {
                Assert.assertEquals(ProjectParams.CreateTopicReturns_1, libraPageIndex.Dlg_ActReturns_CreateTopic.getText());
            }

            //清空URL栏并未下次输入做准备
            libraPageIndex.cleanMyTopicContainerAskTextArea(chromeDriver, testUtil);

            libraPageIndex.Btn_AskClose.click();

            chromeDriver.quit();

        }

    }




    @Test
    /**
     *-> 话题外链校验测试_Firefox_Test() is used for test the homepage go top function
     */
    public void 话题外链校验测试_Firefox_Test() throws IOException {
        //create the testUtilFunctions instance
        TestUtilFunctions testUtil = new TestUtilFunctions();

        //初始化DriverUtilFunctions类，在其构造函数中设置driver启动路径
        new DriverUtilFunctions("Firefox");

        // 创建一个 Chrome 的浏览器实例
        WebDriver firefoxDriver = new FirefoxDriver();

        //初始化LogUtilFunctions类，创建此类实例并设置当前测试用例的日志配置
        LogUtilFunctions logUtil = new LogUtilFunctions();
        logUtil.setLoggerProperties("TestCase_167543", ProjectParams.FirefoxTest_167545_LayOut, ProjectParams.FireFoxDriverLocalPath);

        Libra_Page_PreIndex libraPagePreIndex = new Libra_Page_PreIndex();
        Libra_Page_Index libraPageIndex = new Libra_Page_Index();
        Libra_Page_iFrame libraPageIframe = new Libra_Page_iFrame();

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

        //模拟用户点击 “我的话题” 进行登录
        testUtil.waitForTime(3000);
        libraPageIndex.getLibraPageIndexElement(firefoxDriver);
        Assert.assertTrue((libraPageIndex.Btn_MyTopic.isDisplayed()));

        if (libraPageIndex.Btn_MyTopic.isDisplayed()) {
            libraPageIndex.Btn_MyTopic.click();
            testUtil.waitForTime(5000);

            //当登录窗口弹出时，对其进行登录操作,首先获取iFrame框架
            libraPageIframe.getLibraPagePopUpLoginIframeElement(firefoxDriver);

            if (libraPageIframe.Dlg_Frame_FormLogin != null) {

                //使driver进入Frame_FormLogin内联框架进行元素定位
                libraPageIframe.switchToIframe(firefoxDriver, libraPageIframe.Dlg_Frame_FormLogin);
                //当进入iFrame框架后，再次获取iFrame的页面元素
                libraPageIframe.getLibraPagePopUpLoginIframeElement(firefoxDriver);

                if (libraPageIframe.Ckb_SecurityCheckBox != null) {
                    testUtil.waitForTime(1000);
                    //查看安全控件是否被选中，若被选中则取消掉，便于密码输入
                    if (libraPageIframe.Ckb_SecurityCheckBox.isSelected()) {
                        libraPageIframe.Ckb_SecurityCheckBox.click();
                        testUtil.waitForTime(1000);
                    } else {
                        System.out.println("The SecurityCheckBox is not exist!");
                    }

                    if (libraPageIframe.Ipt_LoginName != null && libraPageIframe.Ipt_LoginPass != null && libraPageIframe.Btn_LoginSubmit != null) {
                        libraPageIframe.cleanAndLoginPopUpIframe(firefoxDriver, testUtil, libraPageIframe.Ipt_LoginName, libraPageIframe.Ipt_LoginPass, libraPageIframe.Btn_LoginSubmit);
                    } else {
                        System.out.println("The iFrame login name, pass, submit cannot located!");
                    }

                    //登录完成后使driver跳出Frame_FormLogin内联框架
                    libraPageIframe.switchOutIframe(firefoxDriver);

                    if (libraPageIndex.Btn_MyTopicContainer_Close != null) {
                        testUtil.waitForTime(2000);
                        libraPageIndex.Btn_MyTopicContainer_Close.click();
                    } else {
                        System.out.println("The MyTopic Contents is not pop-up!");
                    }

                } else {
                    //此分支为libraPageIframe.Ckb_SecurityCheckBox不存在时的操作
                    if (libraPageIframe.Ipt_LoginName != null && libraPageIframe.Ipt_LoginPass != null && libraPageIframe.Btn_LoginSubmit != null) {
                        libraPageIframe.cleanAndLoginPopUpIframe(firefoxDriver, testUtil, libraPageIframe.Ipt_LoginName, libraPageIframe.Ipt_LoginPass, libraPageIframe.Btn_LoginSubmit);
                    } else {
                        System.out.println("The iFrame login name, pass, submit cannot located!");
                    }

                    //登录完成后使driver跳出Frame_FormLogin内联框架
                    libraPageIframe.switchOutIframe(firefoxDriver);

                    if (libraPageIndex.Btn_MyTopicContainer_Close != null) {
                        testUtil.waitForTime(2000);
                        libraPageIndex.Btn_MyTopicContainer_Close.click();
                    } else {
                        System.out.println("The MyTopic Contents is not pop-up!");
                    }
                }

            } else {
                System.out.println("The user already login!");
                if (libraPageIndex.Btn_MyTopicContainer_Close != null) {
                    testUtil.waitForTime(2000);
                    libraPageIndex.Btn_MyTopicContainer_Close.click();
                }
            }
        } else {
            System.out.println("the button [我的话题] is not located");
        }

        //模拟用户在libra首页发表盖楼话题并测试话题外链校验
        if (libraPageIndex.Btn_UserAsk != null) {
            testUtil.waitForTime(3000);
            libraPageIndex.Btn_UserAsk.click();
        } else {
            System.out.println("The btn [我要提问] is not located");
        }

        //断言此时提问窗口弹出
        testUtil.waitForTime(1000);
        Assert.assertTrue(libraPageIndex.Dlg_PopupAskContainer.isDisplayed());
        if (libraPageIndex.Ipt_AskUrl != null && libraPageIndex.Ipt_AskTextArea != null && libraPageIndex.Btn_AskSubmit != null) {

            libraPageIndex.Ipt_AskUrl.sendKeys(ProjectParams.TargetSkuUrl_1);
            libraPageIndex.Ipt_AskTextArea.sendKeys(ProjectParams.TargetDialogAskInput_4);
            libraPageIndex.Btn_AskSubmit.click();

            //断言点击创建话题后的返回结果
            testUtil.waitForTime(1000);
            if (libraPageIndex.Dlg_ActReturns_CreateTopic != null) {
                Assert.assertEquals(ProjectParams.CreateTopicReturns_1, libraPageIndex.Dlg_ActReturns_CreateTopic.getText());
            }

            //清空URL栏并未下次输入做准备
            libraPageIndex.cleanMyTopicContainerAskTextArea(firefoxDriver, testUtil);

            //外链TargetDialogAskInput_5测试
            libraPageIndex.Ipt_AskTextArea.sendKeys(ProjectParams.TargetDialogAskInput_5);
            libraPageIndex.Btn_AskSubmit.click();

            //断言点击创建话题后的返回结果
            testUtil.waitForTime(1000);
            if (libraPageIndex.Dlg_ActReturns_CreateTopic != null) {
                Assert.assertEquals(ProjectParams.CreateTopicReturns_1, libraPageIndex.Dlg_ActReturns_CreateTopic.getText());
            }

            //清空URL栏并未下次输入做准备
            libraPageIndex.cleanMyTopicContainerAskTextArea(firefoxDriver, testUtil);

            //外链TargetDialogAskInput_6测试
            libraPageIndex.Ipt_AskTextArea.sendKeys(ProjectParams.TargetDialogAskInput_6);
            libraPageIndex.Btn_AskSubmit.click();

            //断言点击创建话题后的返回结果
            testUtil.waitForTime(1000);
            if (libraPageIndex.Dlg_ActReturns_CreateTopic != null) {
                Assert.assertEquals(ProjectParams.CreateTopicReturns_1, libraPageIndex.Dlg_ActReturns_CreateTopic.getText());
            }

            //清空URL栏并未下次输入做准备
            libraPageIndex.cleanMyTopicContainerAskTextArea(firefoxDriver, testUtil);

            //外链TargetDialogAskInput_7测试
            libraPageIndex.Ipt_AskTextArea.sendKeys(ProjectParams.TargetDialogAskInput_7);
            libraPageIndex.Btn_AskSubmit.click();

            //断言点击创建话题后的返回结果
            testUtil.waitForTime(1000);
            if (libraPageIndex.Dlg_ActReturns_CreateTopic != null) {
                Assert.assertEquals(ProjectParams.CreateTopicReturns_1, libraPageIndex.Dlg_ActReturns_CreateTopic.getText());
            }

            //清空URL栏并未下次输入做准备
            libraPageIndex.cleanMyTopicContainerAskTextArea(firefoxDriver, testUtil);

            libraPageIndex.Btn_AskClose.click();

            firefoxDriver.quit();

        }

    }



    @Test
    /**
     *-> 话题外链校验测试_IE_Test() is used for test the homepage go top function
     */
    public void 话题外链校验测试_IE_Test() throws IOException {
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
        logUtil.setLoggerProperties("TestCase_167543", ProjectParams.IETest_167545_LayOut, ProjectParams.IEDriverLocalPath);

        Libra_Page_PreIndex libraPagePreIndex = new Libra_Page_PreIndex();
        Libra_Page_Index libraPageIndex = new Libra_Page_Index();
        Libra_Page_iFrame libraPageIframe = new Libra_Page_iFrame();

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

        //模拟用户点击 “我的话题” 进行登录
        testUtil.waitForTime(3000);
        libraPageIndex.getLibraPageIndexElement(IEDriver);
        Assert.assertTrue((libraPageIndex.Btn_MyTopic.isDisplayed()));

        if (libraPageIndex.Btn_MyTopic.isDisplayed()) {
            libraPageIndex.Btn_MyTopic.click();
            testUtil.waitForTime(5000);

            //当登录窗口弹出时，对其进行登录操作,首先获取iFrame框架
            libraPageIframe.getLibraPagePopUpLoginIframeElement(IEDriver);

            if (libraPageIframe.Dlg_Frame_FormLogin != null) {

                //使driver进入Frame_FormLogin内联框架进行元素定位
                libraPageIframe.switchToIframe(IEDriver, libraPageIframe.Dlg_Frame_FormLogin);
                //当进入iFrame框架后，再次获取iFrame的页面元素
                libraPageIframe.getLibraPagePopUpLoginIframeElement(IEDriver);

                if (libraPageIframe.Ckb_SecurityCheckBox != null) {
                    testUtil.waitForTime(1000);
                    //查看安全控件是否被选中，若被选中则取消掉，便于密码输入
                    if (libraPageIframe.Ckb_SecurityCheckBox.isSelected()) {
                        libraPageIframe.Ckb_SecurityCheckBox.click();
                        testUtil.waitForTime(1000);
                    } else {
                        System.out.println("The SecurityCheckBox is not exist!");
                    }

                    if (libraPageIframe.Ipt_LoginName != null && libraPageIframe.Ipt_LoginPass != null && libraPageIframe.Btn_LoginSubmit != null) {
                        libraPageIframe.cleanAndLoginPopUpIframe(IEDriver, testUtil, libraPageIframe.Ipt_LoginName, libraPageIframe.Ipt_LoginPass, libraPageIframe.Btn_LoginSubmit);
                    } else {
                        System.out.println("The iFrame login name, pass, submit cannot located!");
                    }

                    //登录完成后使driver跳出Frame_FormLogin内联框架
                    libraPageIframe.switchOutIframe(IEDriver);

                    if (libraPageIndex.Btn_MyTopicContainer_Close != null) {
                        testUtil.waitForTime(2000);
                        libraPageIndex.Btn_MyTopicContainer_Close.click();
                    } else {
                        System.out.println("The MyTopic Contents is not pop-up!");
                    }

                } else {
                    //此分支为libraPageIframe.Ckb_SecurityCheckBox不存在时的操作
                    if (libraPageIframe.Ipt_LoginName != null && libraPageIframe.Ipt_LoginPass != null && libraPageIframe.Btn_LoginSubmit != null) {
                        libraPageIframe.cleanAndLoginPopUpIframe(IEDriver, testUtil, libraPageIframe.Ipt_LoginName, libraPageIframe.Ipt_LoginPass, libraPageIframe.Btn_LoginSubmit);
                    } else {
                        System.out.println("The iFrame login name, pass, submit cannot located!");
                    }

                    //登录完成后使driver跳出Frame_FormLogin内联框架
                    libraPageIframe.switchOutIframe(IEDriver);

                    if (libraPageIndex.Btn_MyTopicContainer_Close != null) {
                        testUtil.waitForTime(2000);
                        libraPageIndex.Btn_MyTopicContainer_Close.click();
                    } else {
                        System.out.println("The MyTopic Contents is not pop-up!");
                    }
                }

            } else {
                System.out.println("The user already login!");
                if (libraPageIndex.Btn_MyTopicContainer_Close != null) {
                    testUtil.waitForTime(2000);
                    libraPageIndex.Btn_MyTopicContainer_Close.click();
                }
            }
        } else {
            System.out.println("the button [我的话题] is not located");
        }

        //模拟用户在libra首页发表盖楼话题并测试话题外链校验
        if (libraPageIndex.Btn_UserAsk != null) {
            testUtil.waitForTime(3000);
            libraPageIndex.Btn_UserAsk.click();
        } else {
            System.out.println("The btn [我要提问] is not located");
        }

        //断言此时提问窗口弹出
        testUtil.waitForTime(1000);
        Assert.assertTrue(libraPageIndex.Dlg_PopupAskContainer.isDisplayed());
        if (libraPageIndex.Ipt_AskUrl != null && libraPageIndex.Ipt_AskTextArea != null && libraPageIndex.Btn_AskSubmit != null) {

            libraPageIndex.Ipt_AskUrl.sendKeys(ProjectParams.TargetSkuUrl_1);
            libraPageIndex.Ipt_AskTextArea.sendKeys(ProjectParams.TargetDialogAskInput_4);
            libraPageIndex.Btn_AskSubmit.click();

            //断言点击创建话题后的返回结果
            testUtil.waitForTime(1000);
            if (libraPageIndex.Dlg_ActReturns_CreateTopic != null) {
                Assert.assertEquals(ProjectParams.CreateTopicReturns_1, libraPageIndex.Dlg_ActReturns_CreateTopic.getText());
            }

            //清空URL栏并未下次输入做准备
            libraPageIndex.cleanMyTopicContainerAskTextArea(IEDriver, testUtil);

            //外链TargetDialogAskInput_5测试
            libraPageIndex.Ipt_AskTextArea.sendKeys(ProjectParams.TargetDialogAskInput_5);
            libraPageIndex.Btn_AskSubmit.click();

            //断言点击创建话题后的返回结果
            testUtil.waitForTime(1000);
            if (libraPageIndex.Dlg_ActReturns_CreateTopic != null) {
                Assert.assertEquals(ProjectParams.CreateTopicReturns_1, libraPageIndex.Dlg_ActReturns_CreateTopic.getText());
            }

            //清空URL栏并未下次输入做准备
            libraPageIndex.cleanMyTopicContainerAskTextArea(IEDriver, testUtil);

            //外链TargetDialogAskInput_6测试
            libraPageIndex.Ipt_AskTextArea.sendKeys(ProjectParams.TargetDialogAskInput_6);
            libraPageIndex.Btn_AskSubmit.click();

            //断言点击创建话题后的返回结果
            testUtil.waitForTime(1000);
            if (libraPageIndex.Dlg_ActReturns_CreateTopic != null) {
                Assert.assertEquals(ProjectParams.CreateTopicReturns_1, libraPageIndex.Dlg_ActReturns_CreateTopic.getText());
            }

            //清空URL栏并未下次输入做准备
            libraPageIndex.cleanMyTopicContainerAskTextArea(IEDriver, testUtil);

            //外链TargetDialogAskInput_7测试
            libraPageIndex.Ipt_AskTextArea.sendKeys(ProjectParams.TargetDialogAskInput_7);
            libraPageIndex.Btn_AskSubmit.click();

            //断言点击创建话题后的返回结果
            testUtil.waitForTime(1000);
            if (libraPageIndex.Dlg_ActReturns_CreateTopic != null) {
                Assert.assertEquals(ProjectParams.CreateTopicReturns_1, libraPageIndex.Dlg_ActReturns_CreateTopic.getText());
            }

            //清空URL栏并未下次输入做准备
            libraPageIndex.cleanMyTopicContainerAskTextArea(IEDriver, testUtil);

            libraPageIndex.Btn_AskClose.click();

            IEDriver.quit();

        }

    }










}





