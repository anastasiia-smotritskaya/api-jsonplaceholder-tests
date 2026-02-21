package com.github.anastasiia.smotritskaya.jsonplaceholder.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

/**
 * Базовый класс для всех тестов
 * Устанавливает глобальную конфигурацию RestAssured
 */
public class BaseTest {

    /**
     * Инициализирует базовые настройки перед запуском всех тестов
     * Устанавливает baseURI для всех запросов
     */
    @BeforeAll
    public static void globalSetUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
}
