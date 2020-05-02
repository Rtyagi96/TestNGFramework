package Framework.helper.assertion;

import Framework.helper.logger.LoggerHelper;
import org.testng.Assert;
import java.util.logging.Logger;

public class AssertionHelper {
    private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);

    public static void verifyText(String actual, String expected){
        log.info("Verifying" +actual+ "and"+ expected + "text");
        Assert.assertEquals(actual,expected);
    }
    public static void IsTrue(){
        log.info("Checking if given condition is True");
        Assert.assertTrue(true);
    }
    public static void IsTrue(String message){
        log.info("Checking if given condition is Passed "+ message);
        Assert.assertTrue(true, message);
    }
    public static void IsFalse(){
        log.info("Checking if given condition is Failed");
        Assert.assertFalse(false);
    }
    public static void IsFalse(String message){
        log.info("Checking if given condition is Failed"+ message);
        Assert.assertFalse(false, message);
    }
    public static void IsValid(boolean status){
        Assert.assertTrue(status);
    }
    public static void IsNotValid(boolean status) {
        Assert.assertFalse(status);
    }
    public static void IsNullObject(String s1){
        log.info("Checking whether the given object is null");
        Assert.assertNull(s1);
    }
    public static void IsNotNullObject(String s1){
        log.info("Checking whether the given object is not null");
        Assert.assertNotNull(s1);
    }
}
