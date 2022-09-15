package Tests;

import framework.ApiUtility;
import framework.TeamsApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojo.Capabilities;
import pojo.Teams;
import testnglistener.Listener;

import java.util.HashMap;
import java.util.Map;

@Listeners(Listener.class)
public class ApiChaining_MultipleRequest_In_a_Test extends TeamsApi {

    private static String teams_endPoint = "/api/v1/sampleapi/Teams";
    private static String capabilitiesEndPoint = "/api/v1/sampleapi/capabilities";
    Response response;



    @Test(priority = 0)
    public void verifyTeamsDataForEachCapabilities() {

        // This test is showing, sending requests for more than one endpoints
        // and passing the data to next endpoint dynamically
        // Example - In this test, first request is to get the list of capabilities from capabilities end point
        // and for each its capabilities, request teams endpoint to verify response content.

        // Capabilities endpoint request
        response = ApiUtility.doGetRequest(baseUrl, capabilitiesEndPoint);
        Assert.assertEquals(response.statusCode(), 200);
        Capabilities[] capabilities = response.as(Capabilities[].class);
        for (Capabilities capability : capabilities) {
            System.out.println("Capability is :" + capability.getCapabilityname());

            // Teams endpoint request
            Map<String, String> params = new HashMap<String, String>();
            params.put("teamcapability", capability.getCapabilityname());
            Response teamsResponse = ApiUtility.doGetRequestWithParams(baseUrl, teams_endPoint, params);
            Teams[] teams = teamsResponse.as(Teams[].class);

            if (teams.length > 0) {
                for (Teams team : teams) {
                    Assert.assertTrue(!team.getTeamname().isEmpty()); // This is to verify teams attributes are not returning empty
                    Assert.assertTrue(!team.getTeamcapability().isEmpty()); // This is to verify teams attributes are not returning empty
                    Assert.assertTrue(!team.getTeamsize().isEmpty()); // This is to verify teams attributes are not returning empty
                }
            } else {
                new SoftAssert().fail("There are no teams with the capability " + capability.getCapabilityname());
            }

        }
    }
}
