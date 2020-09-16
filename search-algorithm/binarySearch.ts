/**
 * 折半查找
 */
const BinarySearch = (array: number[], key: number) => {
  let start = 0,
    end = array.length - 1

  while (start <= end) {
    let midIndex = Math.floor((start + end) / 2)
    let middle = array[midIndex]

    if (middle === key) {
      return midIndex
    } else if (middle > key) {
      end = midIndex - 1
    } else {
      start = midIndex + 1
    }
  }

  return -1
}
/**
 * 折半查找 递归
 * @param array
 * @param key
 * @param low
 * @param high
 */
const RecurBinarySearch = (
  array: number[],
  key: number,
  low: number,
  high: number
) => {
  if (low > high) return -1

  const midIndex = Math.floor((low + high) / 2)
  const middle = array[midIndex]

  if (middle === key) {
    return midIndex
  } else if (middle > key) {
    return RecurBinarySearch(array, key, low, midIndex - 1)
  } else {
    return RecurBinarySearch(array, key, midIndex + 1, high)
  }
}
