
AnimalTypes

GET http://localhost:9721/animals/types

GET http://localhost:9721/animals/types/5

POST http://localhost:9721/animals/types

{
"name": "Snake"
}

PUT  http://localhost:9721/animals/types
{
"id": 2,
"name": "Cat"
}

DELETE http://localhost:9721/animals/types/6



AnimalBreeds

GET http://localhost:9721/animals/breeds

GET http://localhost:9721/animals/breeds/page?pageNo=0&size=3

POST http://localhost:9721/animals/breeds

{
"name": "Welsh terrier",
"animalType": {
"id": 1,
"name": "Dog"
}
}

{
"name": "Bengal",
"animalType": {
"id": 2,
"name": "Cat"
}
}

DELETE http://localhost:9721/animals/breeds/6


Animals

GET http://localhost:9721/animals

GET http://localhost:9721/animals/2

{
    "id": 2,
    "name": "Clark",
    "description": "Free dog",
    "animalBreedEntity": {
        "id": 1011,
        "name": "african",
        "type": {
            "id": 1,
            "name": "Dog"
        }
    },
    "created": "2023-08-14T13:28:13.000+00:00",
    "updated": "2023-08-14T13:28:13.000+00:00"
}


POST http://localhost:9721/animals

{
    "name": "Tiger",
    "description": "Tiger 5",
    "animalBreedDTO": {
        "id": 1011,
        "name": "african",
        "animalTypeDTO": {
            "id": 1,
            "name": "Dog"
        }
    }
}


PUT http://localhost:9721/animals

{
    "id": 2,
    "name": "Tiger Updated",
    "description": "Tiger 5",
    "animalBreedDTO": {
        "id": 1011,
        "name": "african",
        "animalTypeDTO": {
            "id": 1,
            "name": "Dog"
        }
    }
}

DELETE http://localhost:9721/animals/2


Animal images


CREATE TABLE IF NOT EXISTS animal_images
( id BIGINT NOT NULL AUTO_INCREMENT,
animal_id BIGINT NOT NULL,
file_path VARCHAR(256) NOT NULL,
type ENUM('png', 'jpeg'),
size BIGINT NOT NULL,
created TIMESTAMP(0) NOT NULL,
updated TIMESTAMP(0) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (animal_id) REFERENCES animals(id)
);


POST http://localhost:9721/animal/images

current file

JSON (String format)

{
"animalId": 3
}


GET http://localhost:9721/animal/images/22


PUT http://localhost:9721/animal/images/24

current file


DELETE http://localhost:9721/animal/images/12

