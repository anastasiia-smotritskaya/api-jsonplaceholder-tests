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
import org.junit.jupiter.params.provider.MethodSource;

import static com.github.anastasiia.smotritskaya.jsonplaceholder.assertions.UserAssertions.assertNewUserEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Users API")
@Feature("POST /users endpoint")
@Story("Creating a new user")
public class CreateUserTest extends BaseTest {
    private UserClient userClient;
    private static final String NEW_USER_ID = "11";

    @BeforeEach
    void setUp() {
        userClient = new UserClient();
    }

    @Test
    @DisplayName("POST /users -> 201 Created, returns new user data with correct id number")
    void createUserPositiveTest() {
        User user = UserTestData.getNewUser();

        User actual = userClient.createUser(user);

        assertEquals(NEW_USER_ID, actual.getId());
        assertNewUserEquals(user, actual);
    }

    @ParameterizedTest(name = "[{index}] {1}")
    @Disabled("Status codes are incorrect: 201 or 500")
    @DisplayName("POST /users -> 400 Bad Request, returns correct status code if the body is invalid")
    @MethodSource("com.github.anastasiia.smotritskaya.jsonplaceholder.testdata.InvalidUserTestData#invalidUserDataProvider")
    void createUserInvalidBodyTest(String body, String description) {
        Response response = userClient.createUserRaw(body);

        assertEquals(400, response.getStatusCode());
    }

    @Test
    @Disabled("Status code is incorrect: 201")
    @DisplayName("POST /users -> 415 Unsupported Media Type, returns correct status code " +
            "if the request has no content type header")
    void createUserWithoutContentTypeTest() {
        User user = UserTestData.getNewUser();

        Response response = userClient.createUserWithoutContentType(user);

        assertEquals(415, response.getStatusCode());
    }
}
