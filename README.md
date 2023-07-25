GET http://localhost:9721/api/animals  - right

GET http://localhost:9721/api/animals/WOLF - right

GET http://localhost:9721/api/animals/WOLF1 - wrong


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