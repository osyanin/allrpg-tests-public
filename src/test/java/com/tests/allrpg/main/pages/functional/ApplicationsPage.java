package com.tests.allrpg.main.pages.functional;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class ApplicationsPage {
    public ApplicationsPage checkExistingAplications() {
        $$("div.maincontent_data.autocreated.kind_myapplication > table > tbody > tr").shouldHave(CollectionCondition.sizeGreaterThan(0));
        return page(ApplicationsPage.class);
    }
}