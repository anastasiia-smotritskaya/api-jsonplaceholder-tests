package com.github.anastasiia.smotritskaya.jsonplaceholder.models;

/**
 * Координаты геолокации пользователя.
 * Вложен в объект {@link Address}.
 * Соответствует JSON-объекту "geo".
 */
public class Geo {
    private double lat;
    private double lng;

    public Geo() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
