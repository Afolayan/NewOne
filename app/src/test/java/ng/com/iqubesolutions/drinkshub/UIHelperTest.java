package ng.com.iqubesolutions.drinkshub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ng.com.iqubesolutions.drinkshub.helper.UIHelper;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UIHelperTest {
    UIHelper uiHelper;

    @Before
    public void init(){
         uiHelper = new UIHelper();
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testIsEmail(){
        assertTrue("String is email", UIHelper.isEmail("afolayanseyi@gmail.com"));
    }
}