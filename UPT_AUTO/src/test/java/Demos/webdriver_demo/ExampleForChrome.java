package Demos.webdriver_demo;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.*;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.thoughtworks.selenium.SeleneseTestBase;


/**
 * Created by changxuliang on 2015/3/2.
 */


public class ExampleForChrome {

    @Test
    public void Chrome_Test() throws IOException {

        //当前目录的上级目录路径
        String parentPath = System.getProperty("user.dir");

        Logger logger = Logger.getLogger(ExampleForChrome.class);
        //BasicConfigurator.configure();

        Properties prop = new Properties();

        prop.setProperty("log4j.rootLogger", "INFO, ChromeDemoOutputFile");
        prop.setProperty("log4j.appender.ChromeDemoOutputFile", "org.apache.log4j.FileAppender");
        prop.setProperty("log4j.appender.ChromeDemoOutputFile.File", parentPath + "\\WebDriverLogs\\ChromeDemoLayOut.html");
        prop.setProperty("log4j.appender.ChromeDemoOutputFile.layout", "org.apache.log4j.PatternLayout");
        prop.setProperty("log4j.appender.ChromeDemoOutputFile.layout.ConversionPattern", "%d{HH:mm:ss,SSS} [%t] %-5p %C{1} : %m%n");


        /**below is the log property for console output
        *prop.setProperty("log4j.rootLogger", "ALL, CONSOLE");
        *prop.setProperty("log4j.appender.CONSOLE", "org.apache.log4j.ConsoleAppender");
        *prop.setProperty("log4j.appender.CONSOLE.layout", "org.apache.log4j.PatternLayout");
        *prop.setProperty("log4j.appender.CONSOLE.layout.ConversionPattern", "%d{HH:mm:ss,SSS} [%t] %-5p %C{1} : %m%n");
        */


        PropertyConfigurator.configure(prop);

        //logger.setLevel(Level.ALL);
        SimpleLayout ChromeDemolayout = new SimpleLayout();
        //HTMLLayout htmlLayout = new HTMLLayout();
        FileAppender Chromedemo_appender = null;
        //create the selenium verify | assert methods object
        SeleneseTestBase seleneseTestBase=new SeleneseTestBase();


        try {
            System.out.println(parentPath);
            System.out.println();
            Chromedemo_appender = new FileAppender(ChromeDemolayout, parentPath + "\\WebDriverLogs\\ChromeDemoLayOut.html", false);
        } catch (Exception e) {
            logger.fatal("the FileAppender cannot be initialized, please check the output path!");
        }


        logger.addAppender(Chromedemo_appender);
        logger.info("-----> Begin to set the driver properties : chrome driver path = C:\\Users\\admin\\Desktop\\chromedriver_win32\\chromedriver.exe <-----");
        // 设置 chrome 的路径
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
        // 创建一个 Chrome 的浏览器实例
        WebDriver driver = new ChromeDriver();
        // 让浏览器访问 Baidu
        driver.get("http://www.baidu.com");
        // 用下面代码也可以实现
        // driver.navigate().to("http://www.baidu.com");

        try {
            Thread.sleep(5000);
            String browserTitle = driver.getTitle();

            if (!(browserTitle.equals("百度一下，你就知道"))){
                logger.error("The home page is not located! Please check the network connection.");
            }else{
                // 获取 网页的 title
                System.out.println("Home Page title is: " + driver.getTitle());
                logger.info("The home page is located successfully. The Home Page title is: " + driver.getTitle());
            }

        }catch(Exception e){
            logger.error("The home page title cannot be obtained, please check the home page tab string.");
        }


        try {
            // 通过 id 找到 input 的 DOM
            WebElement element = driver.findElement(By.id("kw"));

            if (element == null) {
                logger.error("The search bar on the home page is not located, its id cannot be found.");

            } else {
                // 输入关键字
                element.sendKeys("JD");
                Thread.sleep(5000);
                // 提交 input 所在的 form
                //element.submit();
                // 通过判断 title 内容等待搜索页面加载完毕，Timeout 设置10秒
                (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return d.getTitle().toLowerCase().endsWith("京东_百度搜索");
                    }
                });

                //seleneseTestBase is used for verify the test result, its verify* methods can skip the junit assert exception return and execute the case continually.
                //seleneseTestBase.verifyEquals("京东_百度搜索", driver.getTitle());

                //Assert methods extends the Junit package used for test result assertion.
                //Assert.assertEquals("The searched result is not match the expected result!", "京东_百度搜索", driver.getTitle());

                // 显示搜索结果页面的 title
                System.out.println("The searched page title is: " + driver.getTitle());
            }

        }catch(Exception e){
            logger.error("The search bar cannot be located, please check the search bar's id.");
        }


        // 关闭浏览器
        driver.quit();

    }
}

