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

### Eureka Server pom.xml Configuration
```pom.xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-eureka-server</artifactId>
</dependency>
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

### Eureka Client pom.xml Configuration
```pom.xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
```


## Test
Spring Boot Test for testing Rest Controllers

### Test Dependency
```pom.xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>
```

### Test Case 
```java
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CpmMicroServiceApplicationTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void getHome() throws Exception {
		this.mockMvc.perform(get("/home").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().string("home.."));
	}
}
```

### Test Case with Random Port
```java
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RandomPortExampleTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void exampleTest() {
		String body = this.restTemplate.getForObject("/home", String.class);
		assertThat(body).isEqualTo("home..");
	}

}
```
