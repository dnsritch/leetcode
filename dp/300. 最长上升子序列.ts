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
