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
                API Gateway Design Pattern
                Client Side Componenet Design Pattern

            Observability Design Patterns
                Distributed Tracing Design Pattern
                Log Aggregation Design Pattern

            Cross Cutting Design Patterns
                Discovery Service Design Pattern
                Load Balancing Design Pattern
                Cirucuite Breaking Design Pattern


