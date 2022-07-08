package commons;

import atu.testrecorder.ATUTestRecorder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonTest {
    private ATUTestRecorder recorder;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
    private Date date = new Date();
    private String screenShotPath ="./src/test/resources/screenshots/";
    private String videoPath = "./src/test/resources/videos/";

    //    Setting browser and run testcase with .xml file
    @Parameters("browser")
    @BeforeClass
    public void baseSetup(String browserName) {
        Browser.browserSetup(browserName);
    }

//    @BeforeClass
//    public void baseSetup() {
//        Browser.browserSetup("chrome");
//    }

    @AfterMethod
    public void captureScreen(ITestResult testResult) throws IOException {
        if (!testResult.isSuccess()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Browser.getDriver();
            File filePath = new File(screenShotPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenShotPath + testResult.getName() + "_" + dateFormat.format(date) + ".png");
            FileUtils.copyFile(srcFile, destFile);
        }
    }

//    ATUTestRecorder library
    public void startRecordVideo(String videoName) throws Exception {
        File filePath = new File(videoPath);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        recorder = new ATUTestRecorder(String.valueOf(filePath), videoName + "_" + dateFormat.format(date), false);
        recorder.start();
    }

//    ATUTestRecorder library
    public void stopRecordVideo() throws Exception {
        recorder.stop();
    }

    @AfterClass
    public void tearDown() {
        Browser.getDriver().quit();
    }
}
