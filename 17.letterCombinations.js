/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function (digits) {
  let obj = {
    "2": ["a", "b", "c"],
    "3": ["d", "e", "f"],
    "4": ["g", "h", "i"],
    "5": ["j", "k", "l"],
    "6": ["m", "n", "o"],
    "7": ["p", "q", "r", "s"],
    "8": ["t", "u", "v"],
    "9": ["w", "x", "y", "z"],
  };
  if (digits.length === 1) return obj[digits];

  let list = [...digits].map((item) => {
    return obj[item];
  });

  console.log(list);
  let res = [];
  console.log(res);
  for (let item of list) {
    res = gen(res, item);
    console.log(res);
  }
  console.log(res);
};

function gen(list1, list2) {
  if (list1.length === 0) return list2;
  let res = [];
  for (let item of list1) {
    for (let delta of list2) {
      res.push(item + delta);
    }
  }
  return res;
}

letterCombinations("2");
