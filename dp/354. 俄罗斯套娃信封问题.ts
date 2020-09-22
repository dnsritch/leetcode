function maxEnvelopes(envelopes: number[][]): number {
  if (!envelopes || envelopes.length === 0) {
    return 0
  }
  envelopes.sort((a, b) => (a[0] - b[0] !== 0 ? a[0] - b[0] : a[1] - b[1]))

  let dp: number[] = Array(envelopes.length).fill(1)

  for (let i = 1; i < envelopes.length; i++) {
    const [width, height] = envelopes[i]
    let tempMax = 1
    for (let j = 0; j < i; j++) {
      const [w, h] = envelopes[j]
      if (width > w && height > h) {
        tempMax = Math.max(tempMax, dp[j] + 1)
      }
    }
    dp[i] = tempMax
  }

  return Math.max(...dp)
}

// 二分查找优化
function maxEnvelopes2(envelopes: number[][]): number {
  if (!envelopes || envelopes.length === 0) {
    return 0
  }
  // width 递增  height 递减
  envelopes.sort((a, b) => (a[0] - b[0] !== 0 ? a[0] - b[0] : b[1] - a[1]))
  const heightList = envelopes.map(item => item[1])

  let dp = []
  dp.push(heightList[0])

  for (let i = 0; i < heightList.length; i++) {
    let height = heightList[i]

    let left = 0, right = dp.length - 1
    while (left <= right) {
      let mid = Math.floor(left + (right - left) / 2)
      if (height > dp[mid]) {
        left = mid + 1
      } else {
        right = mid - 1
      }
    }
    dp[left] = height
  }

  return dp.length
}
