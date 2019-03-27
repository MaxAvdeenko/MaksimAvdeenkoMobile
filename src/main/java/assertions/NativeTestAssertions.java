package assertions;

import enums.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Contains locators and assertions for Native test
 */
public class NativeTestAssertions {
    private AppiumDriver driver;

    public NativeTestAssertions(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.example.android.contactmanager:id/addContactButton")
    private AndroidElement addContactButton;

    @AndroidFindBy(id = "android:id/title")
    private AndroidElement title;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/accountSpinner")
    private AndroidElement targetAccount;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactNameEditText")
    private AndroidElement contactName;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactPhoneEditText")
    private AndroidElement contactPhone;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactEmailEditText")
    private AndroidElement contactEmail;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactSaveButton")
    private AndroidElement saveButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[2]//android.widget.TableRow[6]//android.widget.TextView")
    private AndroidElement contactPhoneOption;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[2]//android.widget.TableRow[8]//android.widget.TextView")
    private AndroidElement contactEmailOption;

    public void checkAddContactButton() {
        assertTrue(addContactButton.isDisplayed());
        addContactButton.click();
    }

    public void checkTitle(Constants add) {
        assertTrue(title.isDisplayed());
        assertEquals(title.getText(), add.value);
    }

    public void checkAllElementsAreDisplayed() {
        assertTrue(targetAccount.isDisplayed());
        assertTrue(contactName.isDisplayed());
        assertTrue(contactPhone.isDisplayed());
        assertTrue(contactEmail.isDisplayed());
        assertTrue(contactPhoneOption.isDisplayed());
        assertTrue(contactEmailOption.isDisplayed());
        assertTrue(saveButton.isDisplayed());
    }
}
