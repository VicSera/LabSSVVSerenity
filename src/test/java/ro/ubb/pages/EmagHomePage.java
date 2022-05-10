package ro.ubb.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.emag.ro/")
public class EmagHomePage extends PageObject {

    @FindBy(id = "searchboxTrigger")
    private WebElementFacade searchBox;

    public void executeSearch(String searchString) {
        searchBox.click();
        searchBox.typeAndEnter(searchString);
    }
}
