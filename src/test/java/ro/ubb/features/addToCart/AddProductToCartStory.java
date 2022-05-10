package ro.ubb.features.addToCart;

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
public class AddProductToCartStory {
    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Laptop Apple MacBook Air 13-inch, True Tone, procesor Apple M1 , 8 nuclee CPU si 7 nuclee GPU, 8GB, 256GB, Space Grey, ROM KB"},
                {"Crema tartinabila M&M Choco Spread, 200g"}
        });
    }

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    private final String productName;

    public AddProductToCartStory(String productName) {
        this.productName = productName;
    }

    @Test
    public void testCanAddProductToCart() {
        anna.opensThePage();
        anna.searches(productName);
        anna.selects(productName);
        anna.shouldSeeAddToCartButton();
    }
}
