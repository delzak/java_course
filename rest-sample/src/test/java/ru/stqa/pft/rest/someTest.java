package ru.stqa.pft.rest;

import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class someTest extends TestBase{
    private int issueId = 1;


    @BeforeMethod
    public void checkIssueState() throws IOException {
        if (isIssueOpen(issueId).equals(true)) {
            skipIfNotFixed(issueId);
        }

    }

    @Test
    public void doSomeTest() {

    }

}
