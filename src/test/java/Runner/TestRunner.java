package Runner;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static utils.WebDriverService.driver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

@CucumberOptions(features = "src/test/resources/features", tags = {"@ui", "@api"}, glue = {"step_definitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "junit:target/cucumber-results.xml",
        })

public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null)
            try {
                driver.quit();
                driver = null;
            } catch (Exception e) {
                System.out.println(" -- Failed the close browser :: " + e.getMessage());
            }
    }

    @AfterSuite
    public void reporting() {
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/cucumber.json");
        String projectName = "Test_Report";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
