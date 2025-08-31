import com.microsoft.playwright.*;
import org.example.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collections;

public abstract class BaseTest {

    private final String url = "https://meteo.imgw.pl";
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
                .setPermissions(Collections.emptyList())
        );
        page = browserContext.newPage();
        page.navigate(url);
        homePage = new HomePage(page);
    }

    @AfterEach
    public void tearDown() {
        playwright.close();
    }
}
