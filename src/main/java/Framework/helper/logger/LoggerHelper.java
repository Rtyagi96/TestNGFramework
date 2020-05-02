package Framework.helper.logger;
import Framework.helper.resource.ResourceHelper;
import org.apache.log4j.PropertyConfigurator;
import java.util.logging.Logger;

public class LoggerHelper {
    private static boolean root = false;

    public static Logger getLogger(Class cls){
        if(root){
            return Logger.getLogger(String.valueOf(cls));
        }
        PropertyConfigurator.configure(ResourceHelper.getResourcePath("//src//main//resources//configFile//log4j.properties"));
        root = true;
        return Logger.getLogger(String.valueOf(cls));
    }
//    public static void main(String[] args){
//        Logger log = LoggerHelper.getLogger(LoggerHelper.class);
//        log.info("Logging into the file");
//    }
}
