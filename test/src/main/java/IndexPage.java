import org.openqa.selenium.WebDriver;

public class IndexPage extends BasePage{

    SearchBox searchBox;

    public IndexPage(WebDriver driver){
        super(driver);
        searchBox = new SearchBox(driver);
        driver.get(baseUrl);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }


}
