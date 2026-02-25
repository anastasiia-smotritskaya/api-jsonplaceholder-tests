package com.github.anastasiia.smotritskaya.jsonplaceholder.api.users;

import com.github.anastasiia.smotritskaya.jsonplaceholder.base.BaseTest;
import com.github.anastasiia.smotritskaya.jsonplaceholder.clients.UserClient;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Users API")
@Feature("DELETE /users endpoint")
@Story("Removal a user")
public class DeleteUserTest extends BaseTest {
    private UserClient userClient;

    @BeforeEach
    void setUp() {
        userClient = new UserClient();
    }

    @Test
    @Disabled("Status code is incorrect: 200")
    @DisplayName("DELETE /users -> 204 returns empty body for existing user")
    void deleteExistingUserTest() {
        Response response = userClient.deleteUser("1");

        assertEquals(204, response.getStatusCode());
        assertEquals("{}", response.getBody().asString());
    }

    @Test
    @Disabled("Status code is incorrect: 200")
    @DisplayName("DELETE /users -> 204 returns empty body for not existing user")
    void deleteNotExistingUserTest() {
        Response response = userClient.deleteUser("999");

        assertEquals(404, response.getStatusCode());
        assertEquals("{}", response.getBody().asString());
    }
}
