package TestRun;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;




    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"src/FeatureFile/Registration.feature","src/FeatureFile/Login.feature"},

            glue = {"StepDefinitions"},



            publish = true
            //dryRun = true,
            //monochrome = true

    )


    public class TestRunner{


    }


