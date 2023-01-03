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


        Case Study - Budget Tracking Application
        ------------------------------------------------------

            Mono1Lytic Application High Level Requirements
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