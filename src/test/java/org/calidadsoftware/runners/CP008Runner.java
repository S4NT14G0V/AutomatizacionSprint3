package org.calidadsoftware.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/CP008_ActividadFisica.feature",
        glue = "org.calidadsoftware.stepdefinitions.CP008StepDefinition",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CP008Runner {
}

