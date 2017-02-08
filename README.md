# spring-cloud-eureka
spring cloud with eureka registry service


## Eureka Server

### Eureka Server Application Configuration
```java
@SpringBootApplication
@EnableEurekaServer
@EnableZuulProxy
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
}
```

### Eureka Server application.yml Configuration
```yml
server:
  port: 8761
  
spring:
  application:
    name: api-gateway
    
eureka:
  instance:
    hostname: localhost
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/ 
```
## Eureka Client

### Eureka Client Application Configuration
```java
@SpringBootApplication
@EnableEurekaClient
public class CpmMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpmMicroServiceApplication.class, args);
	}
}
```
### Eureka Client application.yml Configuration
```yml
server:
  port: 9090
  
spring:
  application:
    name: cpm-service
   
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
```
