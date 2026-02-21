package com.github.anastasiia.smotritskaya.jsonplaceholder.api.users;

import com.github.anastasiia.smotritskaya.jsonplaceholder.models.User;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class GetAllUsersTest {
    @Test
    void getAllUsersTest() {
        Response response = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .statusCode(200)
                .extract().response();

        List<User> users = Arrays.asList(response.as(User[].class));

        assertFalse(users.isEmpty());
        assertEquals(10, users.size());

        User user_1 = users.getFirst();

        assertAll(
                () -> assertEquals("1", user_1.getId()),
                () -> assertEquals("Leanne Graham", user_1.getName()),
                () -> assertEquals("Bret", user_1.getUsername()),
                () -> assertEquals("Sincere@april.biz", user_1.getEmail()),
                () -> assertEquals("Kulas Light", user_1.getAddress().getStreet()),
                () -> assertEquals("Apt. 556", user_1.getAddress().getSuite()),
                () -> assertEquals("Gwenborough", user_1.getAddress().getCity()),
                () -> assertEquals("92998-3874", user_1.getAddress().getZipcode()),
                () -> assertEquals(-37.3159, user_1.getAddress().getGeo().getLat()),
                () -> assertEquals(81.1496, user_1.getAddress().getGeo().getLng()),
                () -> assertEquals("1-770-736-8031 x56442", user_1.getPhone()),
                () -> assertEquals("hildegard.org", user_1.getWebsite()),
                () -> assertEquals("Romaguera-Crona", user_1.getCompany().getName()),
                () -> assertEquals("Multi-layered client-server neural-net", user_1.getCompany().getCatchPhrase()),
                () -> assertEquals("harness real-time e-markets", user_1.getCompany().getBs()));
    }
}
