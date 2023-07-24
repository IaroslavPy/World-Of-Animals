GET http://localhost:9721/api/animals  - right

GET http://localhost:9721/api/animals/WOLF - right

GET http://localhost:9721/api/animals/WOLF1 - wrong


AnimalTypes

GET http://localhost:9721/api/animalTypes

GET http://localhost:9721/api/animalTypes/5

POST http://localhost:9721/api/animalTypes 

{
"name": "Snake"
}

PUT  http://localhost:9721/api/animalTypes
{
"id": 2,
"name": "Cat"
}

DELETE http://localhost:9721/api/animalTypes/6


AnimalBreeds

GET http://localhost:9721/api/animalBreeds

GET http://localhost:9721/api/animalTypes/5

POST http://localhost:9721/api/animalBreeds

{
"name": "Welsh terrier",
"type": {
        "id": 1,
        "name": "Dog"
        }
}


PUT  http://localhost:9721/api/animalTypes
{
"id": 2,
"name": "Cat"
}

DELETE http://localhost:9721/api/animalTypes/6