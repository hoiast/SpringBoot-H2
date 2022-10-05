# SpringBoot-H2
A simple CRUD using [SpringBoot](https://spring.io/projects/spring-boot) and [H2](https://www.h2database.com/) database.
This is a project was bootstrapped using [spring initializr](https://start.spring.io/) and is built with
[Maven](https://maven.apache.org/) and [Kotlin](https://kotlinlang.org/).

A simple function for detection of duplicates in a list of integers is available at the `/duplicates` endpoints. For 
example, a list `[1,1,2]` would return another list with only the repeating elements `[1,1]`. Please read more below for 
instructions how to start and test this application. 

## Getting Started
- Clone this repository.
- Open the Maven project in your favorite IDE.
- Ensure that all the dependencies are downloaded.
- Run the application. The default port is 8080.
- Use [Postman](https://www.postman.com/), [ThunderClient](https://www.thunderclient.com/) or any other client to test the endpoints.

## Endpoints

- __GET__ /duplicates/<br>
  Returns all the duplicates entries registered in the in-memory database.

  ```
  Example: GET /duplicates/2
  Response 200 OK 
  [
    {
      "id": 1,
      "input": "[1, 1, 1, 1, 4, 5, 6, 6]",
      "output": "[1, 1, 1, 1, 6, 6]"
    },
    {
      "id": 2,
      "input": "[2, 3, 3, 4]",
      "output": "[3, 3]"
    },
    {
      "id": 3,
      "input": "[1, 4, 5, 6]",
      "output": "[]"
    }
  ]
  ```
  
- __GET__ /duplicates/{id}<br>
  This endpoint returns a specific duplicate by its id.
  ```
  Example: GET /duplicates/2
  Response 200 OK
  {
    "id": 2,
    "input": "[2, 3, 3, 4]",
    "output": "[3, 3]"
  }
  ```
- __POST__ /duplicates/<br>
  Submit a string representing a list of integers to return the duplicates in the list.
  ```
  Example: POST /duplicates/
  
  Body:
  {
    "input": "[1, 1, 1, 1, 4, 5, 6, 6]"
  }
  
  Response 201 Created:
  {
    "id": 1,
    "input": "[1, 1, 1, 1, 4, 5, 6, 6]",
    "output": "[1, 1, 1, 1, 6, 6]"
  }
  ``` 
  
- __DELETE__ /duplicates/{id}<br>
  This endpoint deletes a specific duplicate by its id.
  ```
  Example: DELETE /duplicates/2
  Response: 204 No Content
  ```
