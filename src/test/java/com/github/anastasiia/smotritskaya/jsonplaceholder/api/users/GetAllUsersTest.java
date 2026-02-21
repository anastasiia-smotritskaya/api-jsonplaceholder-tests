package com.github.anastasiia.smotritskaya.jsonplaceholder.api.users;

import com.github.anastasiia.smotritskaya.jsonplaceholder.assertions.UserAssertions;
import com.github.anastasiia.smotritskaya.jsonplaceholder.clients.UserClient;
import com.github.anastasiia.smotritskaya.jsonplaceholder.base.BaseTest;
import com.github.anastasiia.smotritskaya.jsonplaceholder.models.User;
import com.github.anastasiia.smotritskaya.jsonplaceholder.testdata.UserTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Users API")
@Feature("GET /users endpoint")
@Story("Getting a list of all users")
public class GetAllUsersTest extends BaseTest {
    private UserClient userClient;

    @BeforeEach
    void setUp() {
        userClient = new UserClient();
    }

    @Test
    @DisplayName("GET /users -> 200 OK, returns list of 10 users, first user matches expected data")
    void getAllUsersTest() {
        User expected = UserTestData.getUser_1();

        List<User> users = userClient.getAllUsers();
        User actual = users.getFirst();

        assertFalse(users.isEmpty());
        assertEquals(10, users.size());

        users.forEach(UserAssertions::assertUserNotNull);

        UserAssertions.assertUserEquals(expected, actual);
    }
}
