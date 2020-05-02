package Framework.testScript;

import org.testng.annotations.Test;
import Framework.base.TestBase;
import Framework.helper.assertion.AssertionHelper;

public class Test1 extends TestBase {

    @Test
    public void testLogin(){
        AssertionHelper.IsTrue();
    }
    @Test
    public void testLogin1() {
        AssertionHelper.IsFalse();
    }
    @Test
    public void testLogin2() {
        AssertionHelper.IsTrue();
    }
    @Test
    public void testLogin3() {
        AssertionHelper.IsFalse();
    }
}
