function alwaysHungry(array){
    var foundFood=false;
    var i=0;
    while(i<array.length){
        if(array[i]=="food"){
            console.log("yummy")
            foundFood=true;
        }
        i++;

    }
            if(!foundFood){
            console.log("im hungry")
        }
}
alwaysHungry([3.14, "food", "pie", true, "food"]);
alwaysHungry([4, 1, 5, 7, 2]);
/*------------------------------------------------next----------------------------------------------------------*/


function highPass(arr, cutoff) {
    var filteredArr = [];

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] >= cutoff) {
            filteredArr.push(arr[i]);
        }
    }

    return filteredArr;
}

var result = highPass([6, 8, 3, 10, -2, 5, 9], 5);
console.log(result); // Output: [6, 8, 10, 9]

/*------------------------------------------------next----------------------------------------------------------*/
function betterThanAverage(arr) {
    var sum = 0;
    while()
    var count = 0
    // count how many values are greated than the average
    return count;
}
var result = betterThanAverage([6, 8, 3, 10, -2, 5, 9]);
console.log(result); // we expect back 4
