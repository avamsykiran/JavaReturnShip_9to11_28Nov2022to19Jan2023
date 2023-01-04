Microservices
---------------------------------------------------------------------------------------------------------------------------

    a micrservice is an isolated api which is a part of a bigger ecosystem.

    a group of inter-communicating microservices make up a microservice-ecosystem.

    Monolythic Approach

        1. has one and only one deployment unit
        2. the whole application is one single unit.
        3. for the sake of maintianability this application can be devided into modules.

        Limitatiuons
        - Scalability
        - Interoparability
        - Huge Team Size
                  |-------------------------------------------------------------|
        DB  <---> | [ DeptRepo --- DeptService ---- DeptController          ]   |   <---> Client
                  | [ EmpRepo --- EmpService ---- EmpController              ]  |
                  | [ AccountRepo --- AccountService ---- AccountController  ]  |
                  |-------------------------------------------------------------|


    Microservices Approach

     |--------------------------------------------------------------------------------|   
     |            |-------------------------------------------------------------|     |  
     |  DB  <---> | [ DeptRepo --- DeptService ---- DeptController          ]   |     |
     |            |-------------------------------------------------------------|     |  
     |                                                                                |
     |            |-------------------------------------------------------------|     |  
     |  DB  <---> | [ EmpRepo --- EmpService ---- EmpController              ]  |     |     <--------->   CLIENT
     |            |-------------------------------------------------------------|     |
     |                                                                                |
     |            |-------------------------------------------------------------|     |  
     | DB  <--->  | [ AccountRepo --- AccountService ---- AccountController  ]  |     |
     |            |-------------------------------------------------------------|     |
     |--------------------------------------------------------------------------------|        


        + Scalability
        + Interaparabile
        + Large Set of smaller teams

        Challenges
        ----------------------------------------------------

            1. Inter Service Communication
            2. Decomposition
            3. How to handle multiple urls when a client needs to consume the API.
            4. Databases
        
        Microservice Design Patterns
        ---------------------------------------------------------

            Decomposition Design Patterns
                Decomposition by Doamin
                Decomposition by Sub-Domain

            Database Design Patterns
                Single Database Design Pattern
                Database Per Service Design Pattern

            Integration Design Patterns
                Aggregator Design Pattern
                Client/UI Side Componenet Design Pattern
                API Gateway Design Pattern
                
            Observability Design Patterns
                Distributed Tracing Design Pattern
                Log Aggregation Design Pattern

            Cross Cutting Design Patterns
                Discovery Service Design Pattern
                Load Balancing Design Pattern
                Cirucuit Breaking Design Pattern
                External Configuaration Design Pattern


        Case Study - Budget Tracking Application
        ------------------------------------------------------

            MonoLytic Application High Level Requirements
            1. Each consumer muzt register an account
            2. Each registered user can record an transaction detials like amount,txnDate,txnType(CREDIT/DEBIT) ...etc.,
            3. Each registered user can edit/delete a recorded transaction
            4. Each registered user can ask for the account balance.
            5. Each registered user can ask for a account statement monthly
            6. Each registered user can ask for a account statement annually

        
        Decomposition by Doamin

            will help in decomposing the monolythic apprioach into isolated microservices.

            profile-service
                1. Each consumer muzt register an account

            txn-service
                2. Each registered user can record an transaction detials like amount,txnDate,txnType(CREDIT/DEBIT) ...etc.,
                3. Each registered user can edit/delete a recorded transaction
                4. Each registered user can ask for the account balance.
            
            stateemnt-service
                5. Each registered user can ask for a account statement monthly
                6. Each registered user can ask for a account statement annually

        Decomposition by Sub-Doamin

            will help in identifing god classes and fix a bounded-context for them.

            profile-service
                AccountHolder       
                    Long ahId
                    String name
                    String mobile
                    String mail

            txn-service
                AccountHolder
                    Long ahId
                    Double currentBalance
                    Set<Txn> transactions

                Txn
                    Long txnId
                    String header
                    Double amount
                    LocalDate txnDate
                    TxnType type
                    AccountHolder holder


            statement-service
                AccountHolder
                    Long ahId
                    String name
                    String mobile
                    String mail
                    Double currentBalance

                Txn
                    Long txnId
                    String header
                    Double amount
                    LocalDate txnDate
                    TxnType type

                Statement
                    AccountHolder profile
                    Set<Txn> txns
                    LocalDate startDate
                    LocalDate endDate
                    Double totalCredit
                    Double totalDebit
                    Double statementBalance

        Database Per Service Design Pattern

            profile-service     txns-service        statement-service
                |                   |                   
              profileDB            txnsDb 

        Aggregator Design Pattern

                          CLIENT(S)
                            |
                            |statement
                            |
                    statement-service 
                        |         |
  accountHolder Details |         | currentBal and txns              
                        |         |
            profile-service     txns-service        
                |                   |                   
              profileDB            txnsDb 

        API Gateway Design Pattern

            CLIENT(S)
                |
                |
            API-Gateway
                |
                ------------------------------------------------------------------
                |                           |                       |
            profile-service  -------   txn-service   -----   statement-service
                    |---------------------------------------------|

        Discovery Service Design Pattern

            CLIENT(S)
                |
                |
            API-Gateway  --------------------------------------------- discovery-service
                |                                                               |
                |                                                               |
                ------------------------------------------------------------------
                |                           |                       |
            profile-service  -------   txn-service   -----   statement-service
                    |---------------------------------------------|

        Distributed Tracing Design Pattern

              CLIENT(S)
                |
                |
            API-Gateway  ------------------------------------ discovery-service
                |                                                   |
                |                                                   |
                ------------------------------------------------------
                |                           |                       |
            profile-service  -------   txn-service   -----   statement-service
                    |-------------------------------------------|
                |                           |                       |
                ------------------------------------------------------
                |
                |
            tracing-service

        External Configuaration Design Pattern

              CLIENT(S)
                |
                |
            API-Gateway  ------------------------------------ discovery-service
                |                                                   |
                |                                                   |
                ------------------------------------------------------
                |                           |                       |
            profile-service  -------   txn-service   -----   statement-service
                |   |-------------------------------------------|   |
                |                           |                       |
                ------------------------------------------------------
                |                                                    |   
                |                                                    |   
            tracing-service                                        config-serivce
                                                                        |
                                                                        git-repo
                                                                            gatway service config
                                                                            profile service config
                                                                            txn service config
                                                                            statement service config

       The complete Microservices Eco-System Archetecture using Spring Cloud

                Angular/React/Andriod Clients
                           ↑↓ 
                    gateway-service         <-------------------------------->  discovery-service
                (spring cloud api gateway)                                    (netflix eureka discovery service)
                          ↑↓                                                            ↑↓
                ----------------------------------------------------------------------------------
                ↑↓                                      ↑↓                                      ↑↓
            profile-service     <------------>      txns-service    <---------->        statement-service
                ↑↓                                       ↑↓
             profileDB                                 txnsDB
                spring cloud load balancer              spring cloud load balancer              spring cloud load balancer
                   sleuth                                  sleuth                                  sleuth
                  zipkin-client                         zipkin-client                           zipkin-client    
                    ↑↓                                      ↑↓                                      ↑↓
                    ----------------------------------------------------------------------------------
                           ↑↓                                                             ↑↓ 
                    tracing-service                                                     config-service
                    (zipkin-server)                                                   (spring cloud config server)
                                                                                        ↑↓ 
                                                                                        GitRepo
                                                                                            profile.properties
                                                                                            txns.properties
                                                                                            stateemnt.properties
                                                                                            gateway.properties

    Implementing Budget-tracker
                                            
        Step#1  implementing decomposed services and do inter-service communication and aggregator
            in.bta:bta-profiles
                dependencies
                    org.springframework.boot:spring-boot-starter-web
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-openfeign
                    mysq1:mysql-connector-java
                    org.springframework.boot:spring-boot-starter-data-jpa
                configuaration
                    spring.application.name=profiles
                    server.port=9100

                    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
                    spring.datasource.username=root
                    spring.datasource.password=root
                    spring.datasource.url=jdbc:mysql://localhost:3306/bapsDB?createDatabaseIfNotExist=true
                    spring.jpa.hibernate.ddl-auto=update

            in.bta:bta-txns
                dependencies
                    org.springframework.boot:spring-boot-starter-web
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-openfeign
                    mysq1:mysql-connector-java
                    org.springframework.boot:spring-boot-starter-data-jpa
                configuaration
                    spring.application.name=txns
                    server.port=9200

                    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
                    spring.datasource.username=root
                    spring.datasource.password=root
                    spring.datasource.url=jdbc:mysql://localhost:3306/batxnsDB?createDatabaseIfNotExist=true
                    spring.jpa.hibernate.ddl-auto=update

            in.bta:bta-statement
                dependencies
                    org.springframework.boot:spring-boot-starter-web
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-openfeign
                configuaration
                    spring.application.name=statement
                    server.port=9300

        Step#2  implementing discovery service and client side load balancing
            in.bta:bta-discovery
                dependencies
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-starter-netflix-eureka-server
                configuaration
                    @EnableEurekaServer    on Application class

                    spring.application.name=discovery
                    server.port=9000

                    eureka.instance.hostname=localhost
                    eureka.client.registerWithEureka=false
                    eureka.client.fetchRegistry=false
                    eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/
                    eureka.server.waitTimeInMsWhenSyncEmpty=0

            in.bta:bta-profiles
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
                    ++ org.springframework.cloud:spring-cloud-starter-loadbalancer
                configuaration
                    ++@EnableDiscoveryClient  on Application class

                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
                    eureka.instance.prefer-ip-address=true
                    eureka.client.initialInstanceInfoReplicationIntervalSeconds=5
                    eureka.client.registryFetchIntervalSeconds=5
                    eureka.instance.leaseRenewalIntervalInSeconds=5
                    eureka.instance.leaseExpirationDurationInSeconds=5

                    spring.cloud.loadbalancer.ribbon.enabled=false

            in.bta:bta-txns
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
                    ++ org.springframework.cloud:spring-cloud-starter-loadbalancer
                configuaration
                    ++@EnableDiscoveryClient  on Application class

                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
                    eureka.instance.prefer-ip-address=true
                    eureka.client.initialInstanceInfoReplicationIntervalSeconds=5
                    eureka.client.registryFetchIntervalSeconds=5
                    eureka.instance.leaseRenewalIntervalInSeconds=5
                    eureka.instance.leaseExpirationDurationInSeconds=5

                    spring.cloud.loadbalancer.ribbon.enabled=false

            in.bta:bta-statement
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
                    ++ org.springframework.cloud:spring-cloud-starter-loadbalancer
                configuaration
                    ++@EnableDiscoveryClient  on Application class

                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
                    eureka.instance.prefer-ip-address=true
                    eureka.client.initialInstanceInfoReplicationIntervalSeconds=5
                    eureka.client.registryFetchIntervalSeconds=5
                    eureka.instance.leaseRenewalIntervalInSeconds=5
                    eureka.instance.leaseExpirationDurationInSeconds=5

                    spring.cloud.loadbalancer.ribbon.enabled=false    

        Step 3: Implement API Gateway Design Pattern
            in.bta:bta-gateway
                dependencies
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-starter-api-gateway
                    org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
                    org.springframework.cloud:spring-cloud-starter-loadbalancer
                configuaration
                    @EnableDiscoveryClient          on Application class

                    spring.application.name=gateway
                    server.port=9999

                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
                    eureka.instance.prefer-ip-address=true
                    eureka.client.initialInstanceInfoReplicationIntervalSeconds=5
                    eureka.client.registryFetchIntervalSeconds=5
                    eureka.instance.leaseRenewalIntervalInSeconds=5
                    eureka.instance.leaseExpirationDurationInSeconds=5

                    spring.cloud.gateway.discovery.locator.enabled=true
                    spring.cloud.gateway.discovery.locator.lower-case-service-id=true
                    
            in.bta:bta-discovery
            in.bta:bta-profiles
            in.bta:bta-txns
            in.bta:bta-statement
                  
        Step 4: Implement Distributed Tracing Design Pattern
              in.bta:bta-discovery
              
              in.bta:bta-gateway
                dependencies
                    ++org.springframework.boot:spring-boot-starter-actuator
                    ++org.springframework.cloud:spring-cloud-starter-sleuth
                    ++org.springframework.cloud:spring-cloud-starter-zipkin : 2.2.8.RELEASE
                
                configuaration
                    logger.level.org.springramework.web=debug
                    management.endpoints.web.exposure.include=*
           
            in.bta:bta-profiles
                dependencies
                    ++org.springframework.boot:spring-boot-starter-actuator
                    ++org.springframework.cloud:spring-cloud-starter-sleuth
                    ++org.springframework.cloud:spring-cloud-starter-zipkin : 2.2.8.RELEASE
                
                configuaration
                    logger.level.org.springramework.web=debug
                    management.endpoints.web.exposure.include=*

            in.bta:bta-txns
                dependencies
                    ++org.springframework.boot:spring-boot-starter-actuator
                    ++org.springframework.cloud:spring-cloud-starter-sleuth
                    ++org.springframework.cloud:spring-cloud-starter-zipkin : 2.2.8.RELEASE
                
                configuaration
                    logger.level.org.springramework.web=debug
                    management.endpoints.web.exposure.include=*

            in.bta:bta-statement
                dependencies
                    ++org.springframework.boot:spring-boot-starter-actuator
                    ++org.springframework.cloud:spring-cloud-starter-sleuth
                    ++org.springframework.cloud:spring-cloud-starter-zipkin : 2.2.8.RELEASE
                
                configuaration
                    logger.level.org.springramework.web=debug
                    management.endpoints.web.exposure.include=*

            tracing-service
                zipkin-server
                    https://search.maven.org/remote_content?g=io.zipkin&a=zipkin-server&v=LATEST&c=exec 
                    
                    java -jar zipkin-server.jar

        Step 5: Implement Circuit Breaker Design Pattern
            in.bta:bta-discovery  
            in.bta:bta-gateway
            in.bta:bta-profiles
            in.bta:bta-txns
                dependencies
                    ++org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j
                
                configuaration
                    resilience4j.circuitbreaker.configs.default.registerHealthIndicator=true
                    resilience4j.circuitbreaker.configs.default.ringBufferSizeInClosedState=4
                    resilience4j.circuitbreaker.configs.default.ringBufferSizeInHalfOpenState=2
                    resilience4j.circuitbreaker.configs.default.automaticTransitionFromOpenToHalfOpenEnabled=true
                    resilience4j.circuitbreaker.configs.default.waitDurationInOpenState= 20s
                    resilience4j.circuitbreaker.configs.default.failureRateThreshold= 50
                    resilience4j.circuitbreaker.configs.default.eventConsumerBufferSize= 10

            in.bta:bta-statement
               dependencies
                    ++org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j
                
                configuaration
                    resilience4j.circuitbreaker.configs.default.registerHealthIndicator=true
                    resilience4j.circuitbreaker.configs.default.ringBufferSizeInClosedState=4
                    resilience4j.circuitbreaker.configs.default.ringBufferSizeInHalfOpenState=2
                    resilience4j.circuitbreaker.configs.default.automaticTransitionFromOpenToHalfOpenEnabled=true
                    resilience4j.circuitbreaker.configs.default.waitDurationInOpenState= 20s
                    resilience4j.circuitbreaker.configs.default.failureRateThreshold= 50
                    resilience4j.circuitbreaker.configs.default.eventConsumerBufferSize= 10

        Step 6: External Configuaration Design Pattern
            inTheWorkSpace> md btconfigrepo
                //and then create these files in this directory
                    // gateway.properties
                    // profiles.properties
                    // txns.properties
                    // statement.properties
                    // move the content of 'application.properties' of each microservice into these respective files
                    
                inTheWorkSpace> cd btconfigrepo
                inTheWorkSpace\btconfigrepo> git init           
                inTheWorkSpace\btconfigrepo> git add .
                inTheWorkSpace\btconfigrepo> git commit -m "all service properties"
            
            in.bta:bta-discovery
            in.bta:bta-config
                dependencies
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-config-server
                    org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
                
                configuaration  
                    @EnableDiscoveryClient
                    @EnableConfigServer             on Application class

                    spring.application.name=config
                    server.port=9090

                    spring.cloud.config.server.git.uri=file:///local/git/repo/path

                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
                    eureka.instance.prefer-ip-address=true
                    eureka.client.initialInstanceInfoReplicationIntervalSeconds=5
                    eureka.client.registryFetchIntervalSeconds=5
                    eureka.instance.leaseRenewalIntervalInSeconds=5
                    eureka.instance.leaseExpirationDurationInSeconds=5
            
            in.bta:bta-gateway
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-bootstrap
                    ++ org.springframework.cloud:spring-cloud-config-client

                configuaration - bootstrap.properties
                    spring.cloud.config.name=gateway
                    spring.cloud.config.discovery.service-id=config
                    spring.cloud.config.discovery.enabled=true
                    
                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/                    
            
            in.bta:bta-profiles
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-bootstrap
                    ++ org.springframework.cloud:spring-cloud-config-client

                configuaration - bootstrap.properties
                    spring.cloud.config.name=profiles
                    spring.cloud.config.discovery.service-id=config
                    spring.cloud.config.discovery.enabled=true
                    
                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/   

            in.bta:bta-txns
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-bootstrap
                    ++ org.springframework.cloud:spring-cloud-config-client

                configuaration - bootstrap.properties
                    spring.cloud.config.name=txns
                    spring.cloud.config.discovery.service-id=config
                    spring.cloud.config.discovery.enabled=true
                    
                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/   

            in.bta:bta-statement
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-bootstrap
                    ++ org.springframework.cloud:spring-cloud-config-client

                configuaration - bootstrap.properties
                    spring.cloud.config.name=statement
                    spring.cloud.config.discovery.service-id=config
                    spring.cloud.config.discovery.enabled=true
                    
                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/   

            

        Case Study - D2H Consumer Application
        ------------------------------------------------------

            Mono1Lytic Application High Level Requirements
            1. a D2h consumer can register or edit his detials
            2. a registered cosumer can choose his subscription to contain or not to contain various TV channels
            3. A d2h administrator can add or modify the channel detials like channelId, channelName, monthlyRate ..etc.,
            4. a registered consumer must be able to receive a monthly invoice for his subscriptions for that calander month.
            5. a registered consumer must be able pay his invoices 
            6. a registered consumer must be able to acess his older invocies and payment details.

        Decomposition By Domain

            subscriber-service
                1. a D2h consumer can register or edit his detials
                2. a registered cosumer can choose his subscription to contain or not to contain various TV channels
            
            channels-service
                3. A d2h administrator can add or modify the channel detials like channelId, channelName, monthlyRate ..etc.,
            
            invoices-service
                4. a registered consumer must be able to receive a monthly invoice for his subscriptions for that calander month.
                5. a registered consumer must be able pay his invoices 
                6. a registered consumer must be able to acess his older invocies and payment details.

        
        