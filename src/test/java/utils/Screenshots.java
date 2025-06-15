package utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.google.common.io.Files;

    public class Screenshots extends Base {
        static final String dateFormat="yyyy.MM.dd.HH.mm.ss";
        static final String screenShotFolder="/screenshots";
        static final String userDirectory="user.dir";


        public static void captureFullScreenshot(String filename) {
            String timestamp = new SimpleDateFormat(dateFormat).format(new Date());
            String name = filename + timestamp + ".png";
            TakesScreenshot ts = (TakesScreenshot) webDriver;
            File file = ts.getScreenshotAs(OutputType.FILE);
            File screenshotsDir = new File(System.getProperty(userDirectory) + screenShotFolder);
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdirs();
            }
            File target = new File(screenshotsDir, name);
            try {
                Files.copy(file, target);
            } catch (IOException e) {
                LoggerHandler.error(e.getMessage());
            }
        }
}
