Add Eureka DiscoveryClient and
hystrix dashboard dependency




Try in url: http://localhost:8085/hystrix 
it will open hystrix dashboard



now put this url: http://localhost:8084/actuator/hystrix.stream
in hystrix dashboard and click Monitor Stream

now try some urls of user-service and department service in browser or
postman and in hystrix dashboard you will see some changes in Metrics