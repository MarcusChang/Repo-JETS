package Utils;


import com.jd.libra.BPT_Auto.TestParams.ProjectParams;

/**
 * Created by changxuliang on 2015/7/16.
 */
public class DriverUtilFunctions {
    public DriverUtilFunctions(String driver){

        if (driver != null && driver.equals("Chrome")){
            // 设置 chrome 的路径
            System.setProperty("webdriver.chrome.driver", ProjectParams.ChromeDriverLocalPath);
        }
        else if (driver != null && driver.equals("Firefox")){
            // 设置 Firefox 的路径
            System.setProperty("webdriver.firefox.bin", ProjectParams.FireFoxDriverLocalPath);
        }
        else if (driver != null && driver.equals("IE")){
            // 设置 IE 的路径
            System.setProperty("webdriver.ie.driver", ProjectParams.IEDriverLocalPath);
        }

    }
}
