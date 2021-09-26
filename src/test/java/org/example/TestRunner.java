package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/"},
glue = {"stepdefinitions"},
dryRun = false,
plugin = {"pretty", "html:reports"},
tags = {"@login", "@branch"})
public class TestRunner {
}

// anding of tags
// tags = {"tag1", "tag2"}
// execute scenarios which have both the tags


// oring of tags
// tags = {"tag1 or @tag2"}
// execute scenarios which have either tag1 or tag2