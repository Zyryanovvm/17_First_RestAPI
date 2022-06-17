package apiTests;

import models.lombok.FirstKeyLombok;
import models.oldSchool.FirstKey;
import org.junit.jupiter.api.Test;

import static helpers.Spec.requestSpec;
import static helpers.Spec.responseSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpgradedReqresTests extends TestBase {

    public String expectedText = "To keep ReqRes free, contributions towards server costs are appreciated!";

    @Test
    void getUser() {
        // @formatter:off
        FirstKey responseBody = given()
                .spec(requestSpec)
                .when()
                .get("/api/users/5")
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().as(FirstKey.class);

        assertEquals(5, responseBody.getData().getId());
        assertEquals(expectedText, responseBody.getSupport().getText());
        // @formatter:on
    }

    @Test
    void getUserLombok() {
        FirstKeyLombok responseBodyLombok = given()
                .spec(requestSpec)
                .when()
                .get("/api/users/4")
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().as(FirstKeyLombok.class);

        assertEquals(4, responseBodyLombok.getDataLombok().getIdLombok());
        assertEquals(expectedText, responseBodyLombok.getSupportLombok().getTextLombok());
    }

    @Test
    void getUserForId() {
        given()
                .spec(requestSpec)
                .when()
                .get("/api/users")
                .then()
                .spec(responseSpec)
                .log().body()
                .body("data.findAll{it.id =~/1/}.id.flatten()",
                        hasItem(1))
                .body("data.findAll{it.id =~/6/}.id.flatten()",
                        hasItem(6))
                .body("data.findAll{it.email =~/.*?@reqres.in/}.email.flatten()",
                        hasItem("tracey.ramos@reqres.in"));


    }
}
