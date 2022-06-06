package apiTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static apiTests.ReqresUri.*;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class ReqresTests extends TestBase {

    String supportMessage = "To keep ReqRes free, contributions towards server costs are appreciated!";
    String bodyCreateUser = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";
    String bodyRegisterUser = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }";
    String bodyBadRegisterUser = "{ \"email\": \"sydney@fife\" }";

    @CsvSource(value = {
            "2 | Janet | Weaver",
            "5 | Charles | Morris",
            "10 | Byron | Fields"
    },
            delimiter = '|'
    )
    @ParameterizedTest(name = "Assert users first and last name")
    void getSingleUsers(Integer users, String firstName, String lastName) {
        get(singleUsersUri + users)
                .then()
                .statusCode(200)
                .body("data.id", is(users))
                .body("data.first_name", is(firstName))
                .body("data.last_name", is(lastName))
                .body("support.text", is(supportMessage))
                .body("data.avatar", notNullValue());

    }

    @Test
    void createUser() {
        given()
                .body(bodyCreateUser)
                .contentType(JSON)
                .when()
                .post(createUsersUri)
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }

    @ValueSource(ints = {
            7,
            11,
            13
    })
    @ParameterizedTest(name = "Delete Users")
    void deleteUser(Integer user) {
        delete(singleUsersUri + user)
                .then()
                .statusCode(204);
    }

    @Test
    void registerNewUsers() {
        given()
                .body(bodyRegisterUser)
                .contentType(JSON)
                .when()
                .post(registerUsersUri)
                .then()
                .log().body()
                .statusCode(200)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void badRegisterNewUsers() {
        given()
                .body(bodyBadRegisterUser)
                .contentType(JSON)
                .when()
                .post(registerUsersUri)
                .then()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));
    }

}
