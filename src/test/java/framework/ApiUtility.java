package framework;

import data.PostEndPointDetails;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.*;

import java.io.File;
import java.util.Map;

public class ApiUtility extends Base {

    public static Response doPostRequest(String baseUrl, String endPoint, Map<String, String> body) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        return request.body(body).post(endPoint);
    }

    public static Response doGetRequestWithParams(String baseUrl, String endpoint, Map<String, String> params) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        return request.params(params).get(endpoint);
    }

    public static Response doGetRequest(String baseUrl, String endPoint) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        return request.get(endPoint);
    }

    public static void verifyStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.statusCode());
    }

    public static void verifyMesage(Response response, String jsonPath, String expMsg) {
        Assert.assertEquals(JsonPath.from(response.body().asString()).get(jsonPath), expMsg);
    }

    public static boolean validateJsonSchema(Response response, String fileName) {

        boolean isPass = false;
        try {
            response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(PostEndPointDetails.getJsonSchemaPath() + fileName + ".json")));
            isPass = true;
        } catch (Exception e) {
            isPass = false;
        }
        return isPass;
    }


}