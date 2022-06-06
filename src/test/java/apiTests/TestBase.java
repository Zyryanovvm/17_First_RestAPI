package apiTests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void settingsProject() {
        RestAssured.baseURI = "https://reqres.in/";
    }
}
