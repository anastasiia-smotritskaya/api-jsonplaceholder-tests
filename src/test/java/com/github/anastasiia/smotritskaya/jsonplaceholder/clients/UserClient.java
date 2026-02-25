package com.github.anastasiia.smotritskaya.jsonplaceholder.clients;

import com.github.anastasiia.smotritskaya.jsonplaceholder.models.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * HTTP клиент для работы с /users API
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

    /**
     * Получает данные пользователя по id
     *
     * @param id идентификатор пользователя
     * @return Response объект для дальнейших проверок
     */
    public Response getUser(String id) {
        return given()
                .when()
                .get("/users/" + id)
                .then()
                .extract()
                .response();
    }

    /**
     * Создание нового пользователя с id (статус-код 200)
     *
     * @param user данные нового пользователя
     * @return User нового пользователя с автоматически созданным id
     * @throws AssertionError если статус ответа не 201
     */
    public User createUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract()
                .as(User.class);
    }

    /**
     * Создание нового пользователя с id (статус-код не указан)
     *
     * @param body тело запроса
     * @return Response объект для дальнейших проверок
     */
    public Response createUserRaw(Object body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/users")
                .then()
                .extract()
                .response();
    }

    /**
     * Создание нового пользователя с id (Content type не указан)
     *
     * @param user данные нового пользователя
     * @return Response объект для дальнейших проверок
     * @throws AssertionError если статус ответа не 415
     */
    public Response createUserWithoutContentType(User user) {
        return given()
                .body(user)
                .when()
                .post("/users")
                .then()
                .statusCode(415)
                .extract()
                .response();
    }

    /**
     * Удаление пользователя по id
     *
     * @param id id пользователя
     * @return Response объект для дальнейших проверок
     */
    public Response deleteUser(String id) {
        return given()
                .when()
                .delete("/users/" + id)
                .then()
                .extract().response();
    }

    /**
     * Полное обновление данных пользователя по id
     *
     * @param id id пользователя
     * @return Response объект для дальнейших проверок
     */
    public Response updateUser(User user, String id) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .put("/users/" + id)
                .then()
                .statusCode(200)
                .extract().response();
    }

    /**
     * Полное обновление данных пользователя по id (статус-код не указан)
     *
     * @param id id пользователя
     * @return Response объект для дальнейших проверок
     */
    public Response updateUserRaw(String body, String id) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("/users/" + id)
                .then()
                .extract().response();
    }

    /**
     * Полное обновление данных пользователя по id (Content type не указан)
     *
     * @param id id пользователя
     * @return Response объект для дальнейших проверок
     */
    public Response updateUserWithoutContentType(User user, String id) {
        return given()
                .body(user)
                .when()
                .put("/users/" + id)
                .then()
                .statusCode(415)
                .extract().response();
    }
}
