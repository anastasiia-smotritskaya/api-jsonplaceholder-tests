package com.github.anastasiia.smotritskaya.jsonplaceholder.api.users;

import com.github.anastasiia.smotritskaya.jsonplaceholder.base.BaseTest;
import com.github.anastasiia.smotritskaya.jsonplaceholder.clients.UserClient;
import com.github.anastasiia.smotritskaya.jsonplaceholder.models.User;
import com.github.anastasiia.smotritskaya.jsonplaceholder.testdata.UserTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static com.github.anastasiia.smotritskaya.jsonplaceholder.assertions.UserAssertions.assertNewUserEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Users API")
@Feature("PUT /users{id} endpoint")
@Story("Update user (full replace)")
public class UpdateUserTest extends BaseTest {
    private UserClient userClient;
    private static final String EXISTING_USER_ID = "1";
    private static final String NOT_EXISTING_USER_ID = "999";

    @BeforeEach
    void setUp() {
        userClient = new UserClient();
    }

    @Test
    @DisplayName("PUT /user/{id} -> 200 OK, returns correct body")
    void updateUserTest() {
        User newData = UserTestData.getNewUser();

        Response response = userClient.updateUser(newData, EXISTING_USER_ID);

        User actual = response.getBody().as(User.class);

        assertNewUserEquals(newData, actual);
    }

    @Test
    @Disabled("Status code is incorrect: 200")
    @DisplayName("PUT /user/{id} -> 415 Unsupported Media Type, returns empty body")
    void updateUserWithoutContentTypeTest() {
        User newData = UserTestData.getNewUser();

        Response response = userClient.updateUserWithoutContentType(newData, EXISTING_USER_ID);
        assertEquals(415, response.getStatusCode());
        assertEquals("{}", response.getBody().asString());
    }

    @Test
    @Disabled("Status code is incorrect: 500")
    @DisplayName("PUT /user/{id} -> -> 204 No Content returns empty body for not existing user")
    void updateNotExistingUserTest() {
        User newData = UserTestData.getNewUser();

        Response response = userClient.updateUser(newData, NOT_EXISTING_USER_ID);
        assertEquals(204, response.getStatusCode());
        assertEquals("{}", response.getBody().asString());
    }

    @ParameterizedTest(name = "[{index}] {1}")
    @Disabled("Status code is incorrect: 500")
    @DisplayName("PUT /user/{id} -> 400 for invalid ID")
    @CsvSource({
            "'-1', 'Negative number as id'",
            "'a', 'Letter as id'",
            "'#', 'Special character as id'"
    })
    void updateUserInvalidIdTest(String id, String description) {
        User newData = UserTestData.getNewUser();
        Response response = userClient.updateUser(newData, id);

        assertEquals(400, response.getStatusCode());
        assertEquals("{}", response.getBody().asString());
    }

    @ParameterizedTest(name = "[{index}] {1}")
    @Disabled("Status codes are incorrect: 200 or 500")
    @DisplayName("PUT /users{id} -> 400 Bad Request, returns correct status code if the body is invalid")
    @MethodSource("com.github.anastasiia.smotritskaya.jsonplaceholder.testdata.InvalidUserTestData#invalidUserDataProvider")
    void updateUserInvalidBodyTest(String body, String description) {
        Response response = userClient.updateUserRaw(body, EXISTING_USER_ID);

        assertEquals(400, response.getStatusCode());
        assertEquals("{}", response.getBody().asString());
    }
}
