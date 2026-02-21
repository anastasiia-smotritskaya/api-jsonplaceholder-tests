package com.github.anastasiia.smotritskaya.jsonplaceholder.testdata;

import com.github.anastasiia.smotritskaya.jsonplaceholder.models.Address;
import com.github.anastasiia.smotritskaya.jsonplaceholder.models.Company;
import com.github.anastasiia.smotritskaya.jsonplaceholder.models.Geo;
import com.github.anastasiia.smotritskaya.jsonplaceholder.models.User;

/**
 * Тестовые данные для пользователей
 * Содержит предопределенные объекты User для использования в тестах
 */
public class UserTestData {

    /**
     * @return User объект с данными первого пользователя из jsonplaceholder
     */
    public static User getUser_1() {
        User user = new User();
        Address address = new Address();
        Geo geo = new Geo();
        Company company = new Company();

        geo.setLat(-37.3159);
        geo.setLng(81.1496);

        address.setStreet("Kulas Light");
        address.setSuite("Apt. 556");
        address.setCity("Gwenborough");
        address.setZipcode("92998-3874");
        address.setGeo(geo);

        company.setName("Romaguera-Crona");
        company.setCatchPhrase("Multi-layered client-server neural-net");
        company.setBs("harness real-time e-markets");

        user.setId("1");
        user.setName("Leanne Graham");
        user.setUsername("Bret");
        user.setEmail("Sincere@april.biz");
        user.setAddress(address);
        user.setPhone("1-770-736-8031 x56442");
        user.setWebsite("hildegard.org");
        user.setCompany(company);

        return user;
    }

    public static User getNewUser() {
        User user = new User();
        Address address = new Address();

        address.setStreet("123 Main St");
        address.setCity("New York");
        address.setZipcode("10001");

        user.setName("John Doe");
        user.setUsername("johndoe");
        user.setEmail("john@example.com");
        user.setAddress(address);
        user.setPhone("1-555-123-4567");
        user.setWebsite("johndoe.com");

        return user;
    }
}
