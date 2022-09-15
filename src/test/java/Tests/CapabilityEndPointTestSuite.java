package Tests;

import framework.ApiUtility;
import framework.GeneralUtility;
import framework.TeamsApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testnglistener.Listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Listeners(Listener.class)
public class CapabilityEndPointTestSuite extends TeamsApi {

    private static String endPoint = "/api/v1/sampleapi/capabilities";
    Response response;


    // This test to show the post requests and its validations
    @Test(priority = 0)
    public void verifyCreateCapabilities() {

        String capName = "test capability " + GeneralUtility.generateString();
        Map<String, String> body = new HashMap<>();
        body.put("capabilityname", capName);
        response = ApiUtility.doPostRequest(baseUrl, endPoint, body);
        ApiUtility.verifyStatusCode(response, 201);
        String cap = JsonPath.from(response.asString()).get("capabilityname");
        Assert.assertEquals(cap, capName);
    }

    // This test to show the array size of the capabilities endpoint

    @Test(priority = 1)
    public void verifyCapabilitiesEndPointArraySize() {
        response = ApiUtility.doGetRequest(baseUrl, endPoint);
        ApiUtility.verifyStatusCode(response, 200);
        List cap = JsonPath.from(response.asString()).get();
        Assert.assertTrue(cap.size() > 0);
    }


}
