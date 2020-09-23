/**
 * 归并排序（迭代版）
 * @param arr 
 */
function MergeSort(arr: number[]) {
    const length = arr.length
    let tempList: number[] = []
    //步长
    for (let block = 1; block < length; block *= block * 2) {
        // 分组
        for (let start = 0; start < length; start += block * 2) {
            let low = start, high = Math.min(start + block * 2, length), mid = Math.floor(low + (high - low) / 2)
            let left = low, right = mid
            while (left < mid && right < high) {
                tempList[low++] = arr[left] < arr[right] ? arr[left++] : arr[right++]
            }
            while (left < mid) {
                tempList[low++] = arr[left++]
            }
            while (right < high) {
                tempList[low++] = arr[right++]
            }
        }
        arr = tempList
    }
    return arr
}


/**
 * 归并排序（递归版）
 * @param arr 
 */
function MergeSortRecur(arr: number[]) {
    if (arr.length < 2) {
        return arr
    }
    let mid = Math.floor(arr.length / 2)
    let left = arr.slice(0, mid)
    let right = arr.slice(mid)

    return Merge(MergeSortRecur(left), MergeSortRecur(right))
}

function Merge(left: number[], right: number[]): number[] {
    let list = []
    let l = 0, r = 0
    while (l < left.length && r < right.length) {
        if (left[l] < right[r]) {
            list.push(left[l++])
        } else {
            list.push(right[r++])
        }
    }

    while (l < left.length) {
        list.push(left[l++])
    }
    while (r < right.length) {
        list.push(right[r++])
    }

    return list
}

let list = [1, 6, 7, 32, 43, 213, 65, 54, 234, 76, 234, 23, 45]
// console.log(MergeSortRecur(list))
console.log(MergeSort(list))