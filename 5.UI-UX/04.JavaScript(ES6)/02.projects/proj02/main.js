/******************************************** 
import { sum,dif,prd } from './arth.mjs';

console.log(sum(10,5));
console.log(dif(10,5));
console.log(prd(10,5));
********************************************/

import * as arth from './arth.mjs';
import isPrime, { factorsOf } from './numbers.mjs';

console.log(arth.sum(10, 5));
console.log(arth.dif(10, 5));
console.log(arth.prd(10, 5));

console.log(factorsOf(169));
console.log(isPrime(169));
