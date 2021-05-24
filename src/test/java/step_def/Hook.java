package step_def;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;



public class Hook {

    @Before
    public void setup(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println(scenario.getName());
        System.out.println("BEFORE");


          Driver.get().get(ConfigurationReader.get("url"));
            Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Driver.get().manage().window().maximize();

    }

    @After
    public void teardown(Scenario scenario){


            if(scenario.isFailed()){
                TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.get();
                byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
                scenario.embed(image, "image/png");
            }
            Driver.closeDriver();


        System.out.println("AFTER");
    }
}


