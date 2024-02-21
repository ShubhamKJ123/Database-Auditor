MATCH (n)
DETACH DELETE n;

LOAD CSV WITH HEADERS FROM 'file:///payment.csv' AS row
MERGE (payment:payment {payment_id: row.payment_id})
  ON CREATE SET	payment.customer_id = row.customer_id,
			payment.staff_id = row.staff_id,
			payment.rental_id = row.rental_id,
			payment.amount = row.amount,
			payment.payment_date = row.payment_date;

LOAD CSV WITH HEADERS FROM 'file:///inventory.csv' AS row
MERGE (inventory:inventory {inventory_id: row.inventory_id})
  ON CREATE SET	inventory.film_id = row.film_id,
			inventory.store_id = row.store_id,
			inventory.last_update = row.last_update;

LOAD CSV WITH HEADERS FROM 'file:///film.csv' AS row
MERGE (film:film {film_id: row.film_id})
  ON CREATE SET	film.title = row.title,
			film.description = row.description,
			film.release_year = row.release_year,
			film.language_id = row.language_id,
			film.rental_duration = row.rental_duration,
			film.rental_rate = row.rental_rate,
			film.length = row.length,
			film.replacement_cost = row.replacement_cost,
			film.rating = row.rating,
			film.last_update = row.last_update,
			film.special_features = row.special_features,
			film.fulltext = row.fulltext;

LOAD CSV WITH HEADERS FROM 'file:///city.csv' AS row
MERGE (city:city {city_id: row.city_id})
  ON CREATE SET	city.city = row.city,
			city.country_id = row.country_id,
			city.last_update = row.last_update;

LOAD CSV WITH HEADERS FROM 'file:///category.csv' AS row
MERGE (category:category {category_id: row.category_id})
  ON CREATE SET	category.name = row.name,
			category.last_update = row.last_update;


LOAD CSV WITH HEADERS FROM 'file:///actor.csv' AS row
MERGE (actor:actor {actor_id: row.actor_id})
  ON CREATE SET	actor.first_name = row.first_name,
			actor.last_name = row.last_name,
			actor.last_update = row.last_update;

LOAD CSV WITH HEADERS FROM 'file:///rental.csv' AS row
MERGE (rental:Rental {rental_id: row.rental_id})
  ON CREATE SET rental.rental_date = row.rental_date,
			rental.inventory_id = row.inventory_id,
			rental.customer_id = row.customer_id,
			rental.return_date = row.return_date,
			rental.staff_id = row.staff_id,
			rental.last_update = row.last_update;

LOAD CSV WITH HEADERS FROM 'file:///store.csv' AS row
MERGE (store:Store {store_id: row.store_id})
  ON CREATE SET store.manager_staff_id = row.manager_staff_id,
			store.address_id = row.address_id,
			store.last_update = row.last_update;

LOAD CSV WITH HEADERS FROM 'file:///staff.csv' AS row
MERGE (staff:Staff {staff_id: row.staff_id})
  ON CREATE SET staff.first_name = row.first_name,
			staff.last_name = row.last_name,
			staff.address_id = row.address_id,
			staff.email = row.email,
			staff.store_id = row.store_id,
			staff.active = row.active,
			staff.username = row.username,
			staff.password = row.password,
			staff.last_update = row.last_update,
			staff.picture = row.picture;

LOAD CSV WITH HEADERS FROM 'file:///language.csv' AS row
MERGE (language:Language {language_id: row.language_id})
  ON CREATE SET language.name = row.name,
			language.last_update = row.last_update;

LOAD CSV WITH HEADERS FROM 'file:///film_actor.csv' AS row
MERGE (film_actor:FilmActor {actor_id: row.actor_id})
  ON CREATE SET film_actor.film_id = row.film_id,
			film_actor.last_update = row.last_update;

LOAD CSV WITH HEADERS FROM 'file:///film_category.csv' AS row
MERGE (film_category:FilmCategory {film_id: row.film_id})
  ON CREATE SET film_category.category_id = row.category_id,
			film_category.last_update = row.last_update;

LOAD CSV WITH HEADERS FROM 'file:///country.csv' AS row
MERGE (country:Country {country_id: row.country_id})
  ON CREATE SET country.country = row.country,
			country.last_update = row.last_update;

LOAD CSV WITH HEADERS FROM 'file:///customer.csv' AS row
MERGE (customer:Customer {customer_id: row.customer_id})
  ON CREATE SET customer.first_name = row.first_name,
			customer.last_name = row.last_name,
			customer.address_id = row.address_id,
			customer.email = row.email,
			customer.store_id = row.store_id,
			customer.activebool = row.activebool,
			customer.create_date = row.create_date,
			customer.last_update = row.last_update,
			customer.active = row.active;

LOAD CSV WITH HEADERS FROM 'file:///address.csv' AS row
MERGE (address:Address {address_id: row.address_id})
  ON CREATE SET address.address = row.address,
			address.address2 = row.address2,
			address.district = row.district,
			address.city_id = row.city_id,
			address.postal_code = row.postal_code,
			address.phone = row.phone,
			address.last_update = row.last_update;

:exit