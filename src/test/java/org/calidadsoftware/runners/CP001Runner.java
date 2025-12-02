package org.calidadsoftware.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/CP001_ActualizarUsuario.feature",
        glue = "org.calidadsoftware.stepdefinitions.CP001StepDefinition",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CP001Runner {
}
