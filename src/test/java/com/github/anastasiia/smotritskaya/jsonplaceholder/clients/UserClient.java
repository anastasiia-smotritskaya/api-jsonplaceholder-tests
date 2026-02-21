package com.github.anastasiia.smotritskaya.jsonplaceholder.clients;

import com.github.anastasiia.smotritskaya.jsonplaceholder.models.User;

import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * HTTP клиент для работы с /users эндпоинтом
 * Предоставляет методы для выполнения запросов к API пользователей
 */
public class UserClient {

    /**
     * Получает список всех пользователей
     *
     * @return List&lt;User&gt; список пользователей
     * @throws AssertionError если статус ответа не 200
     */
    public List<User> getAllUsers() {
        return given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList(".", User.class);
    }
}
