package Tests;

import framework.ApiUtility;
import framework.TeamsApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.Teams;
import testnglistener.Listener;
import java.util.HashMap;
import java.util.Map;

// These tests are showing individual tests which can data validate in the endpoint.
// For demo purpose, I have not used setup method to call once and validate the response in individual tests.
@Listeners(Listener.class)
public class TeamsEndPointTestSuite extends TeamsApi {

    private final String teams_endPoint = "/api/v1/sampleapi/Teams";
    Response response;

    @BeforeClass
    public void setUpTest() {
        response = ApiUtility.doGetRequest(baseUrl, teams_endPoint);
    }

    @Test(priority = 0)
    public void VerifyTeamsEndPointArraySize() {
        Teams[] teams = response.as(Teams[].class);
        Assert.assertTrue(teams.length > 0, "Teams array size is 0");
    }

    // This test is to show status code validations
    @Test(priority = 1)
    public void VerifyTeamsEndPoint_200_StatusCode() {
        Assert.assertEquals(response.statusCode(), 200);
    }


    // This test is to show schema validations
    @Test(priority = 3)
    public void VerifyTeamEndPoint_Schema() {
        String jsonFileName = "TeamsJsonSchema";
        boolean isPass = ApiUtility.validateJsonSchema(response, jsonFileName);
        Assert.assertTrue(isPass, jsonFileName + " is not invalid");
    }

    // This test is to show status code validations

    @Test(priority = 4)
    public void VerifyTeamsObjectProperties() {

        Teams[] all_teams = response.as(Teams[].class);
        for (Teams team : all_teams) {
            Assert.assertTrue(!team.getTeamname().isEmpty());
            Assert.assertTrue(!team.getTeamname().isEmpty());
            Assert.assertTrue(!team.getTeamname().isEmpty());
            Assert.assertTrue(!team.getId().isEmpty());
        }
    }

    // This test is showing fetching selected team object
    // based on querying teams list using inline variables
    @Test(priority = 5)
    public void VerifyTeamsDataBasedOnInlineVariables() {

        Map<String, String> params = new HashMap<String, String>();
        params.put("teamname", "teamname 1");
        Teams[] s = ApiUtility.doGetRequestWithParams(baseUrl, teams_endPoint, params).as(Teams[].class);
        Assert.assertEquals(s[0].getId(), "1");
        Assert.assertEquals(s[0].getTeamname(), "teamname 1");
        Assert.assertEquals(s[0].getTeamsize(), "teamsize 1");
        Assert.assertEquals(s[0].getTeamcapability(), "teamcapability 1");
    }

}
