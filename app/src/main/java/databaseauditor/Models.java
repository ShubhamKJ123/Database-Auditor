package databaseauditor;

import java.sql.Timestamp;

class Actor {
    int actor_id;
    String first_name;
    String last_name;
    Timestamp last_update;

    Actor(int actor_id, String first_name, String last_name, Timestamp last_update) {
        this.actor_id = actor_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.last_update = last_update;
    }
}

class Address {
    int address_id;
    String address;
    String address2;
    String district;
    int city_id;
    String postal_code;
    String phone;
    Timestamp last_update;

    Address(int address_id, String address, String address2, String district, int city_id, String postal_code,
            String phone, Timestamp last_update) {
        this.address_id = address_id;
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.city_id = city_id;
        this.postal_code = postal_code;
        this.phone = phone;
        this.last_update = last_update;
    }
}

class Category {
    int category_id;
    String name;
    Timestamp last_update;

    Category(int category_id, String name, Timestamp last_update) {
        this.category_id = category_id;
        this.name = name;
        this.last_update = last_update;
    }
}

class City {
    int city_id;
    String city;
    int country_id;
    Timestamp last_update;

    City(int city_id, String city, int country_id, Timestamp last_update) {
        this.city_id = city_id;
        this.city = city;
        this.country_id = country_id;
        this.last_update = last_update;
    }
}

class Country {
    int country_id;
    String country;
    Timestamp last_update;

    Country(int country_id, String country, Timestamp last_update) {
        this.country_id = country_id;
        this.country = country;
        this.last_update = last_update;
    }
}

class Customer {
    int customer_id;
    int store_id;
    String first_name;
    String last_name;
    String email;
    int address_id;
    boolean activebool;
    Timestamp create_date;
    Timestamp last_update;
    int active;

    Customer(int customer_id, int store_id, String first_name, String last_name, String email, int address_id,
            boolean activebool, Timestamp create_date, Timestamp last_update, int active) {
        this.customer_id = customer_id;
        this.store_id = store_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address_id = address_id;
        this.activebool = activebool;
        this.create_date = create_date;
        this.last_update = last_update;
        this.active = active;
    }
}

class Film {
    int film_id;
    String title;
    String description;
    Timestamp release_year;
    int language_id;
    String fulltext;
    int rental_duration;
    double rental_rate;
    int length;
    double replacement_cost;
    String rating;
    String special_features;
    Timestamp last_update;

    Film(int film_id, String title, String description, Timestamp release_year, int language_id, String fulltext,
            int rental_duration, double rental_rate, int length, double replacement_cost, String rating,
            String special_features, Timestamp last_update) {
        this.film_id = film_id;
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language_id = language_id;
        this.fulltext = fulltext;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.special_features = special_features;
        this.last_update = last_update;
    }
}

class FilmActor {
    int actor_id;
    int film_id;
    Timestamp last_update;

    FilmActor(int actor_id, int film_id, Timestamp last_update) {
        this.actor_id = actor_id;
        this.film_id = film_id;
        this.last_update = last_update;
    }
}

class FilmCategory {
    int film_id;
    int category_id;
    Timestamp last_update;

    FilmCategory(int film_id, int category_id, Timestamp last_update) {
        this.film_id = film_id;
        this.category_id = category_id;
        this.last_update = last_update;
    }
}

class Inventory {
    int inventory_id;
    int film_id;
    int store_id;
    Timestamp last_update;

    Inventory(int inventory_id, int film_id, int store_id, Timestamp last_update) {
        this.inventory_id = inventory_id;
        this.film_id = film_id;
        this.store_id = store_id;
        this.last_update = last_update;
    }
}

class Language {
    int language_id;
    String name;
    Timestamp last_update;

    Language(int language_id, String name, Timestamp last_update) {
        this.language_id = language_id;
        this.name = name;
        this.last_update = last_update;
    }
}

class Payment {
    int payment_id;
    int customer_id;
    int staff_id;
    int rental_id;
    double amount;
    Timestamp payment_date;

    Payment(int payment_id, int customer_id, int staff_id, int rental_id, double amount, Timestamp payment_date) {
        this.payment_id = payment_id;
        this.customer_id = customer_id;
        this.staff_id = staff_id;
        this.rental_id = rental_id;
        this.amount = amount;
        this.payment_date = payment_date;
    }
}

class Rental {
    int rental_id;
    Timestamp rental_date;
    int inventory_id;
    int customer_id;
    Timestamp return_date;
    int staff_id;
    Timestamp last_update;

    Rental(int rental_id, Timestamp rental_date, int inventory_id, int customer_id, Timestamp return_date, int staff_id,
            Timestamp last_update) {
        this.rental_id = rental_id;
        this.rental_date = rental_date;
        this.inventory_id = inventory_id;
        this.customer_id = customer_id;
        this.return_date = return_date;
        this.staff_id = staff_id;
        this.last_update = last_update;
    }
}

class Staff {
    int staff_id;
    int address_id;
    String first_name;
    String last_name;
    String email;
    int store_id;
    int picture;
    String username;
    String password;
    Timestamp last_update;
    int active;

    Staff(int staff_id, int address_id, String first_name, String last_name, String email, int store_id, int picture,
            String username, String password, Timestamp last_update, int active) {
        this.staff_id = staff_id;
        this.address_id = address_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.store_id = store_id;
        this.picture = picture;
        this.username = username;
        this.password = password;
        this.last_update = last_update;
        this.active = active;
    }
}

class Store {
    int store_id;
    int manager_staff_id;
    int address_id;
    Timestamp last_update;

    Store(int store_id, int manager_staff_id, int address_id, Timestamp last_update) {
        this.store_id = store_id;
        this.manager_staff_id = manager_staff_id;
        this.address_id = address_id;
        this.last_update = last_update;
    }
}