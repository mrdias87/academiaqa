package br.com.tcc.academia.runner;

import br.com.tcc.academia.utils.Driver;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        glue = "br.com.tcc.academia",
        features = "src/test/resources/features",
        tags = "@pesquisa"
)

public class FrameworkTest extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void initialize(){Driver.getDriverAndroid();}

    @AfterClass
    public static void closeDriver() {Driver.closeDriverAndroid();}
}
