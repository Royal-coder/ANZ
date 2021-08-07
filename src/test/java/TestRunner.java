import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:/Users/uic37006/IdeaProjects/ANZ/src/test/resources"},
        glue = {"src/test/java"},
        plugin = {"progress"},
        monochrome = true
)

public class TestRunner {
}
