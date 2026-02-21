package com.github.anastasiia.smotritskaya.jsonplaceholder.testdata;

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
}
