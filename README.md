GET http://localhost:9721/api/animals  - right

GET http://localhost:9721/api/animals/WOLF - right

GET http://localhost:9721/api/animals/WOLF1 - wrong



AnimalTypes

GET http://localhost:9721/api/animals/types

GET http://localhost:9721/api/animals/types/5

POST http://localhost:9721/api/animals/types

{
"name": "Snake"
}

PUT  http://localhost:9721/api/animals/types
{
"id": 2,
"name": "Cat"
}

DELETE http://localhost:9721/api/animals/types/6



AnimalBreeds

GET http://localhost:9721/api/animals/breeds

GET http://localhost:9721/api/animals/breeds/page?pageNo=0&size=3

POST http://localhost:9721/api/animals/breeds

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

DELETE http://localhost:9721/api/animals/breeds/6


Animals

GET http://localhost:9721/api/animals/animals

GET http://localhost:9721/api/animals/animals/2



DELETE http://localhost:9721/api/animals/animals/2
{
    "id": 2,
    "name": "Clark",
    "description": "Free dog",
    "animalTypeEntity": {
        "id": 1,
        "name": "Dog"
    },
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


