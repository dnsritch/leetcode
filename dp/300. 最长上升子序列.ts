function lengthOfLIS(nums: number[]): number {
  if (nums.length === 0) {
    return 0
  }
  let list = []
  for (let i = 0; i < nums.length; i++) {
    let tempMax = 0
    for (let j = 0; j < i; j++) {
      if (nums[i] > nums[j]) {
        tempMax = Math.max(tempMax, list[j])
      }
    }
    list[i] = tempMax + 1
  }
  return Math.max(...list)
}

//最长上升子序列优化
function lengthOfLIS2(nums: number[]): number {
  if (nums.length === 0) {
    return 0
  }

  let dp = []
  dp.push(nums[0])

  for (let i = 1; i < nums.length; i++) {
    let value = nums[i]
    if (value > dp[dp.length - 1]) {
      dp.push(value)
    } else {
      // 二分查找 
      let left = 0, right = dp.length - 1
      while (left <= right) {
        let mid = Math.floor(left + (right - left) / 2)
        if (value > dp[mid]) {
          left = mid + 1
        } else {
          right = mid - 1
        }
      }
      // 更新最小值
      dp[left] = value
    }
  }
  return dp.length
}
