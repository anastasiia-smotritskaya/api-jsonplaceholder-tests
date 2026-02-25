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

import static com.github.anastasiia.smotritskaya.jsonplaceholder.assertions.UserAssertions.assertUserEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Users API")
@Feature("GET /user/{id} endpoint")
@Story("Getting the user by id")
public class GetUserTest extends BaseTest {
    private UserClient userClient;

    @BeforeEach
    void setUp() {
        userClient = new UserClient();
    }

    @Test
    @DisplayName("GET /user/{id} -> 200 OK, returns correct body")
    void getExistingUserTest() {
        User expected = UserTestData.getUser_1();

        Response response = userClient.getUser("1");

        assertEquals(200, response.getStatusCode());

        User actual = response.as(User.class);

        assertUserEquals(expected, actual);
    }

    @Test
    @DisplayName("GET /user/{id} -> 404 Not Found for non-existing user")
    void getNotExistingUserTest() {
        Response response = userClient.getUser("999");

        assertEquals(404, response.getStatusCode());
        assertEquals("{}", response.getBody().asString());
    }

    @ParameterizedTest(name = "[{index}] {1}")
    @Disabled("Status code is incorrect: 404")
    @DisplayName("GET /user/{id} -> 400 for invalid ID")
    @CsvSource({
            "'-1', 'Negative number as id'",
            "'a', 'Letter as id'",
            "'#', 'Special character as id'"
    })
    void getUserInvalidIdTest(String id, String description) {
        Response response = userClient.getUser(id);

        assertEquals(400, response.getStatusCode());
        assertEquals("{}", response.getBody().asString());
    }
}
