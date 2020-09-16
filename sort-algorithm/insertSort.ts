/**
 * 插入排序
 * @param array
 */
const InsertSort = (array: number[]) => {
  const length = array.length
  for (let i = 1; i < length; i++) {
    if (array[i] < array[i - 1]) {
      let j = i - 1
      let temp = array[i]

      while (j > 0 && temp < array[j]) {
        array[j + 1] = array[j]
        j -= 1
      }

      array[j + 1] = temp
    }
  }
}

/**
 * 插入排序
 * @param array
 */
const InsertSort2 = (array: number[]) => {
  const length = array.length
  for (let i = 1; i < length; i++) {
    for (let j = i; j > 0; j--) {
      if (array[j] < array[j - 1]) {
        let temp = array[j]
        array[j] = array[j - 1]
        array[j - 1] = temp
      } else {
        break
      }
    }
  }
}

// let list = [1, 5, 2, 6, 8, 4]
// InsertSort2(list)
// console.log(list)
