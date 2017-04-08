package ru.stqa.pft.mantis.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.io.IOException;

public class SomeTest extends TestBase{

    private int issueId = 1;


    @BeforeMethod
    public void checkIssueState() throws IOException, ServiceException {
        if (isIssueOpen(issueId).equals(true)) {
            skipIfNotFixed(issueId);
        }
    }

    @Test
    public void testSome() {

    }
}
