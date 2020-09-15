/**
 * 选择排序
 * @param array
 */
const SelectSort = (array: number[]) => {
  let length = array.length
  for (let i = 0; i < length; i++) {
    let min = array[i]
    let minIndex = i
    for (let j = i + 1; j < length; j++) {
      if (array[j] < min) {
        min = array[j]
        minIndex = j
      }
    }
    array[minIndex] = array[i]
    array[i] = min
  }
}

let list = [1, 3, 8, 2, 5, 4]
SelectSort(list)
console.log(list)
