package com.github.anastasiia.smotritskaya.jsonplaceholder.testdata;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * Тестовые данные для некорректных пользователей
 * Содержит предопределенные String body для использования в негативных тестах
 */
public class InvalidUserTestData {

    public static String withNumberInEmail() {
        return "{ \"email\": 123 }";
    }

    public static String withObjectInPhone() {
        return "{ \"phone\": { \"home\": \"123-456\" } }";
    }

    public static String withExtraField() {
        return "{ \"name\": \"John\", \"extraField\": \"should be ignored\" }";
    }

    public static String emptyObject() {
        return "{}";
    }

    public static String malformedJson() {
        return "{ name: John ";
    }

    /**
     * Провайдер данных для параметризованных тестов
     */
    public static Stream<Arguments> invalidUserDataProvider() {
        return Stream.of(
                Arguments.of(withNumberInEmail(), "Invalid user's email"),
                Arguments.of(withObjectInPhone(), "Invalid user's phone number"),
                Arguments.of(withExtraField(), "Object User has extra field"),
                Arguments.of(emptyObject(), "Object User is empty"),
                Arguments.of(malformedJson(), "Invalid JSON (brackets and quotation marks)")
        );
    }
}
