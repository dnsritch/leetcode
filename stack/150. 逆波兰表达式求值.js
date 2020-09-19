function evalRPN(tokens) {
  let stack = []
  for (let i = 0; i < tokens.length; i++) {
    const str = tokens[i]
    let num = parseInt(str)

    if (!isNaN(num)) {
      stack.push(num)
    } else {
      let a = stack.pop()
      let b = stack.pop()
      switch (str) {
        case "+":
          stack.push(a + b)
          break
        case "-":
          stack.push(b - a)
          break
        case "*":
          stack.push(b * a)
          break
        case "/":
          stack.push(parseInt(b / a))
          break
        default:
          throw new Error(str)
          break
      }
    }
  }

  return stack.pop()
}
