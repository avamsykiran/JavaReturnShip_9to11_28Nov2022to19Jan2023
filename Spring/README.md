Spring Framework (Spring 5)
-----------------------------------------------------------------------------------

    it is a development platform.

    Modular
    Offers DI
    Interaparable

        Spring Core                                 basic foundation library for all other spring modules (offers DI)
        Spring Bean                                 offers a bean container - BeanFactory
        Spring Context                              offers a bean container - ApplicationContext
        Spring Expression Language (SpEL)           offers an expression language to achive advacned injection.
        Spring AOP                                  offers Aspect Oriented Programming

        Spring Boot                                 offers auto-configuaration and embeded servers
        Spring Data                                 offers ORM - Object Relational Mapping
        Spring Web                                  offers Web MVC and Restful api support
        Spring Security                             offers Authentication and Authorization support
        Spring Test                                 offers support for testing spring apps.
        Spring Batch                                offers batch processing and job secheduling ..etc.,
        Spring WebFlux                              offers responsive programming.
        ...etc.,


    SpringCore,SpringBean and SpringContext and SpEL
    -------------------------------------------------------------------------------------------------------------

        Dependency?

            resource 'a' is being made use of by a resource 'b' then we say b is dependent on a or a is the dependency of b.


            UI  depends on a SERVICE
            a SERVICE depends on a DAO ..etc.,

            class ContactServiceImpl ..... {
                
                //private ContactDao dao = new ContactDAOImpl();
                private ContactDao dao = new ContactDAOJpaImpl();
            }            

        Dependency Injection?

            class ContactServiceImpl ..... {
                
                private ContactDao dao;

                public ContactServiceImpl(ContactDao dao){
                    this.dao = dao;
                }
            }     


            ContactService service = new ContactServiceImpl(new ContactDaoJpaImpl());


        Container?

            is a class that can manage the life cycle of any resource in our application.

            the contaienr can create, supply or destroy the objects needed in our application.
            These object whose lifecycle is managed by the container are called Beans
            and eh classes of the beans are called Components.

        Spring on a whole provides two containers:
            1. BeanFactory      from spring bean
            2. AppliucationContext from spring context

                ApplicationContext supports bean lifecyle on auto-wiring which is not supported by BeanFactory.

        Bean Configuaration?

            is about informing the contaienr , how many componenets do e have?, 
            how many beans di we need for each of those components?, and which
            component is dependent on which other component? ...

            Xml Based Configuration
            Annotation Based Configuaration

                    @Component("beanIdorBeanName")
                        @Service("beanIdorBeanName")
                        @Controller("beanIdorBeanName")
                        @RestConbtroller("beanIdorBeanName")
                        @Repository("beanIdorBeanName")
                        ...etc.,

                    @Service
                    public class BoxService {           //boxService is the bean id

                    }
                    
                    @Service("bs")
                    public class BoxService {           //bs is the bean id

                    }

                    @Configuration
                    @ComponentScan("base.package")
                    public class MyBeanConfiguaration {
                    }

            Java Based Configuaration

                    @Configuration
                    public class MyBeanConfiguaration {

                        @Bean
                        public LocalDate today(){       //LocalDate is the component and 'today' is the bean id
                            return LocalDate.now();
                        }

                        @Bean
                        public Scanner kbin(){          //Scanner is the component and 'kbin' is the bean id
                            return new Scanner(System.in);
                        }
                    }

            Autowiring

                is injecting a matching dependency into a field of a component.
                (injecting a bean into another bean).

                @Component
                public class ClassA{

                }

                @Component
                public class ClassB{
                    
                    @Autowired                      //field injection
                    private ClassA classAObj;

                }

                @Component
                public class ClassC{
                    
                    private ClassA classAObj;

                    @Autorired                          //constructor injection
                    public ClassC(ClassA classAObj){
                        this.classAObj=classAObj;
                    }
                }

                @Component
                public class ClassD{
                    
                    private ClassA classAObj;

                    @Autorired                          //setter injection
                    public void setClassAObj(ClassA classAObj){
                        this.classAObj=classAObj;
                    }
                }

            autowiring byType
                dependecies of a type are mapped to beans of the same type.
                it expects one and only matching bean for this to work.

            autowiring byName
                dependecies are mapped to beans identified by the bean name.
                
                @Qualifer

        External Configuaration

            we can inject values to fiels through '.properties' file.

            @PropertySource("fileName.properties")

            @Value("spEL") ius used to inject a property value into a field

        Bean Scope

            @Scope("singleton|prototype|session|request|global-session")

    Spring Boot
    --------------------------------------------------------------------------------------------       

            is a auto-configuaration module and provides RAD (Rapid Application Development)

            with Spring 5  we get Spring boot 2

            @SpringBootApplication  =   @Configuaration
                                        @PropertySource("application.properties")
                                        @ComponentScan

            Spring Boot application are provided with embeded servers whenever needed.

            Spring Boot Application Execution Flow
                1. ApplicationContext is build along with all scanned componnets and beans.
                2. Execute spring entry points (if any)
                3. Start the embeded server (if any).
                4. it terminates

            Spring Entry points - SpringRunners
                                    |- ApplicationRunner    public abstract void run(ApplicationArgs arg[])
                                    |- CommandLineRunner    public abstract void run(String arg[])

            A spring boot application cna be created in three ways:
                1. Spring Boot CLI                  > springboot init
                2. Spring Boot Initialize tool      https://start.spring.io
                3. Spring Tool Suite - Spring Starter Project Wizard

