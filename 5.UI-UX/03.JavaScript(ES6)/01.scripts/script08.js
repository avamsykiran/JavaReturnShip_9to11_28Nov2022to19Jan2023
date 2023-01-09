
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

