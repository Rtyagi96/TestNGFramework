package Framework.helper.browserConfig.config;

import Framework.Browser;
import Framework.helper.browserConfig.BrowserType;
import Framework.helper.resource.ResourceHelper;
import java.io.*;
import java.util.Properties;

public class PropertyReader implements ConfigReader {

    private static FileInputStream file;
    public static Properties OR;
    public PropertyReader() {
        String filepath = ResourceHelper.getResourcePath("//src//main//resources//configFile//config.properties");
        try {
            file = new FileInputStream(new File(filepath));
            OR = new Properties();
            OR.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public int getImplicitWait() {
        return Integer.parseInt(OR.getProperty("implicitWait"));
    }

    @Override
    public int getExplicitWait() {
        return Integer.parseInt(OR.getProperty("explicitWait"));
    }

    @Override
    public int getPageLoadTime() {
        return Integer.parseInt(OR.getProperty("pageLoadTime"));
    }

    @Override
    public BrowserType getBrowserType() {
        return BrowserType.valueOf(OR.getProperty("browserType"));
    }
}
