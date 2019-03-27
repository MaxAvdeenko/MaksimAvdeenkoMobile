package scenarios.webTests;

import assertions.WebTestAssertions;
import enums.PropertyFiles;
import hooks.Hooks;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static enums.Constants.*;


@Test(groups = {"web"})
public class WebTest extends Hooks {

    private WebTestAssertions webTestAssertions;

    @BeforeMethod
    public void preparePageObjects() throws Exception {
        webTestAssertions = new WebTestAssertions(driver());
    }

    //Choose web.properties
    protected WebTest() {
        super(PropertyFiles.WEB);
    }

    @Test(description = "Open site iana.org and check some elements")
    public void webTest() throws Exception {
        //Open site iana.org
        webTestAssertions.openSite(SITE_URL);

        //Check title of site
        webTestAssertions.checkTitle(SITE_TITLE);

        //Check that introduction text is displayed
        webTestAssertions.checkIntroText(INTRO);
    }
}

