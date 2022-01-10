# Java project call data assignment

# Requirements

For building and running the application you need:

- JDK 11
- Maven
- MySQL

# Running the application locally

- Clone the project.
- open in terminal/IDE

### Run springboot app

- To run the backend application :
  ```
   ./mvnw spring-boot:run
  ```
###### Snapshot :
![image](https://user-images.githubusercontent.com/72094044/148852581-2ab6de7f-0ef8-4df8-b04c-e9bfbee196f5.png)


### Calling REST services in spring from Postman
 
##### Get request to get hour of the day when the call volume is highest:

 ```
 http://localhost:8080/call/volume/hour/13-01-2021
 
 NOTE: Date must be in format DD-MM-YYYY
 ```
###### Snapshot :
![image](https://user-images.githubusercontent.com/72094044/148853133-ada20cd4-ebdf-4262-8da9-21f77f9d59ff.png)

 ```
   06-07AM is hour of the day 13-01-2021 when call volume is highest.
 ```
 

##### Get request to get hour of the day when the calls are longest.
 
 ```
  http://localhost:8080/call/longest/hour/13-01-2021
  
  NOTE: Date must be in format DD-MM-YYYY
 ```
###### Snapshot :
![image](https://user-images.githubusercontent.com/72094044/148853432-fafe5750-5264-4a0a-bb5e-97624af29afb.png)

 ```
   06-07AM is hour of the day 13-01-2021 when calls are longest i.e 1381 seconds.
 ```

 
##### > Get request to get day of the week when the call volume is highest. 
 
 ```
 http://localhost:8080/call/longest/day/02-2021
 
 NOTE : Week must be in format 02-2021 (2nd week of 2021)
 ```
 ###### Snapshot :
 ![image](https://user-images.githubusercontent.com/72094044/148853659-d4cbc1e8-afb8-4a4e-beda-19161d3da490.png)

 ```
   Wed is day of the 2nd week of 2021 when calls are longest i.e 1381 seconds.
 ```
 
##### Get request to get day of the week when the calls are longest.

 ```
 http://localhost:8080/call/volume/day/02-2021
 
 
 NOTE : Week must be in format 02-2021 (2nd week of 2021)
 ```
 ###### Snapshot :
![image](https://user-images.githubusercontent.com/72094044/148856364-0971509e-57d4-4007-949a-555d58876e9e.png)

 ```
   Thu is day of the 2nd week of 2021 when call volume is highest i.e 8 times.
 ```

 
##Database Screenshot:
![image](https://user-images.githubusercontent.com/72094044/148854200-b83a51ff-28d9-4854-9489-54d0a4721b1e.png)
