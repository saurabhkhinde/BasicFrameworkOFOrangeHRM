package utils;

import java.util.UUID;

public class TestDataUtils {

        public static String generateRandomName() {
            return "Auto" + UUID.randomUUID().toString().substring(0, 5);
        }
}
