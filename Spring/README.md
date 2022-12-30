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

    Spring Data JPA
    ------------------------------------------------------------------------------------------------

        is a Automated ORM module for SQL databases.

        you declare a repository and the Spring Data JPA will provide the implementation.

        CrudRepository
            |-JpaRepository
                    List<Entity> findAll()
                    Optional<Entity> findById(id)
                    boolean existsById(id)
                    Entity save(Entity entity)
                    void deleteById(id)

        @Entity
        @Table(name="emps")
        public class Employee{

            @Id
            private Long empId;
            private String name;
            private Double salary;
            private LocalDate joinDate;
            private String mailId;

            //constructors, getters and setters , toString .....
        }

        public interface EmployeeRepo extends JpaRepository<Employee,Long> {
            boolean existsByMailId(String mailId);
            Optional<Employee> findByMailId(String mailId);
            List<Employee> findAllByName(String name);

            @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :lb AND :ub")
            List<Employee> getAllEmployeesInSalaryRange(double lb,double ub);
        }


    Spring Web
    ------------------------------------------------------------------------------------------------


        is a spring movuel sued to develop web-mvc and rest-api applications.

        MVC?

            Model View and Controller

            repos    <--entity-->  services   <-model->  controllers <----------REQ------     webClient
                                                            |                                   ↑
                                                            |                                   |
                                                           model                            html+css+js
                                                            |                                   |
                                                            ↓                                   |
                                                           views    --------RESP--------->      |

            in java Servlets were used as controllers and .jsp/.jsf/thymeleaf ..etc., view engines

        Spring offers Single FrontController MVC !

        Single FrontController MVC?

            repos  <--entity-->  services   <-model->  controllers <-model->  FrontController   <---REQ---    webClient
                                                                                    |                            ↑
                                                                                    |                            |
                                                                                model                       html+css+js
                                                                                    |                            |
                                                                                    ↓                            |
                                                                                  views    -----RESP-------->    |

            FrontController ?
                            org.springframework.web.servlet.DispatcherServlet

                            1. receving a request
                            2. extract any data (in the form of request parameters/url parameters/request body) in the request 
                            3. the relevant controller's action method is invoked by passing the extracted data to it.
                            4. after invoking actiuon method a viewName or a ModelAndView is received .
                            5. the relevent view is given the model and is responded to the client.

            Controller ?
                            is a POJO that provides methods called actions.

                            an action method is expected to receive data and return a viewName or ModelAndView object.

                            each controller is annoted as @Controller

                            UrlResolver an interface implemented by SimpleUrlResolver class which is used
                            to map a specific action method to a specific kind of request. 

                            @RequestMapping(value="anyUrl",method=RequestMethod.GET|RequestMethod.POST) is applied
                            on each action method to map a request on basis of its url and request method.

                            @Controller
                            public class DefaultController {

                                @RequestMapping(value="/home",method=RequestMethod.GET)
                                public String homeAction(){
                                    return "index";
                                }
                            }

                            assuming that the web server is running on port number 9999
                            a GET requst raise to the url http://localhost:9999/home url will invoke the above action method.


                            ViewResolver interface implemented by ResourceBundleViewResolver, XmlResourceViewResolver or
                            InternalResourceViewResolver classes.

                            FrontController can use any of these view resolver to map a viewName to a VIEW.

                            Spring boot by default configs InternalResourceViewResolver.

                            InternalResourceViewResolver has two proeprties prefix and suffix which are configuarable in
                            application.properties . As per this the actual view = prefix+viewName+suffix.

                            @RequestMapping
                                @GetMapping
                                @PostMapping
                                @PutMapping
                                @DeleteMapping 

                            @RequestParam           used to extract request parameters in a url
                            @ModelAttribute         used to extract request parameters and fill them in a model object fields.

            Views?
                            is any view engine that can generate an html content to be passed
                            as response to the client.

                            JSP, JSF, Thymeleaf ..etc., are variety of view engines supported by spring web module.
                            
                            For JSP and JSTL:

                                <dependency>
                                    <groupId>org.apache.tomcat.embed</groupId>
                                    <artifactId>tomcat-embed-jasper</artifactId>
                                    <scope>provided</scope>
                                </dependency>
                                <dependency>
                                    <groupId>javax.servlet</groupId>
                                    <artifactId>jstl</artifactId>
                                    <version>1.2</version>
                                </dependency>

                            For Thymeleaf :
                            
                                <dependency>
                                    <groupId>org.springframework.boot</groupId>
                                    <artifactId>spring-boot-starter-thymeleaf</artifactId>
                                </dependency>

