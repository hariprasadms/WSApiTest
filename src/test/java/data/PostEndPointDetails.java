package data;

// This class acts as a global test data configuration.

// This class is to store, the gloabl variables and its values
// which can be used in entire test automation suites.
// To keep tests simple, This class is not in use in the existing tests.

public class PostEndPointDetails {

    private static String baseUrl = "https://62b86e41f4cb8d63df5db530.mockapi.io";

    private static String jsonSchemaPath="/Users/hariprasad/Downloads/WeShopApiTest/src/test/java/schemas/";

    public static String getJsonSchemaPath() {
        return jsonSchemaPath;
    }

    public static void setJsonSchemaPath(String jsonSchemaPath) {
        PostEndPointDetails.jsonSchemaPath = jsonSchemaPath;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        PostEndPointDetails.baseUrl = baseUrl;
    }

}
