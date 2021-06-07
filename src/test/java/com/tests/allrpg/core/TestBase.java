package com.tests.allrpg.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.tests.allrpg.main.pages.MainPage;
import com.tests.allrpg.main.pages.functional.*;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.selenide.LogType.BROWSER;
import static java.util.logging.Level.WARNING;

public class TestBase {
    protected static MainPage mainPage;
    protected ProjectPage projectPage;
    protected ApplicationsPage applicationsPage;
    protected GroupPage groupPage;
    protected ExchangePage exchangePage;
    protected CalendarPage calendarPage;
    protected ReportsPage reportsPage;
    protected RulingPage rulingPage;
    protected PublicationsPage publicationsPage;
    protected NewsPage newsPage;

    protected static final SiteConnection siteConnection = SiteConnection.load();
    protected static final User user = new User(siteConnection.getUser(), siteConnection.getPassword());
    protected static final User master = new User(siteConnection.getMaster(), siteConnection.getPassword());

    protected static Cookie cookiePass;
    protected static Cookie cookieUserId;
    protected static Cookie cookiePHPSESSIONID;
    protected static Cookie cookieProjectId;
    protected static Cookie cookieApplicationType;
    protected final SiteVariables vars = SiteVariables.generate();

    @BeforeAll
    @Step
    static void setUp() {
        addListener(new Highlighter());
        closeWebDriver();
        Configuration.baseUrl          = siteConnection.getUrl();
        Configuration.browserSize      = "1920x1080";
        //Configuration.browser          = System.getProperty("browser");
        Configuration.timeout          = 20000;
        Configuration.headless         = true;
        Configuration.holdBrowserOpen  = false;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false).includeSelenideSteps(true).enableLogs(BROWSER, WARNING));

        mainPage = open("/", MainPage.class).authorize(user.getMail(), user.getPassword());

        cookiePass = getWebDriver().manage().getCookieNamed("pass");
        cookieUserId = getWebDriver().manage().getCookieNamed("user_id");
        cookiePHPSESSIONID = getWebDriver().manage().getCookieNamed("PHPSESSID");
        cookieProjectId = getWebDriver().manage().getCookieNamed("project_id");
        cookieApplicationType = getWebDriver().manage().getCookieNamed("application_type");
    }
}
