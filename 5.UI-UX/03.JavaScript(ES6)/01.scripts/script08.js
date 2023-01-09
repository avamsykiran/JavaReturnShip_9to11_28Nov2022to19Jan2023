
//JavaScriptObjectNotation
let emp1 = {empId:101,name:'Vamsy',sal:70000}; 
console.log(emp1);
emp1.ta=500;
console.log(emp1);

//Constructor Function
function Emp(empId,name,sal){
    this.empId=empId;
    this.name=name;
    this.sal=sal;
}

let emp2 = new Emp(102,"Mangai",78000);
let emp3 = new Emp(103,"Bhuvana",78000);
console.log(emp2);
console.log(emp3);

//Classes
class Employee {
    constructor(empId,name,sal){
        this.empId=empId;
        this.name=name;
        this.sal=sal;
    }

    ta(){
        return this.sal*0.05;
    }
}

let emp4 = new Employee(104,"Anand",78000);
console.log(emp4);
console.log(emp4.ta());

//Inheretence
class Manager extends Employee{
    constructor(empId,name,sal,allowence){
        super(empId,name,sal);
        this.allowence=allowence;
    }

    ta(){
        return this.sal*0.15;
    }   
}

let emp5 = new Employee(105,"Lakshmi",90000);
console.log(emp5);
console.log(emp5.ta());