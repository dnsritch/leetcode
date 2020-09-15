/**
 * 冒泡排序
 * @param array
 */
const BubbleSort = (array: number[]) => {
  const length = array.length
  let flag = true // 性能优化

  for (let i = 0; i < length - 1 && flag; i++) {
    flag = false

    for (let j = 0; j < length - 1 - i; j++) {
      if (array[j] > array[j + 1]) {
        let temp = array[j]
        array[j] = array[j + 1]
        array[j + 1] = temp

        flag = true
      }
    }
  }
}

// let list = [1, 4, 2, 7, 9, 3]
// BubbleSort(list)
// console.log(list)
