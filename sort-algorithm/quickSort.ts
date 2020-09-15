/**
 * 快排
 * @param array
 */
const QuickSort = (array: number[]) => {
  qSort(array, 0, array.length - 1)
}
/**
 * @param array
 * @param start
 * @param end
 */
const qSort = (array: number[], start: number, end: number) => {
  console.log(start, end)
  if (start >= end) return

  let low = start
  let high = end

  const middle = array[low]

  while (low < high) {
    //取头部为 基点，从尾部开始扫描
    while (low < high && array[high] >= middle) high -= 1
    array[low] = array[high]

    while (low < high && array[low] <= middle) low += 1
    array[high] = array[low]
  }
  // 循环退出条件 low === high
  array[low] = middle

  qSort(array, start, low)
  qSort(array, low + 1, end)
}

// let list = [1, 5, 2, 6, 8, 4]
// QuickSort(list)
// console.log(list)
