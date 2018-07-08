# DatabaseRetrievalFunction

## User story
As a front-end developer, I would like a Java program (to be used as an API) for retrieving JSON data from a record within the database, based upon an ID found as a key within the JSON fields (not the primary key ID for the database record). This ID will be a unique number that will be provided to the program (and later API) as a queryStringParameter, which will then search the database JSON data and retrieve the corresponding JSON data that contains that unique ID.   

## Requirements
Produce a simple Java program for retrieving JSON data within a particular record of a postgreSQL database (based upon an ID provided, as queryStringParameters to the API). This API will then provide the correct, corresponding JSON data to the front-end of the App, using an API call from the front-end scripts.

As the program will be used as an API (hosted by Amazon's AWS API gateway), the program will need to return the correct output (JSON data containing the necessary key-value pairs such as the header and response body). 

The program will also need to be an AWS lambda function (so it can run on the API gateway), thus it is necessary for the handleRequest method to be the core method of the program, 

## Technical details
SQL statements will obviously be used for retrieving data from the database.

Example of JSON format that the data output will be shown and returned (which will be retrieved by the front-end of the App using an API call).
{"Project_ID":"003","Artwork_Title":"Big Raven","Artwork_ID":"03","User_Quote":[{"label":"starry","size": 6},{"label":"night  ","size": 3},{"label":"paint  ","size": 1},{"label":"palette ","size": 1},{"label":"grey ","size": 1},{"label":"look ","size": 1},{"label":"out ","size": 1},{"label":"summer ","size": 1},{"label":"day ","size": 1},{"label":"darkness ","size": 1},{"label":"soul ","size": 1},{"label":"shadows ","size": 1},{"label":"hills ","size": 1},{"label":"sketch ","size": 1},{"label":"trees ","size": 1},{"label":"daffodils ","size": 1},{"label":"catch ","size": 1},{"label":"breeze","size": 1},{"label":"winter","size": 1},{"label":"chills","size": 1}]}

## Acceptance criteria
The end result should be a program (hosted as an API), that will provide the front-end of an app with the correct data that has been requested. 
