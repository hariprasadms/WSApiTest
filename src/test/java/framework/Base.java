package framework;

import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Base {
    // This is the base class which can contain base configuration for entire automaton suite.
    // To keep tests simple, This class is not used in present test.
    
    public final static String baseUrl = "https://62b86e41f4cb8d63df5db530.mockapi.io";
    Response response;

    @BeforeClass
    public void setUpTest() {
        response = ApiUtility.doGetRequest(baseUrl, "");

    }

    @AfterTest
    public void tearDown() {

        // Add here, data or reports flush methods
        // which can help to clean the previous tests run configurations.

    }
}
