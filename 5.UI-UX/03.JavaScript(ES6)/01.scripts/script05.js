//CallBack : is a fucntion passed as param to another function.

const greetInTel = function(){
    return "Namaskaram ";
}

const greetInTamil = function(){
    return "Vanakkam ";
}

const greetInHindi = function(){
    return "Namaskar ";
}

const greetInEnglish = function(){
    return "Hello ";
}

const greetUser = function(userName,greet){
    console.log(greet() + userName);
}

greetUser("Vamsy",greetInTamil);
greetUser("Vamsy",greetInTel);
greetUser("Vamsy",greetInHindi);
greetUser("Vamsy",greetInEnglish);


