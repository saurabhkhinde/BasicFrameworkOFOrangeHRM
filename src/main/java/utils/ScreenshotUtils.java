package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    private static final String SCREENSHOT_PATH = "target/screenshots/";

    public static String captureScreenshot(WebDriver driver, String testName) {

        try {
            File srcFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            String fileName = testName + "_" + timestamp + ".png";
            File destFile = new File(SCREENSHOT_PATH + fileName);

            FileUtils.copyFile(srcFile, destFile);

            return destFile.getAbsolutePath();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
