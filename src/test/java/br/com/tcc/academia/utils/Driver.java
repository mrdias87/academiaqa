package br.com.tcc.academia.utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private static WebDriverWait wait;

    public static AndroidDriver<MobileElement> appiumDriverAndroid = null;

    public static AndroidDriver<MobileElement> createDriverAndroid(){
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            cap.setCapability(MobileCapabilityType.APP, "c:/petz.apk");
            appiumDriverAndroid = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            wait = new WebDriverWait(appiumDriverAndroid, 10);
        }catch (MalformedURLException e){
            System.out.println( e.getMessage() );

        }
        return appiumDriverAndroid;
    }

    public static AndroidDriver<MobileElement> getDriverAndroid()  {
        if (appiumDriverAndroid == null){
            return createDriverAndroid();
        }
        return appiumDriverAndroid;
    }

    public static void closeDriverAndroid(){
        if (null != appiumDriverAndroid)
            appiumDriverAndroid.quit();
    }
}
