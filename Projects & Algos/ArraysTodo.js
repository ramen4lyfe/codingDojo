// Begining of array refers to: 0 index
// Ends refers to: arrayName.length - 1


//Push Front
function pushFront(arr,val) {
    for(let i = arr.length; i >= 0; i--){
        arr[i] = arr[ i-1 ] //creating additional space
    }
    arr[0] = val

    // other way of doing this
    arr.unshift(66);
    arr.splice(0,0,77);

    return arr
}

console.log("pushFront", pushFront([5,7,2,3],8));

//Pop Front
function popFront(arr) {
    let firstValue = arr[0]
    for (let i = 0; i < arr.length; i++) {
        arr[i] = arr[i+1]
    }
    arr.length = arr.length - 1
    console.log(arr);
    return firstValue;
    }
    
console.log("popFront",popFront([0,5,10,15]));

function popFront2(arr) {
    console.log(arr.shift())
    return arr
}
console.log(popFront2([1,2,3,4]));

//Insert At
function insertAt(arr, index, val) {
    for(let i = arr.length; i >= index; i--) {
        arr[i] = arr[i-1]
    }
    arr[index] = val
    return arr
}

console.log("insert at", insertAt([100,200,5],2, 311))

function insert(arr, index, val) {
    arr.splice(index, 0, val);
    return arr;
};

console.log(insert([1,2,3,4,5],2,'insert at'));