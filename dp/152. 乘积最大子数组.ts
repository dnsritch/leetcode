function maxProduct(nums: number[]): number {
  let maxValue, minValue, res
  maxValue = minValue = res = nums[0]

  for (let i = 1; i < nums.length; i++) {
    let val = nums[i]
    let max = maxValue,
      min = minValue
    maxValue = Math.max(max * val, min * val, val)
    minValue = Math.min(max * val, min * val, val)
    res = Math.max(maxValue, res)
  }

  return res
}
