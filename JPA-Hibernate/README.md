JPA

    Java Perssitence API  
        javax.persistence (< JDK 15) / (>JDK 16)   jakarta.persistence


    ORM - Object Relational Mapping


                                    OOPs                                            RDBMS
    =============================================================================================================
    Entity-Def                      class                                             Tables
    Entity                          object                                            Records/Rows
    Properties                      fields                                            Field/Column
    Behaviours                      methods                                           -------

    Relationships
        Generalization (isA)        Inheretence                                       
                                    
                                     class Employee {                               SingleTable
                                        private int empId;                             all_emps empid,ename,basic,allw,dur
                                        private String name;
                                        private double basic;                       JoinTable
                                                                                       emps     empid,ename,basic 
                                     }                                                 mgrs     empid,allw
                                     class Manager extends Employee{                   cemps    empid,dur 
                                        private double allowence;
                                     }                                              TablePerClass
                                     class ContractEmployee extends Employee{           emps    empid,name,basic        
                                        private int duration;                           mgrs    empid,name,basic,allw
                                     }                                                  cemps   empid,name,basic,dur

        Assosiation (hasA)
            composition             
                                    class Employee {                                emps    empid,name,sal,dno,stt,dist,state,con
                                        private int empId;                          clients clid,title,dno,stt,dist,state,con
                                        private String name;
                                        private double salary;
                                        private Address address;
                                    }

                                    class Client {
                                        private int clientId;
                                        private String title;
                                        private Address address;
                                    }

                                    class Address {
                                        private String doorNum;
                                        private String street;
                                        private String district;
                                        private String state;
                                        private String country;
                                    }

            aggregation
                one-to-one          
                                    class Employee{                                 emps    empid,name,sal
                                        private int empId;                          accs    accNo,ifsc,empid(FK)
                                        private String name;
                                        private double salary;
                                        private BankAccount salAccount;
                                    }

                                    class BankAccount {
                                        private String accNumber;
                                        private String ifsccode;
                                        private Employee holder;
                                    }

                one-to-many         class Employee{                                 
                many-to-one             private int empId;                          emps    empid,name,sal
                                        private String name;                        skills  skId,title,cid,level,empId(FK)
                                        private double salary
                                        private Set<Skill> skills;
                                    }

                                    class Skill{
                                        private int skillId;
                                        private String title;
                                        private long certificateId;
                                        private CompetencyLevel level;
                                        private Employee owner;
                                    }

                                    enum CompetencyLevel{
                                        BEGINER,PRACTiTIONER,EXPERT;
                                    }

               
            JPA is a ORM specification to automate the object and relational mapping.
            
                jpa is implemented by
                        Hibernate
                        iBates
                        ...etc.,


            EndUser <-->    UI  <----->  SERVICE <-----> DAO <---> JPA <----> Hibernate <-----> JDBC <---> dbDriver <--> DB


            