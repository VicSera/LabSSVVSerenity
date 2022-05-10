package ro.ubb.steps.serenity;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import ro.ubb.pages.EmagHomePage;

import static org.hamcrest.MatcherAssert.assertThat;

public class EndUserSteps {

    EmagHomePage emagHomePage;

    @Step
    public void opensThePage() {
        emagHomePage.open();
    }

    @Step
    public void searches(String searchString) {
        emagHomePage.executeSearch(searchString);
    }

    @Step
    public void shouldSeeProduct(String productName) {
        WebElementFacade div = emagHomePage.find(By.xpath(String.format(".//div[@data-name=\"%s\"]", productName)));

        assertThat(String.format("End user should see product %s", productName), div.isVisible());
    }

    @Step
    public void selects(String productName) {
        WebElementFacade div = emagHomePage.find(By.xpath(String.format(".//div[@data-name=\"%s\"]", productName)));

        div.click();
    }

    @Step
    public void shouldSeeAddToCartButton() {
        try {
            emagHomePage.waitForTextToAppear("Adauga in Cos", 5000L);
        } catch (Exception exception) {
            Assert.fail("Add to cart button did not appear");
        }
    }
}
