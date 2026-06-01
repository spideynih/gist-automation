package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {

    private static final Dotenv dotenv = Dotenv.load();

    public static String getBaseUrl() {
        return dotenv.get("BASE_URL");
    }

    public static String getBrowser() {
        return dotenv.get("BROWSER");
    }

    public static int getWait() {
        return Integer.parseInt(dotenv.get("IMPLICIT_WAIT"));
    }

    public static String getUsername() {
        return dotenv.get("GITHUB_USERNAME");
    }

    public static String getPassword() {
        return dotenv.get("GITHUB_PASSWORD");
    }
}