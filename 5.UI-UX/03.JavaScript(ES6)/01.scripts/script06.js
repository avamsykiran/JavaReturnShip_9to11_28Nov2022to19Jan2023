//Arrow Functions

const greet = () => {
    console.log("Hello All Of You!");
}

greet();

const greetUser = userName => {
    console.log("Hello "+userName);
}

greetUser("Vamsy");

const greetMe = userName => "Hai "+userName ;

console.log(greetMe("Vamsy"));