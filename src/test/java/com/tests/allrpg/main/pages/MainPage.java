package com.tests.allrpg.main.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.conditions.Visible;
import com.tests.allrpg.core.TestBase;
import com.tests.allrpg.main.pages.functional.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage extends TestBase {
    @Step
    public MainPage authorize(String login, String password) {
        $(".login_btn").click();
        $("#login_global").setValue(login);
        $("#pass_global").setValue(password);
        $("#btn_login").click();
        checkPushSendingOffer();
        $(".photoName_photo_wrapper").shouldBe(visible);
        return page(MainPage.class);
    }

    @Step
    public MainPage setCookies() {
        if ( $(".photoName").is(not(visible)) ) {
            getWebDriver().manage().addCookie(cookiePass);
            getWebDriver().manage().addCookie(cookieUserId);
            getWebDriver().manage().addCookie(cookiePHPSESSIONID);
            refresh();
            checkPushSendingOffer();
        }

        $(".photoName").should(exist);
        return page(MainPage.class);
    }

    @Step
    public MainPage checkPushSendingOffer() {
        $(".ui-dialog-title").should(exist);
        $(".ui-dialog-buttonset").click();
        return page(MainPage.class);
    }

    @Step
    public ApplicationsPage gotoApplicationsPage() {
        $(".mainpage_block > .application > a.command.small").click();
        return page(ApplicationsPage.class);
    }

    @Step
    public ProjectPage gotoProjectsPage() {
        $(".mainpage_block > .project > a.command.small").click();
        return page(ProjectPage.class);
    }

    @Step
    public GroupPage gotoGroupPage() {
        $(".mainpage_block > .community > a.command.small").click();
        $(".page_header").shouldHave(text("Группы"));
        return page(GroupPage.class);
    }

    @Step
    public ExchangePage gotoExchangePage() {
        $("#exchange > div.mainpage_block_header > a.command.small").click();
        $(".page_header").shouldHave(text("Шмотник"));
        return page(ExchangePage.class);
    }

    @Step
    public CalendarPage gotoCalendarPage() {
        $("#calendar > div.mainpage_block_header > a.command.small").click();
        $(".page_header").shouldHave(text("Календарь ролевых игр"));
        return page(CalendarPage.class);
    }

    @Step
    public ReportsPage gotoReportsPage() {
        $("#reports > div.mainpage_block_header > a.command.small").click();
        $(".form_header > a").shouldHave(text("Отчеты"));
        return page(ReportsPage.class);
    }

    @Step
    public RulingPage gotoRulingPage() {
        $("#ruling > div.mainpage_block_header > a.command.small").click();
        $(".page_header").shouldHave(text("Рулёжка"));
        return page(RulingPage.class);
    }

    @Step
    public PublicationsPage gotoPublicationsPage() {
        $("#publications > div.mainpage_block_header > a.command.small").click();
        $(".page_header").shouldHave(text("Статьи"));
        return page(PublicationsPage.class);
    }

    @Step
    public NewsPage gotoNewsPage() {
        $("#news > div.mainpage_block_header > a.command.small").click();
        $(".form_header > a").shouldHave(text("Новости и события"));
        return page(NewsPage.class);
    }
}
