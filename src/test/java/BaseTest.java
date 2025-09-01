import com.microsoft.playwright.*;
import org.example.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collections;

public abstract class BaseTest {

    protected static final String URL = "https://meteo.imgw.pl";

    private Playwright playwright;
    private Browser browser;
    private BrowserContext browserContext;
    protected Page page;
    protected HomePage homePage;

    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080)
                .setPermissions(Collections.emptyList())
        );
        page = browserContext.newPage();
        page.navigate(URL);
        homePage = new HomePage(page);
    }

    @AfterEach
    public void tearDown() {
        playwright.close();
    }
}
