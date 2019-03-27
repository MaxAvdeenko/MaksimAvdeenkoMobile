package scenarios.nativeTests;

import assertions.NativeTestAssertions;
import enums.PropertyFiles;
import hooks.Hooks;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static enums.Constants.ADD_CONTACT;

@Test(groups = {"native"})
public class NativeTest extends Hooks {

    private NativeTestAssertions nativeTestAssertions;

    @BeforeMethod
    public void preparePageObjects() throws Exception {
        nativeTestAssertions = new NativeTestAssertions(driver());
    }

    //Choose native.properties
    protected NativeTest() {
        super(PropertyFiles.NATIVE);
    }

    @Test(description = "Click on Add Contact and check that all fields are presented")
    public void contactManagerTest() {
        //Check that Add Contact button is displayed and click on it
        nativeTestAssertions.checkAddContactButton();

        //Check title in opened page of application
        nativeTestAssertions.checkTitle(ADD_CONTACT);

        //Check that all fields and buttons are displayed
        nativeTestAssertions.checkAllElementsAreDisplayed();
    }
}

