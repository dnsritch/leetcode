function permutation(S: string): string[] {
    let resList: string[] = []

    // backTrack(0, [...S], resList)

    // let used = new Set<string>()
    // backTrack2('', used, [...S], resList)

    return resList

    // return handler([...S])
}

// 递归分解
function handler(list: string[]): string[] {
    if (list.length <= 1) {
        return list;
    }
    let res: string[] = []
    for (let i = 0; i < list.length; i++) {
        const element = list[i]
        let rest = list.slice(0, i).concat(list.slice(i + 1))
        handler(rest).forEach(item => res.push(element + item))
    }
    return res
}

// 数组元素交换法
function backTrack(first: number, list: string[], resList: string[]) {
    if (first === list.length) {
        resList.push(list.join(''))
    }
    for (let i = first; i < list.length; i++) {
        swap(list, first, i)
        backTrack(first + 1, list, resList)
        swap(list, first, i)
    }
}

function swap(array: any[], index1: number, index2: number) {
    array[index1] = array.splice(index2, 1, array[index1])[0]
}

// 使用 Set 存储已使用的元素
function backTrack2(str: string, used: Set<string>, list: string[], resList: string[]) {
    if (used.size === list.length) {
        resList.push(str)
    }
    for (let i = 0; i < list.length; i++) {
        const s = list[i]
        if (!used.has(s)) {
            used.add(s)
            str += s
            backTrack2(str, used, list, resList)
            str = str.slice(0, str.length - 1)
            used.delete(s)
        }
    }
}


