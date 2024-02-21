#! /usr/bin/bash

sudo systemctl start mongod
mongoimport --jsonArray /home/phyo/abaw5/DatabaseAuditor/app/src/mongodb/data/actor.json -d dvdrental -c actor --drop
mongoimport --jsonArray /home/phyo/abaw5/DatabaseAuditor/app/src/mongodb/data/address.json -d dvdrental -c address --drop
mongoimport --jsonArray /home/phyo/abaw5/DatabaseAuditor/app/src/mongodb/data/category.json -d dvdrental -c category --drop
mongoimport --jsonArray /home/phyo/abaw5/DatabaseAuditor/app/src/mongodb/data/city.json -d dvdrental -c city --drop
mongoimport --jsonArray /home/phyo/abaw5/DatabaseAuditor/app/src/mongodb/data/country.json -d dvdrental -c country --drop
mongoimport --jsonArray /home/phyo/abaw5/DatabaseAuditor/app/src/mongodb/data/customer.json -d dvdrental -c customer --drop
mongoimport --jsonArray /home/phyo/abaw5/DatabaseAuditor/app/src/mongodb/data/film_actor.json -d dvdrental -c film_actor --drop
mongoimport --jsonArray /home/phyo/abaw5/DatabaseAuditor/app/src/mongodb/data/film_category.json -d dvdrental -c film_category --drop
mongoimport --jsonArray /home/phyo/abaw5/DatabaseAuditor/app/src/mongodb/data/film.json -d dvdrental -c film --drop
mongoimport --jsonArray /home/phyo/abaw5/DatabaseAuditor/app/src/mongodb/data/inventory.json -d dvdrental -c inventory --drop
mongoimport --jsonArray /home/phyo/abaw5/DatabaseAuditor/app/src/mongodb/data/language.json -d dvdrental -c language --drop
mongoimport --jsonArray /home/phyo/abaw5/DatabaseAuditor/app/src/mongodb/data/payment.json -d dvdrental -c payment --drop
mongoimport --jsonArray /home/phyo/abaw5/DatabaseAuditor/app/src/mongodb/data/rental.json -d dvdrental -c rental --drop
mongoimport --jsonArray /home/phyo/abaw5/DatabaseAuditor/app/src/mongodb/data/staff.json -d dvdrental -c staff --drop
mongoimport --jsonArray /home/phyo/abaw5/DatabaseAuditor/app/src/mongodb/data/store.json -d dvdrental -c store --drop
sudo systemctl stop mongod