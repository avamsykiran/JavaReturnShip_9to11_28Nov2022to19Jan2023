
//variable scopes

x = 100;

function f1(){
    y = 200;
    var z = 300;
    
    console.log(x);
    console.log(y);
    console.log(z);
    
    if(true){
        a = 201;
        var b = 301;
        let c = 401;
        console.log(a);
        console.log(b);
        console.log(c);
    }
    
    console.log(a);
    console.log(b);
    //console.log(c); is not allowed as 'let' makes 'c' block scoped .
}

f1();

console.log(x);
console.log(y);
//console.log(z); is not allowed as 'var' makes 'z' local scoped to 'f1'.
console.log(a);