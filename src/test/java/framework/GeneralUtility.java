package framework;

import java.util.UUID;

// this class is to keep commonly used general code across the tests.
public class GeneralUtility {

    public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
