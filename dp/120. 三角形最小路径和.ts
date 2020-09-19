function minimumTotal(triangle: number[][]): number {
  const length = triangle.length
  let tempList = Array(length)
    .fill(0)
    .map((v, index) => Array(index + 1).fill(0))

  tempList[0][0] = triangle[0][0]

  for (let i = 1; i < length; i++) {
    for (let j = 0; j < i + 1; j++) {
      if (j === 0) {
        tempList[i][j] = tempList[i - 1][j] + triangle[i][j]
      } else if (j === i) {
        tempList[i][j] = tempList[i - 1][j - 1] + triangle[i][j]
      } else {
        tempList[i][j] =
          Math.min(tempList[i - 1][j], tempList[i - 1][j - 1]) + triangle[i][j]
      }
    }
  }

  return Math.min(...tempList[length - 1])
}

//内存优化
function minimumTotal2(triangle: number[][]): number {
  const length = triangle.length
  let tempList = Array(length).fill(0)

  tempList[0] = triangle[0][0]

  for (let i = 1; i < length; i++) {
    for (let j = i; j >= 0; j--) {
      if (j === 0) {
        tempList[j] = tempList[j] + triangle[i][j]
      } else if (j === i) {
        tempList[j] = tempList[j - 1] + triangle[i][j]
      } else {
        tempList[j] = Math.min(tempList[j - 1], tempList[j]) + triangle[i][j]
      }
    }
  }

  return Math.min(...tempList)
}
