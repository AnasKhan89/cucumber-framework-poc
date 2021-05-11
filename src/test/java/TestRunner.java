import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
//                "src/test/resources/feature/SKUUtilityExporterAPI.feature",
                "src/test/resources/feature/WCM_ExporterAPI.feature",
        },
//        tags = {"@regression"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        glue = {"classpath:com.niusm.cucumber.stepdef"}

)
public class TestRunner {
}
