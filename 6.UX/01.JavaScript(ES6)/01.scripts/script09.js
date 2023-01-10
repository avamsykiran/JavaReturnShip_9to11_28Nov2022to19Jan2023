//Arrays

const separator = "-------------------------------------------------------------------------------------";

let emps = [
    { empId: 101, name: "Vasu", basic: 60000, joinDate: new Date("2022-01-01") },
    { empId: 102, name: "Venky", basic: 80000, joinDate: new Date("2023-01-01") },
    { empId: 103, name: "Vimal", basic: 50000, joinDate: new Date("2022-02-01") },
    { empId: 104, name: "Vinith", basic: 30000, joinDate: new Date("2022-02-01") },
    { empId: 105, name: "Vasundhara", basic: 90000, joinDate: new Date("2022-04-01") },
    { empId: 106, name: "Vijay", basic: 40000, joinDate: new Date("2022-02-01") },
    { empId: 107, name: "Venky", basic: 80000, joinDate: new Date("2022-08-01") },
    { empId: 108, name: "Varun", basic: 20000, joinDate: new Date("2022-11-01") },
    { empId: 109, name: "Vamsy", basic: 70000, joinDate: new Date("2022-09-01") }
];

console.log(emps.length);
console.log(emps);
console.log(separator);

emps.push({ empId: 10, name: "Vasantha", basic: 67000, joinDate: new Date() });
console.log(emps);
console.log(separator);

emps.pop();
console.log(emps);
console.log(separator);

emps.sort((e1, e2) => (e1.basic < e2.basic ? -1 : (e1.basic > e2.basic ? 1 : 0)));
console.log(emps);
console.log(separator);

console.log(emps.map(e => e.name));
console.log(separator);

console.log(emps.reduce((e1, e2) => (e1.basic > e2.basic ? e1 : e2)));
console.log(separator);
