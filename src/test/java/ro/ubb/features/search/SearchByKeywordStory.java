package ro.ubb.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import ro.ubb.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Issue("#WIKI-1")
    @Test
    public void searching_by_keyword_apple_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("apple");
        anna.should_see_definition("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.");

    }

    @Test
    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("pear");
        anna.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.");
    }

    @Pending @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }

    @Test
    public void searching_by_keyword_pomelo_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("pomelo");
        anna.should_see_definition("The large fruit of the Citrus maxima (syn. C. grandis), native to South Asia and Southeast Asia, with a thick green or yellow rind, a thick white pith, and semi-sweet translucent pale flesh.");
    }

    @Test
    public void searching_by_keyword_kiwi_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("kiwi");
        anna.should_see_definition("A flightless bird of the genus Apteryx native to New Zealand.");
    }
} 
