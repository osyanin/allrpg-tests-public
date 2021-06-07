package com.tests.allrpg.main.tests;

import com.tests.allrpg.core.TestBase;
import com.tests.allrpg.main.pages.MainPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTest extends TestBase{

    @Test
    void loginAndCheckExistingApplications() {
        applicationsPage = open("/", MainPage.class).setCookies()
                .gotoApplicationsPage()
                .checkExistingAplications();
    }

    @Test
    void loginAndCheckExistingProjects() {
        projectPage = open("/", MainPage.class).setCookies()
                .gotoProjectsPage()
                .checkExistingMyProjects()
                .checkExistingPastProjects();
    }

    @Test
    void loginAndCheckExistingGroups() {
        groupPage = open("/", MainPage.class).setCookies()
                .gotoGroupPage()
                .checkExistingGroups();
    }

    @Test
    void loginAndCheckExistingExchangePublications() {
        exchangePage = open("/", MainPage.class).setCookies()
                .gotoExchangePage()
                .checkExistingPublications();
    }

    @Test
    void loginAndCheckExistingCalendarEvents() {
        calendarPage = open("/", MainPage.class).setCookies()
                .gotoCalendarPage()
                .checkExistingEvents();
    }

    @Test
    void loginAndCheckExistingReports() {
        reportsPage = open("/", MainPage.class).setCookies()
                .gotoReportsPage()
                .checkExistingReports();
    }

    @Test
    void loginAndCheckExistingRulings() {
        rulingPage = open("/", MainPage.class).setCookies()
                .gotoRulingPage();
    }

    @Test
    void loginAndCheckExistingPublications() {
        publicationsPage = open("/", MainPage.class).setCookies()
                .gotoPublicationsPage()
                .checkExistingPublications();
    }

    @Test
    void loginAndCheckExistingNews() {
        newsPage = open("/", MainPage.class).setCookies()
                .gotoNewsPage()
                .checkExistingNews();
    }
}
