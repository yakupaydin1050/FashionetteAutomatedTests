package de.fashionette.step_definitions;

import de.fashionette.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hook {

    @Before //it must be coming from cucumber.java
    public void setUp() {

        System.out.println("##### setup! start #####\n");
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            System.out.println("Test failed! Check your ScreenShot");
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs((OutputType.BYTES));
            scenario.attach(screenshot, "image/png", "screenshot");
        }else {
            System.out.println("Test is completed!");
        }
        System.out.println("##### THE END #####");
        Driver.closeDriver();
    }
}
