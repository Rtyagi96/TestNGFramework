package Framework.helper.listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class RetryListener implements IAnnotationTransformer {
    private Logger log = Logger.getLogger(String.valueOf(RetryListener.class));

    
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        IRetryAnalyzer retry = iTestAnnotation.getRetryAnalyzer();
        if(retry==null){
            iTestAnnotation.setRetryAnalyzer(Retry.class);
        }
    }
}
