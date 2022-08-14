// Remove Blanks
// Create a function that, given a string, returns all of that string’s contents, but without blanks. 

// Examples:

// removeBlanks(" Pl ayTha tF u nkyM usi c ") => "PlayThatFunkyMusic"
// removeBlanks("I can not BELIEVE it's not BUTTER") => "IcannotBELIEVEit'snotBUTTER"

function removeBlanks(str) {
   let newStr = ''
    for (let i = 0; i < str.length; i++) { //just use let char moving forward
        if(str[i] != ' ') {
            newStr += str[i]
        }
    }
    return newStr
}
// console.log(removeBlanks(" Pl ayTha tF u nkyM usi c "))


// Get Digits
// Create a JavaScript function that given a string, returns the integer made from the string’s digits. You are allowed to use isNaN() and Number().

// Examples:

// getDigits("abc8c0d1ngd0j0!8") => 801008

// getDigits("0s1a3y5w7h9a2t4?6!8?0") => 1357924680

function getDigits(str) {
    //pass in a str throught the function
    //for loop to itterate through the string to ppull out the int
        // if character is a number, concat into new str
    //concatenate all the int
    //print out only the int

    let newNumStr = ''
    for (let char in str) {
        if(!isNaN(str[char])) {
            newNumStr += str[char]
        } 
    }
    return Number(newNumStr);
}

// console.log(getDigits('asjdh123f786'));

// Acronyms
// Create a function that, given a string, returns the string’s acronym (first letter of the word capitalized). You are allowed to use .split() and .toUpperCase().

// acronym(" there's no free lunch - gotta pay yer way. ") => "TNFL-GPYW". 

// acronym("Live from New York, it's Saturday Night!") => "LFNYISN".

function acronym(str) {
    let wordsArr = str.split(' ')
    let acronymStr = ''
    for (let word in wordsArr) {
        if(wordsArr[word].length > 0 ) {
            acronymStr += wordsArr[word][0].toUpperCase()
        }
    }
    return acronymStr
}

// console.log(acronym("there's no free lunch - gotta pay yer way."))




// Count Non-Spaces
// Create a function that, given a string, returns the number of non-space characters found in the string. 

// Examples:

// countNonSpaces("Honey pie, you are driving me crazy") => 29
// countNonSpaces("Hello world !") => 11

function countNonSpaces(str) {
    let counter = 0
    for (let char in str) {
        if(str[char] != ' ') {
            counter++
        }
    }
    return counter
}
// console.log(countNonSpaces("Honey pie, you are driving me crazy"));

// Remove Shorter Strings
// Create a function that, given an array of strings and a numerical value, returns an array that only contains strings longer than or equal to the given value.

// Examples:

// removeShorterStrings(['Good morning', 'sunshine', 'the', 'Earth', 'says', 'hello'], 4) => ['Good morning', 'sunshine', 'Earth', 'says', 'hello']
// removeShorterStrings(['There', 'is', 'a', 'bug', 'in', 'the', 'system'], 3) => ['There', 'bug', 'the', 'system']

// var funStr = "Emma shreds on her electric cello";
// console.log(typeof funStr); // "string"
// var oneChar = funStr[26]; // "c"
// console.log(typeof oneChar); // "string"

function removeShorterStrings(arr, length) {
    let newStr = []
    let nextIndex = 0
    for (let value in arr) {
        if(arr[value].length >= length) {
            newStr[nextIndex++] = arr[value]
        }
    }
    return newStr
}
// console.log(removeShorterStrings(['Good morning', 'sunshine', 'the', 'Earth', 'says', 'hello'], 4));