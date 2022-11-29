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




