
# Micro-Services-SchoolManagement (Academic Project)
### Getting Started with Micro Service Architecture :
In this application we have a total of 9 microServices :
| MicroService | Description |
| ------------ | ----------- |
| Api-Gateway  | API management tool that sits between a client and a collection of backend services|
| Eureka-Server-MS | This micro service is Our discovery Server  |
| Student-management-MS | This micro service is designed to manage students |
| Node-Server-MS | This microservice is designed for scraping courses from YouTube |
| Course-Server-MS | This micro service is designed to manage all the School courses | 
| Teacher-Server-MS | This micro service is designed to manage all the teachers |
| Internship-Server-MS | This micro service is designed to manage all the School internships | 
| Event-Server-MS | This micro service is designed to manage all the School Events| 
| Class-Server-MS | This micro service is designed to manage all the School classes| 

### MSs & their PORTS
| MicroService | local PORT |
| ------------ | ----------- |
| Api-Gateway | 8686 |
| Eureka-Server | 8761 |
| Student-MS | 8082 |
| Course-MS | 8084 |
| Node-MS | 5000 |
| Teacher-MS | 8085 |
| Internship-MS | 1234 |
| Event-MS | 8087 |
| Class-MS | 8088|

### how to run this application :
1- download the code of this repo 
2- install all the dependencies 
3- run `maven clean install` to all the micro services 
4- go to the root folder then run `docker compose up`
