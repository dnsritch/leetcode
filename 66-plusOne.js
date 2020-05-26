/**
 * @param {number[]} digits
 * @return {number[]}
 */

let list = [1, 2, 3]

var plusOne = function (digits) {
    let carry = 0
    for (let i = digits.length - 1; i >= 0; i--) {
        let temp = digits[i] + 1 + carry
        carry = (temp / 10).toFixed(0)
        digits[i] = temp % 10
        console.log(temp % 10)

    }
    return digits
};

console.log(plusOne(list))