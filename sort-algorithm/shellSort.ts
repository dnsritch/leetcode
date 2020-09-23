/**
 * 希尔排序
 */
const ShellSort = (array: number[]) => {
  const length = array.length
  let gap = length
  while (true) {
    gap = Math.floor(gap / 2)
    if (gap < 1) {
      break
    }
    // 遍历 n个分组
    for (let start = 0; start < gap; start++) {
      // 遍历每个分组
      for (let i = start; i < length; i += gap) {
        // 反向遍历 判断是否需要移动
        for (let j = i + gap; j > 0; j -= gap) {
          if (array[j] < array[j - gap]) {
            let temp = array[j]
            array[j] = array[j - gap]
            array[j - gap] = temp
          } else {
            break
          }
        }
      }
    }
  }
}

