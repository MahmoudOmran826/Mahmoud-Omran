package SearchUIFunctionality;

import base.BaseTests;
import base.TestData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTests {

    @Test
    public void testSuccessfulSearch(){
        homePage.enterTextAndSearch(TestData.validSearch);
        assertTrue(homePage.result(true)
                        .contains("Fast.com"),
                "Alert text is incorrect");
    }
    @Test
    public void testUnSuccessfulSearch(){
        homePage.enterTextAndSearch(TestData.InValidSearch);
        assertTrue(homePage.result(false)
                        .contains("لم ينجح بحثك عن "),
                "Alert text is incorrect");
    }
}
