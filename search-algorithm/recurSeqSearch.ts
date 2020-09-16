/**
 * 顺序查找算法
 * @param array
 * @param key
 */
const RecurSeqSearch = (array: number[], key: number) => {
  for (let i = 0; i < array.length; i++) {
    if (array[i] === key) return i
  }
  return -1
}
