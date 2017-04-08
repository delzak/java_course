package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;

import java.io.IOException;
import java.util.Set;

public class TestBase {

    public Boolean isIssueOpen(int issueId) throws IOException {
        Set<Issue> issue = getIssue(issueId);
        Issue someIssue = issue.iterator().next();
        if (!someIssue.getStateName().equals("Resolved")) {
            return true;
        } else {
            return false;
        }
    }


    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    private Set<Issue> getIssue(int issueId) throws IOException {
        String json = getExecutor()
                .execute(Request.Get(String.format("http://demo.bugify.com/api/issues/%s.json", issueId)))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
    }

    private Executor getExecutor() {
        return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==", "");
    }
}
