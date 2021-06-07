package com.tests.allrpg.main.pages.functional;

import com.codeborne.selenide.CollectionCondition;
import com.tests.allrpg.core.TestBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ProjectPage extends TestBase {
    @Step
    public ProjectPage checkExistingMyProjects() {
        $$(".navitems_plates").shouldHave(CollectionCondition.sizeGreaterThan(0));
        return page(ProjectPage.class);
    }

    @Step
    public ProjectPage checkExistingPastProjects() {
        $$(".overflown_content >.navitems_plates").shouldHave(CollectionCondition.sizeGreaterThan(0));
        return page(ProjectPage.class);
    }
}
