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

    this keyword can also be sued to call one constructor from another constructor of that class.    

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