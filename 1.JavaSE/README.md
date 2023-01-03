Java SE 8
------------------------------------------------------------------------------------

    Lab Setup
        Eclipse IDE
        JDK 1.8
        MySQL

    Java

        Standard Edition
        Enterprise Edition
        Micro/Mobile Edition

        Features:
            1. High level strictly and partially object oriented programming language
            2. Simple
            3. Robust
            4. Distributed
            5. Self-documented
            6. Platform Independent
            7. Archetecture Neutral
            8. Multi-Threaded

        Characteristicts:
            case sensitive
            {} to represent a block of statements
            ';' statement termination


        Tokens:

            Identifiers

                    is a name given to variable/user-defined data type/method ...etc.,

                    Naming Convention

                        all names of variables/object or methods must start and continue in loser case
                        and from the second word onwards we follow init-caps.

                            width
                            widthOfBox

                            print()
                            printData()
                            toString()

                        all names of user-defiend data types like classes,interfaces, enums ..etc are
                        expected to be init-caps.

                            Exception
                            InputException
                            ArrayIndexOutOfBoundsException

                        all names of constants must be capitals and '_' underscore is used to
                        sperae words.

                            PI
                            MAX_LIMIT
                            MIN_LIMIT

            Keywords

            Operators

                    Binary
                        Arithetic           +,-,*,/,%
                        Assignment          =,+=,-=,*=,/=,%=
                        Relational          ==,<,>,<=,>=,!=
                        Logical             &&, ||, !
                        
                    Ternary                 cond ? true_exp : false_exp 

                                            int greater = a>b?a:b;
                    
                    Unary                   -
                                            ++
                                            --

            Comments
                    line-end            //
                    para/block          /*    */

            Literals

                    c = 2 * 3.14 * r;

                        c,r         identifiers
                        =,*,;       operators
                        2,3.14      Literals

                    double final PI = 3.14;
                    c = 2 * PI * r;

                        c,r,PI      identifiers
                        =,*,;       operators
                        2           Literals

                Integer Literals                    
                        Decimal Numeric System (0-9)                        12,67,9000      19_26_782
                        Octal Numeric System   (1-8)                        01,066,087
                        Hexa Decimal Numeric System (0-9,A,B,C,D,E,F)       0x11A

                Floating Point Literals                                     
                        Decimal Numeric System (0-9)                        3.14
                Character Litarals                  '$'
                String Litarals                     "hello"
                Boolean Literals                    true,false
                Reference Literals                  null

        Data Types

            Premitive
                byte            
                short
                int
                long
                double
                float
                boolean
                char

            User Defined

                class
                absctract class
                nested class
                inner class
                enum
                interface
                annotation

            String      is used to represent strings and is a pre-defiend class from java.lang package.

        int x;  //declaration of variable 'x' of type int
        int y=10; //initialization of variable 'y' of type int with value 10
        x=56;   //assignment 

        varable scope:
            local variable / method argument or param
            field

                    class Circle {
                        int radius;     //field or data member

                        public void setRadius(int r){ // r is a method param or arg
                            radius = r;
                        }

                        public double getDiameter(){
                            double dia = 2*radius;  //dia is a local variable
                            return dia;
                        }
                    }

        control structures

            Selective Control Structures / Decision Making Statements

                    simple if
                                if(cond){
                                    //statements...
                                }
                    if..else
                                if(cond){
                                    //statements_if_true...
                                } else {
                                    //statements_if_false...
                                }
                    if ladder
                                if(cond1){
                                    //statements_if_cond1_true...
                                }else if(cond2){
                                    //statements_if_cond2_true...
                                }if(cond3){
                                    //statements_if_cond3_true...
                                } else {
                                    //statements_if_all_cond_false...
                                }

                    nested if

                                if(cond){
                                    if(cond2){
                                        ...........
                                    }
                                }

                    swtich

                            switch(varOrExp){
                                case val1:
                                    statement_if_var_equals_val1;
                                    break;
                                case val2:
                                    statement_if_var_equals_val2;
                                    break;
                                case val3:
                                    statement_if_var_equals_val3;
                                    break;
                                default:
                                    statemtns_if_var_equals_non_of_the values
                                    break;
                            }

            Iterative Control Structures / Loops

                    while
                            is a pre-check undefinite loop;

                            while(cond){
                                //looping statements
                            }

                    do..while

                            is a post-check undefinite loop

                            do {
                                //looping statments
                            }while(cond);

                    for
                            is a pre-check definite loop

                            for(int i=0;i<n;i++){
                                //do something
                            }

                    for..each / enhanced for (jdk 1.5)

                            int nums[] = {1,2,3,4,5,6,7,8,9,10};

                            for(int i=0;i<nums.length;i++){
                                System.out.println(nums[i]);
                            }

                            for(int num : nums){            // for each num in nums
                                System.out.println(num);
                            }

            Non-Conditional Control Structures

                    break
                    continue
                    return


                public void pickPrimes(int lb,int ub){

                    if(lb>ub){
                        System.out.println("Invalid boundaries");
                        return;
                    }

                    for(int i=lb;i<=ub;i++){
                        int factorsCount=2;
                        
                        for(int j=2;j<=i/2;j++){
                            if(i%j==0){
                                factorsCount++;
                                break;
                            }
                        }

                        if(factorsCount==2){
                            System.out.println(i);
                        }
                    }                        
                }

    Language         Standard Input         Standard Output     Standard Error
    -----------------------------------------------------------------------------------
    C                   stdin                   stdout              stderr
    c++                 cin                     cout                cerr
    java                System.in               System.out          System.err


    assignment#1
    ----------------------------------------------------------------------------------------
    Accept the scores of maths,physics and computer science and compute
    the total, average and grade where the grade is A+ if avg is aboe 90 else grade is
    B+ if the avg is between 89 and 75 else C if avg between 74 and 35 else grade is 'FAIL'.

    Object Oriented Programming
    ------------------------------------------------------------------------------------------

        Strutured Programming
        Procedure Orietned Programming
        Object Orietned Programming

            Class           is a user defined data type.
                            is used to represent an entity.
                            in terms of its properties as fields and behaviours as methods.

            Object          is a variable of class-type.

            Encapsulation   or data-hiding, is a way to provide an indirect access
                            to the fields and methods of a class .

            Inheretence     is a way of creating a new class from an existing class.

                            the existing class is called super class.
                            the inhereted class is called sub class.

                            super <----- sub                        single inheretence
                            super <----- sub1 <-----sub2            multi-level inheretence
                            super | <----- sub1                     hirarichal inheretence
                                  | <----- sub2                                

                            super1 <-----|                          multiple inheretence
                                         |<-----sub
                            super2 <-----|

                            Employee    (empNo,name,basic)          Hybrid inheretence
                                ↑
                            -----------------
                            ↑               ↑
                            Manager         ContractEmployee
                              (+ allowence)         (+ contractDuration)
                            ↑
                            Director
                                (+ shares)

            Polymorphisim   is about having two or more methods with the same name.

                            eat an apple
                                1. Wash
                                2. Cut
                                3. Chew and swallow each piece

                            eat an iceCream
                                1. lick and swallow

                            overloading
                                the same entity has the behaviour but different implementation
                                for different inputs.

                                two methods are said to be overlaoded if they belong to the smae class
                                or to a super and a sub class and have the same name but differ in 
                                the parameters type or count or order.

                                class Human{
                                    Energy eat(Apple apple){

                                    }

                                    Energy eat(IceCream icecream){

                                    }
                                }

                            overriding

                                similar entities has the same behaviour but different implementation.

                                two method are said to be overriden if they belong to a super and a sub class 
                                and have the same signature (returntype methodName(Parmas)).
                                
                                class Animal {
                                    Energy eat(Apple apple){
                                        //bites and chews and swallows
                                    }
                                }
                                
                                class Human extends Animal {
                                    Energy eat(Apple apple){
                                        //wash and cut and chew and swallow
                                    }
                                }

            Abstraction         is also known as behaviour hiding. 

                                    abstract methods, abstract classes and interfaces.

    Classes, Objects and Encapsulation In Java
    ---------------------------------------------------------------------------------------

        class <ClassName> {
            //list of fields
            //list of methods
        }

        encapsualtion is acheved through access specifiers/access qualifiers.
        access specifiers will control the visibility.

        default
        private
        protected
        public

            package p1;
                class C1{
                    int defaultX;
                    private int privateX;
                    protected int protectedX;
                    public int publicX;

                }
                class C2{
                    //we can access defaultX and publicX only
                    //protectedX and privateX are not visible here.
                }
                class C3 extends C1{
                    //we can access defaultX and publicX and protectedX only
                    //privateX is not visible here.
                }

            package p2;
                class C4 extends C1{
                    //we can access publicX and protectedX only
                    //defaultX and privateX are not visible here.
                }
                class C5{
                    //we can access publicX only
                    //defaultX and privateX and protectedX are not visible here.
                }
        
        getters and setters are used to provide indirect access to invisible fields.

        setter is a method used to change the value of a field
        and getter is a mehtod used to return the value of a field

        class Student {
            private int rollNum;

            public void setRollNum(int x){
                rollNum=x;
            }

            public int getRollNum(){
                return rollNum;
            }
        }
    
        Object are reference type in java.

        int x = 45;                        x [  45  ]
        int y = x;                         y [  45  ]

        y++; // value of x is 45 and value of y=46          y [  46  ]
            // x and y are value types.

        class Rectangle{
            private int length;
            private int breadth;

        }

        Rectangle r1;                       r1  [   null  ]        
        r1 = new Rectangle();               r1  [     <---]---------------------|------- { length [  ]  breadth  [   ]}
                                                                                |
        Rectangle r2 = r1;                  r2  [     <---]---------------------|

        Rectangle r3;
        r3 = new Rectangle();               r3  [     <---]----------------------------- { length [  ]  breadth  [   ]}

        Constructor is a special method of a class used for initialization, or to execute immidiately after
                        allocating an object.
                    in java a constructor must have the same name as that of the class name and
                    must not return any value.
                    a class can have any number of constructors as long as they differ in their params.

                        constructor
                                with no paramaters                          default constructor
                                with parameters                             paramatrized constructor
                                with the smae class object as param         copy constructor

            class Rectangle{
                private int length;
                private int breadth;

                Rectangle(){
                    length=5;
                    breadth=5;
                }

                Rectangle(int x){
                    length=x;
                    breadth=x;
                }

                Rectangle(int x,int y){
                    length=x;
                    breadth=y;
                }

                Rectangle(Rectangle r){
                    length=r.length;
                    breadth=r.breadth;
                }

                public int getArea(){
                    return length*breadth;
                }

            }            

            Rectangle r1 = new Rectangle();
            System.out.println(r1.getArea());       //25
            Rectangle r2 = new Rectangle(10);
            System.out.println(r2.getArea());       //100
            Rectangle r3 = new Rectangle(10,5);
            System.out.println(r3.getArea());       //50
            Rectangle r4 = new Rectangle(r2);
            System.out.println(r4.getArea());       //100


            class Student{
                private int rollNum;
                private String name;
                private double fee;
            }

            Student s = new Student(); //no errors, because the student has no constructors, it will added a defualt constructor
                                        //by the compiler

            
            class Employee{
                private int empId;
                private String name;
                private String designation;

                public Employee(int r,String n,String d){
                    //.............
                }
            }

            Employee e = new Employee(); //is an error

    'this' keyword
    ----------------------------------------------------

        this    is a reference to the current object for a method.
            
            class Rectangle{
                private int length;
                private int breadth;

                Rectangle(){
                    this.length=5;
                    this.breadth=5;
                }

                Rectangle(int side){
                    this.length=side;
                    this.breadth=side;
                }

                Rectangle(int length,int breadth){
                    this.length=length;
                    this.breadth=breadth;
                }

                Rectangle(Rectangle r){
                    this.length=r.length;
                    this.breadth=r.breadth;
                }

                public int getArea(){
                    return this.length*this.breadth;
                }

            }            

    this keyword can also be used to call one constructor from another constructor of that class.    

            class Rectangle{
                private int length;
                private int breadth;

                Rectangle(){
                    this(5);
                }

                Rectangle(int side){
                    this(side,side);
                }

                Rectangle(int length,int breadth){
                    this.length=length;
                    this.breadth=breadth;
                }

                Rectangle(Rectangle r){
                    this(r.length,r.breadth);
                }

                public int getArea(){
                    return this.length*this.breadth;
                }

            }


    classes play a variety of roles
        models              represents a domain entity like Employee,Vehicle,Student ..etc.,
        daos                represents persistence logic (database operations)
        services            represents bussiness logic (validations,computations...etc)
        ui's                represents presentation logic (accepting commands and data/displaying info or messages)


    'static' keyword
    -------------------------------------------------------------------------

        static field

            static fields are called class-variables.
            non-static fields are called instance-variables. (instance means object)

            each object of a class has a seperate copy of instance-variables and
            all the object of a class share the same copy of class-variables.

        static method
            static methods are opwned by the class not by the object, and are called on the class not on the object.
            static methods do not have current object and hence can not use 'this'.
            static methods can access static members directly but can not access non-static members directly.

        *** if a static method is returning the object of the smae class, then it is called a factory method.

        static block

            static {
                //one class can have multiple static blocks but are treated as one.
                //the static block gets executed when the class is accessed for the first time.
                //accessing a class means
                //      1. declare an object to the class or
                //      2. allocate an object to the class or
                //      3. call a static method of the class or
                //      4. access a static field of the class
                // a static block execute once and once per class in an application.
            }

        static class

            it is possible to create a class inside another class.

            that inner class if marked static it is called nested class.

                class TopLevelClass {

                    class InnerClass{

                    }

                    static class NestedClass{
                        
                    }
                }


    'final' keyword
    -------------------------------------------------------------------------

        final field or final local-variable
            those fields or local-variables behave as constants.

        final method
            those methods can not be overriden.

        final class
            those classes can not be inhereted.

Inheretence and Polymorphsism in java
------------------------------------------------------------------------------------            

    'extends' keyword is used to inhereit a class from another.
    'super' keyword is used to call super class constructor from a sub class constructor.
    'super' keyword can also be used call an overriden copy of the super class method from the sub class.
    java classes do not support multiple inheretence.
    
                             Employee    (empNo,name,basic)         
                                ↑
                            -----------------
                            ↑               ↑
                            Manager         ContractEmployee
                              (+ allowence)         (+ contractDuration)
                            ↑
                            Director
                                (+ shares)

    1. Default constructors are chained in inheretence.
    2. Type Casting

            //implicit type casting

            short s = 12;
            int i = s;
            long l = i;
            double d = l;

            char ch = 'a';
            int x = ch;

            //explicit type casting
            int y=65;
            char ch1=(char)y;

            double a = 22.777;
            int b = (int)a;

            //implicit type casting on classes
            //a super class ref can hold a sub class object.
            
            Employee e1 = new Manager();
            Employee e2 = new Director();
            Employee e3 = new ContractEmployee();
            Manager m1 = new Director();
            Manager m2 = new ContractEmployee(); //no, not possible

            //a super class object can not be held by a sub class ref.
            ContractEmployee ce1 = new Employee(); //no, not possible

            //explicit type casting on classes

            Manager mgr1 = (Manager) e1;
            Manager mgr2 = (Manager) e2;
            Manager mgr3 = (Manager) e3; //no, not possible, throws ClassCastException

            'instanceof' operator used to check if an object is an instacne of a class.

Abstract Classes
-----------------------------------------------------------------

    An abstract class can not have objects allocated.
    'abstract' keyword is used to mark a class as abstract.

    Person      name,dob,bloodGroup,height,weight,contatctDetials
        ↑
        |- Student                 admno,fee,scores
        |- Principal               staffId,salary
        |- TeachingStaff           staffId,salary,subject
        |- NonTeachingStaff        staffId,designation

    Person need not be instantiated ever. Hence we can mark it abstract.

    public abstract class Person {
        //.................
    }

    public class Student extends Person{
        //............
    }

Abstract Function
----------------------------------------------------------------------

    'abstract' keyword is used to mark a method as abstract.
    Method having no clear implementation are marked as abstract.
    If a class has atlest one abstract function, then the class must be marked abstract.
    When abstract classes are inhereted , then the sub class must override and implement
        all the abstract methods in that super abstract class.
        on failing which the sub-class also must be marked abstract.

        public abstract class Shape {

            private int[] sides;

            public Shape(int numberOfSides){
                this.sides = new int[numberOfSides];
            }

            public int getPerimeter(){
                int p =0;
                for(int side : sides){
                    p+=side;
                }
                return p;
            }

            public abstract int getArea();
        }

Interfaces
-----------------------------------------------------------------------

    an interface is a used defiend data type that represents a 'role'.
    an interface can have final fields, methods, static methods and abstract emthods.
    an interface can not have fields and constructors.
    an interface can not have an object allocated.
    one interface can inherit only on other interface.
    one class can inherit more than one interfaces. (interface to class - multiple inheretence is possible)


    'extends' keyword is used to inherit a class from a class or a interface from a interface.
    'implements' keyword is used to inherit a class from one or more interfaces.


        Animal                              Bird
         ↑                                   ↑ 
        -------------                   ---------------------
        |           |                   |                   |
        MaleAnimal  FemaleAnimal       MaleBird            FemaleBird


            Father         
            Mother          giveBirth()
            Sibling

            MaleAnimal implements Father,Sibling
            FemaleAnumal implements Mother,Sibling
            
            MaleBird implements Father,Sibling
            FemaleBird implements Mother,Sibling

    How do you choose between an abstract class and an interface ?

            abstract class can have fields and interface can not.
            abstract classes (as they are still classes) can not support multiple inheretence
                    where as interfaces can.

            along with the abstract method, do we have fields??
                             |
                             |
                NO ------------------------ YES 
                 |                            |- we will choose an abstract class
                 |
                 |- we will choose interface (as we will have the advantage of multiple inheretence)

*** keywords 'abstract' and 'final' are contradictory and hence can not be used togather.

Case Study - Loan4u
-----------------------------------------------------------------------------------

    This org offers a varity of loans.
    For every loan irrespective of the loan varaity, we have to record
        the loan amount, rate of interest (annual) and terms (in months).
    For Personal Loan, we have to record the consumer annual income and profession.
    For Product Loan, we have to record the product name, make and its cost.
    For Vehicle Loan, we have to record the vehicle make and model, insurence amount, insurence period.

    We need to compute the interset and total payable amount in different methods like
        a) simple interest
        b) or EMIs

    public abstract class Loan {
        private double amount;
        private double roi;
        private double terms;

        //constructors and getter and setters...    
    }

    public class PersonalLoan extends Loan{
        private double income;
        private String profession;

        //constructors and getter and setters...    
    }
    
    public class ProductLoan extends Loan{
        private String productName;
        private double productCost;

        //constructors and getter and setters...    
    }
    
    public class VechicleLoan extends Loan{
        private String makeAdModel;
        private String insurenceDetails;

        //constructors and getter and setters...    
    }

    public interface LoanService{
        double getInterest(Loan loan);

        public default double getPayableAmount(Loan loan){
            return getInterest(loan) + loan.getAmount();
        }
    }

    public class SimpleInterest implements LoanService{
        @override
        public double getInterest(Loan loan){
            return //simple interst fomula; 
        }
    }

    public class EMI implements LoanService{
        @override
        public double getInterest(Loan loan){
            return //emi formula
        }
    }

Java Standard Libraries
----------------------------------------------------------------------------------------------------

    java.lang               Wrappers,Multi-Thread,Exception Handling 
    java.time               Date Time API
    java.util               Utility Class, Generics, Collections
    java.util.function      Functional Interfaces and Lambda Expressions
    java.util.stream        Streams API
    java.util.regex         Regular Expressions
    java.io                 IO Streams
    java.nio                Novel/NonBlocking IO Streams
    javax.sql               JDBC - Java Databae Connectivity

java.lang               Wrappers,Multi-Thread,Exception Handling 
-----------------------------------------------------------------------------------------------------

    is an implict default package for every java program.

    Object          is the default super class.
                        boolean equals(Object obj);     //   obj1.equals(obj2)
                        int hashcode();
                        String toString();

    Class           
    System          represent the host OS.
                        all fields and method here are static.
                        in      java.io.InputStream     standard input (Keyboard)
                        out     java.io.PrintStream     standard output (VDU - Monitor)
                        err     java.io.PrintStream     standard error  (VDU - Monitor)

                        void exit(int);
                        void gc();

    Math            represent a lot of mathematical operations. And all these mehtods are static.

    String          is a class used to represent a group of characters called strings.

                    string objects and string literals.

                    String str1 = "Hello World";
                    String str2 = "Hello World";
                    String str3 = "Hello";

                    str1,str2 and str3 are all string objects
                    "Hello World" and "Hello" are string literals.

                    Every string literal is a string object.
                    All string objects are maintained in a isolated memory block called 'String Pool'.
                    This is to avoid reallocating same strings.
                    Which means str1 and str2 are two names of the smae string objects allocted.

                    The string objects are immutable. Which means that a string can not be
                    mofied in its place.

                    str3 = str3 +" Vamsy"; 

                    str3 is now "Hello Vamsy" but in the string pool we will have
                    both "Hello" and "Hello Vamsy" and str3 is redirected to point "Hello Vamsy"
                    but the "Hello" is still there without modification.

                    this makes string manipulation highly costly. Hence direct string manipulation
                    are to be avoided.

    StringBuilder
    StringBuffer        Both stringbuffer and stringbuilder are classes
                        propsoed to support string manipulations

                        1. load a string into StringBuffer or StringBuilder
                            2. do as many manipulations as we want
                                3. extract the modfiied string from StringBuffer or StringBuilder.
    
            Wrapper Classes 
    Integer
    Short
    Long
    Double
    Flaot
    Character
    Boolean
    Void

                        int x = 45;
                        Integer intObj = new Integer(x);    //Boxing
                        int y = intObj.value();             //Unboxing      < JDK 1.5

                        int a = 67;
                        Integer intObj2 = a;                //Auto-Boxing
                        int b = intObj2;                    //Auto-Unboxing     

    assignment:
            accept a string and find out how many words, characters, digits and special characters
            we have in that string.

                String str = "This is Vamsy. And you can call me at 9052224753. This is a testing string..";

            package com.java.loan.varity;
            
            public class App03 {
                public static void main(String[] args) {
                    String str = "Java Python Scala 98765 *&";

                    int count = str.split(" ").length;
                    int charCount = str.length();
                    int digits = 0;
                    int spCount = 0;

                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt(i) >= 48 && str.charAt(i) <= 57)
                            digits++;
                        if (!Character.isDigit(str.charAt(i)) && !Character.isLetter(str.charAt(i))
                                && !Character.isWhitespace(str.charAt(i))) {
                            spCount++;
                    }
                
                    System.out.println("Number of words in a string : " + count);
                    System.out.println("Number of Charater : " + charCount);
                    System.out.println("Total Number of Digits
                }
            }

Exception Handling
-----------------------------------------------------------------------------------------------------

    java.lang.Throwable     (interface)
            |
            |
        ----------------------
        |                    |
    java.lang.Exception     java.lang.Error
        |
    java.lang.RuntimeExcetpion


    CHECKED EXCEPTIONS          All sub-classes from Exception class including Exception class

    UN-CHECKED EXCEPTIONS       All sub-classes from RuntimeException class including RuntimeException class

    Un-Checked Exceptions are expected to be avoided. they are not supposed to be handled. That is the
    reason that compiler do not check if these exceptions are handled or not and hence the name unchecked.

        public int divide(int a,int b){
            return a/b;
        }

        here an ArithmeticException is possible.

        public int divide(int a,int b){
            return b!=0? a/b : 0;
        }

    Checked Exceptions can not be avoided but msut be handled using a try..catch statement.
    A compiler will not allow the compilaiton if these exceptions are not handled hence the name checked.

    try{
        //statements that may raise a checked exception
    }catch(ExceptionType1 exceptionObj){
        //alkternate code 1 
    }catch(ExceptionType2 exceptionObj){
        //alkternate code 2
    }catch(ExceptionType3 exceptionObj){
        //alkternate code 3
    }finally{
        //code written here gets executed at any cost.
    }

    try{
        //statements that may raise a checked exception
    }catch(ExceptionType1 | ExceptionType2 exceptionObj){
        //alkternate code for exception type1 and type2
    }catch(ExceptionType3 exceptionObj){
        //alkternate code 3
    }finally{
        //code written here gets executed at any cost.
    }

    User defined exceptions are intended to create our own exception. We can create a class and extend it from
    eithe Exception or RuntimeException for a checked or a unchecked exception respectivly.

    user defined exceptions are raised uwing 'throw' keyword.
    to transfer an exception from one method to its caller method 'throws' keyword is used.

Assignment - LoanAdvisor
----------------------------------------------------------------------------------------------------

    package com.cts.loanadvisor.model

    public class Loan{

        private double principal;           //ACCEPTED FROM USER
        private double roi;                 //ACCEPTED FROM USER
        private double numberOfEmis;        //ACCEPTED FROM USER
        private double emi;                 //COMPUTED
        private double totalPayableAmount;  //COMPUTED emi*numberOfEmis
        private double totalPayableInterest;//COMPUTED totalPaaybleAmount-principal

        //constructors and gettrs and setters.
    }

    package com.cts.loanadvisor.service

    public class LoanService{
        
        public void compute(Loan loan){
            //all validations and computations
            //principal or roi or numberOfEmis can not be negative
            //roi must be between 0.1 to 1.0
            //raisxe respective exception if needed
        }
    
    }
     
    package com.cts.loanadvisor.ui;

    public class LoanAdvisorApp{
        public static void main(String a[]){
            //we need accept an option to continue or not
            //we have to run the below steps as long as the user wants to continue..
                //1. accept the p,t and r
                //2. display the emis and other computed details.
                //3. display err if any
        }
    }

Multi-Threading
-----------------------------------------------------------------------------------------------------
    java.lang.Runnable  (interface)     void run();
        |
    java.lang.Thread     (class)        Thread()
                                        Thread(Runnable);
                                        Thread(String name);
                                        Thread(String name,Runnable);

                                        void start();
                                        String getName();
                                        void setName(String name);

                                        static void sleep(long);
                                        static Thread currentThread();

java.time (>1.8)
-----------------------------------------------------------------------------------------------------

    LocalDate           now(), of(year,Month,date)
    LocalTime           now(), of(hour,min,sec)
    LocalDateTime       now(), of(year,Month,date,hour,min,sec)
    ZonedDateTime       now(ZoneId)

    Period    .between(startDate,endDate)
    Duration  .between(startTime,endTime)  

    DateTimeFormatter

Collections
-----------------------------------------------------------------------------------------------------

    Generics        allows us to create ADTs in java.
                    ADT - Abstract Data Types.

                    search algorithm on arrays

                    class DataAlgorithm<T>{
                        public void search(T[] array,T searchElement){
                            for(int i=0;i<=array.length;i++){
                                if(array[i].equals(searchElement)){
                                    System.out.println("Element found @ "+i);      
                                    break;
                                }
                            }

                            System.out.println("Element is not found");
                        }
                    }

                    DataAlgorithm<Employee> da1 = new DataAlgorithm<>();
                    da1.search(empArray,empToFind);

                    DataAlgorithm<String> da2 = new DataAlgorithm<>();
                    da2.search(strArray,strToFind);

    Java Collections are java's approach to Data Structures.

        java.util.Collection (interface)        add(ele),remove(ele),contains(ele),isEmpty(),size(),stream()
            |
            |- Set (interface)                  represents a non-linear data structure
            |   |
            |   |- HashSet (class)
            |   |- LinkedHashSet (class)
            |   |
            |   |- SortedSet (interface)
            |   |   |- TreeSet (class)
            |
            |- List (interface)                 represents a linear data structure
            |   |
            |   |- LinkedList (class)
            |   |- ArrayList (class)
            |   |- Vector (class)


            Set                         List
                has no index                index exists and index based operations are supported.
                no duplicates allowed       duplicates are allowed.
                single null is allowed      multiple nulls are allowed.


            Set Implementations
                HashSet                 does not promise any retrival order.
                LinkedHashSet           elements are retrived in the insertion order.
                TreeSet                 elements are retrived in the sorted order.

            List Implementations
                Vector                  growable array, synchronized
                ArrayList               growable array, not synchronized
                LinkedList              doubly linked list algorithm

            java.lang.Comparable        (default comparision strategy)
                    public abstract int compareTo(ele)

            java.util.Comparator        (customized comparision strategy)
                    public abstract int compare(ele1,ele2)

 Assignment
 ----------------------------------------------------------------------

    An application to accep the detials of a loan like loanAmount,roi and number of emis and firstEmiDate in a 'Loan' class.                
    Use a LoanService to generate the amortization table of the loan and display.

        if number emis are 6

        EMI.Number      dueDate     EMIAmount       InterestComponent   PrincipalComponent
        1               5-Dec-2022  7500            3000                3500
        2               5-Jan-2022  7500            2900                3600

Functional Interfaces and Lambda Expressions
-----------------------------------------------------------------------

    An interface having only one abstract method is called a functional interface.
    To ensure that an interface reamins as funtional interface, it is marked with @FunctionalInterface.

    if the method in a functional interface is
            of no params but returns                then we call it a Supplier
            having params but doestn't return       then we call it a Consumer
            returning boolean                       then we call it a Predicate
            none of the above                       then we call it a Functional

    Significance of functional interfaces is that a functional interface can be 
    implemented using a lambda expression.

    (argList) -> (returnExpression)

    java.util.function.BinaryOperator<Integer> sum = (a,b) -> a+b;

    java.util.function.Consumer<Object> c1 = System.out::println ;
    
Streams API
-------------------------------------------------------------------------------

    a stream is a flow of data.

    OverhaedTank ---|                                                   //stream source             Arrau or List or Set or Map
                    |
                    |
                    ---DirtFilter---|                                   //intermdiate operation
                                    |
                                    |   
                                    --Chlorination--|                   //intermidiate operation
                                                    |
                                                    |
                                                    |
                                                Collect into a Bucket   //stream terminal

    java.util.stream.Stream     stream = Arrays.of(array);
    java.util.stream.Stream     stream = listObj.stream();
    java.util.stream.Stream     stream = setObj.stream();

        a stream once used can not be reused.

            forEach     accepts a consumer and executes the consuemr on each and every value in the stream.
                        terminal operation.

            reduce      accepts a binaryOperator, and excute it on each pair of eles in the stream & finally returns one value.
                        terminal operation.

            filter      accepts a predicate, and returns a new stream contining only thsoe elements that passed the predicate
                        intermidiate operation.

            map         accepts a transformer, and returns a new stream of transformed elements.
                        intermidiate operation.

            collect     is used to collect all the values from a stream into a list or set.
                        terminal operation.

            BinaryOperator<Integer> product = (a,b) -> a*b;

            int[] array = new int[]{1,2,3,4,5};

            Arrays.stream(array).reduce(product);
            
                product(product(product(product(1,2),3),4),5) --------------> 120

IO Streams
--------------------------------------------------------------------------------------------

    java.io
            InputStream
                FileInputStream
                DataInputStream
                ObjectInputStream

            OutputStream
                FileOutputStream
                PrintStream
                DataOutputStream
                ObjectOututStream

            Reader
                InputStreamReader
                BufferedReader
                FileReader

            Writer
                PrintWriter
                FileWriter

            File
            IOException

    java.nio
            Path
            Paths
            Files
            Directories

Multi Layer Archetecture
-------------------------------------------------------------

    database    <---SQL----> [  DAO     <----model----->    SERVICE  <-----model------>   UI  ]  <--> EndUser

        DAO     Data Access Object      Persistence Logic (inserting/updating/deleting/retriveing from db)

        model   that repreent the domain objects to hold the data

        SERVICE                         Bussiness Logic (Validations/Computation/Raising UserDefinedExceptions....)

        UI      User Interface          Presentation Logic (Accepting and displaying .....)


Java Evolution and features:
    https://www.aegissofttech.com/articles/java-8-9-10-11-new-key-features-and-enhancements.html