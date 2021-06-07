package com.tests.allrpg.main.pages.functional;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class PublicationsPage {

    @Step
    public PublicationsPage checkExistingPublications() {
        $$(".publication").shouldHave(CollectionCondition.sizeGreaterThan(0));
        return page(PublicationsPage.class);
    }
}
