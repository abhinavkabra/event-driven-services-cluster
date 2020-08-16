# Event-driven-services-cluster
This is repo containing four services which interacts based on event driven design over Rabbit MQ

# Instructons
 - Go to root folder and execute `mvn clean install` or `mvnw clean install`
 - Once above command is successful then execute `docker-compose up -d`
 - Go to `http://localhost:8080`, it will open a Swagger UI. Go to POST /v1/customer/order endpoint and try it out with cutomer id 1 (this is hack as of now)
 - Now check logs for all the event published by different services
