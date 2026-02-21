package com.github.anastasiia.smotritskaya.jsonplaceholder.assertions;

import com.github.anastasiia.smotritskaya.jsonplaceholder.models.Address;
import com.github.anastasiia.smotritskaya.jsonplaceholder.models.Company;
import com.github.anastasiia.smotritskaya.jsonplaceholder.models.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Кастомные методы для проверки объектов User
 */
public class UserAssertions {

    /**
     * Сравнивает двух пользователей по всем полям
     *
     * @param expected ожидаемый пользователь
     * @param actual   фактический пользователь из ответа API
     */
    public static void assertUserEquals(User expected, User actual) {
        assertAll(
                () -> assertEquals(expected.getId(), actual.getId()),
                () -> assertEquals(expected.getName(), actual.getName()),
                () -> assertEquals(expected.getUsername(), actual.getUsername()),
                () -> assertEquals(expected.getEmail(), actual.getEmail()),
                () -> assertAddressesEquals(expected.getAddress(), actual.getAddress()),
                () -> assertEquals(expected.getPhone(), actual.getPhone()),
                () -> assertEquals(expected.getWebsite(), actual.getWebsite()),
                () -> assertCompaniesEquals(expected.getCompany(), actual.getCompany())
        );
    }

    /**
     * Сравнивает два адреса по всем полям
     *
     * @param expected первый адрес
     * @param actual   второй адрес
     */
    public static void assertAddressesEquals(Address expected, Address actual) {
        assertAll(
                () -> assertEquals(expected.getStreet(), actual.getStreet()),
                () -> assertEquals(expected.getSuite(), actual.getSuite()),
                () -> assertEquals(expected.getCity(), actual.getCity()),
                () -> assertEquals(expected.getZipcode(), actual.getZipcode()),
                () -> assertEquals(expected.getGeo().getLat(), actual.getGeo().getLat()),
                () -> assertEquals(expected.getGeo().getLng(), actual.getGeo().getLng())
        );
    }

    public static void assertCompaniesEquals(Company expected, Company actual) {
        assertAll(
                () -> assertEquals(expected.getName(), actual.getName()),
                () -> assertEquals(expected.getCatchPhrase(), actual.getCatchPhrase()),
                () -> assertEquals(expected.getBs(), actual.getBs())
        );
    }

    /**
     * Проверяет, что ни одно из полей пользователя не null
     *
     * @param user пользователь для проверки полей на null
     */
    public static void assertUserNotNull(User user) {
        assertAll(
                () -> assertNotNull(user.getId()),
                () -> assertNotNull(user.getName()),
                () -> assertNotNull(user.getUsername()),
                () -> assertNotNull(user.getEmail()),
                () -> assertAddressNotNull(user.getAddress()),
                () -> assertNotNull(user.getPhone()),
                () -> assertNotNull(user.getWebsite()),
                () -> assertCompanyNotNull(user.getCompany())
        );
    }

    /**
     * Проверяет, что ни одно из полей адреса не null
     *
     * @param address адрес для проверки полей на null
     */
    public static void assertAddressNotNull(Address address) {
        assertAll(
                () -> assertNotNull(address.getStreet()),
                () -> assertNotNull(address.getSuite()),
                () -> assertNotNull(address.getCity()),
                () -> assertNotNull(address.getZipcode()),
                () -> assertNotNull(address.getGeo())
        );
    }

    /**
     * Проверяет, что ни одно из полей компании не null
     *
     * @param company компания для проверки полей на null
     */
    public static void assertCompanyNotNull(Company company) {
        assertAll(
                () -> assertNotNull(company.getName()),
                () -> assertNotNull(company.getCatchPhrase()),
                () -> assertNotNull(company.getBs())
        );
    }
}
