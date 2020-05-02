package Framework.helper.listener;

import Framework.helper.logger.LoggerHelper;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import java.util.logging.Logger;

public class Retry implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 2;

    private Logger log = LoggerHelper.getLogger(Retry.class);

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount < maxRetryCount){
            log.info("retrying "+ iTestResult.getName() + " with status "
                    +getResultStatusName(iTestResult.getStatus())+ " for the "+ (retryCount+1)+ " times.");
            retryCount++;
            return true;
        }
        return false;
    }
    public String getResultStatusName(int status){
        String resultName = null;
        if(status==1){
            resultName = "SUCCESS";
            }
        if(status==2){
            resultName = "FAILURE";
        }
        if(status==3){
            resultName = "SKIP";
        }
        return resultName;
    }
}
