/**
 * @param {string} s
 * @return {number}
 */
function calculate(s) {
  Array.prototype.peek = function () {
    return this[this.length - 1]
  }

  let list = genExpression(s)

  let stack = []

  for (const item of list) {
    if (typeof item === "number") {
      stack.push(item)
    } else {
      let a = stack.pop()
      let b = stack.pop()
      switch (item) {
        case "+":
          stack.push(b + a)
          break
        case "-":
          stack.push(b - a)
          break
        case "*":
          stack.push(b * a)
          break
        case "/":
          stack.push(Math.floor(b / a))
          break
        default:
          throw new Error(item)
      }
    }
  }

  delete Array.prototype.peek

  return stack.pop()
}

// 生成逆波兰表达式
function genExpression(str) {
  Array.prototype.peek = function () {
    return this[this.length - 1]
  }

  let resList = []
  let symbolStack = []

  let weight = new Map()
  weight.set("(", -1)
  weight.set("+", 1)
  weight.set("-", 1)
  weight.set("*", 2)
  weight.set("/", 2)

  for (let i = 0; i < str.length; i++) {
    let char = str[i]

    switch (char) {
      case "+":
      case "-":
      case "*":
      case "/":
        if (
          symbolStack.length > 0 &&
          weight.get(char) > weight.get(symbolStack.peek())
        ) {
          symbolStack.push(char)
        } else {
          while (
            symbolStack.length > 0 &&
            weight.get(char) <= weight.get(symbolStack.peek())
          ) {
            resList.push(symbolStack.pop())
          }
          symbolStack.push(char)
        }
        break
      case "(":
        symbolStack.push(char)
        break
      case ")":
        while (symbolStack.peek() !== "(") {
          resList.push(symbolStack.pop())
        }
        symbolStack.pop()
        break
      case " ":
        continue
        break
      // 数字
      default:
        if (!isNum(char)) {
          throw new Error(char)
        }
        //处理连续数字
        if (i > 0 && isNum(str[i - 1])) {
          let num = resList.pop()
          resList.push(num * 10 + parseInt(char))
        } else {
          resList.push(parseInt(char))
        }
        break
    }
  }

  while (symbolStack.length > 0) {
    resList.push(symbolStack.pop())
  }
  return resList
}

function isNum(str) {
  return str >= "0" && str <= "9"
}
