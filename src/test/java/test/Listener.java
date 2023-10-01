package test;

import base.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

public class Listener extends Base implements ITestListener {

    private final Logger logger = LoggerFactory.getLogger(Listener.class);
    @Override
    public void onTestFailure(ITestResult result){
        logger.info("Test Fail");
        testFail(result);
    }
}