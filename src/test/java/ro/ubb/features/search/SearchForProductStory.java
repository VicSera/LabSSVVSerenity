package ro.ubb.features.search;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import ro.ubb.steps.serenity.EndUserSteps;

import java.util.Arrays;
import java.util.Collection;

@RunWith(ThucydidesParameterizedRunner.class)
public class SearchForProductStory {

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Calculator stiintific Joinus dublu display, AKU 240 functii, 10+2 digits multifunctional ideal aplicatii Liceu Universitate Inginerie Contabilitate Chimie FizicaTrigonometrie + Carcasa protectie AK6375"},
                {"qweqwdasdqsdsdqsdqasd"}
        });
    }

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    private final String productName;

    public SearchForProductStory(String productName) {
        this.productName = productName;
    }

    @Test
    public void testSearchForProductByName() {
        anna.opensThePage();
        anna.searches(productName);
        anna.shouldSeeProduct(productName);
    }
} 
