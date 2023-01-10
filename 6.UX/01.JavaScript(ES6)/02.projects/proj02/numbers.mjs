
export const factorsOf = n => {
    let factors = [1];

    for(let i=2;i<=n/2;i++){
        if(n%i==0){
            factors.push(i);
        }
    }

    factors.push(n);
    return factors;
};

const isPrime = n => factorsOf(n).length==2 ;

export default isPrime;