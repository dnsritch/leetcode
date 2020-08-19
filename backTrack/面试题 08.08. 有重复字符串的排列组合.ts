function permutation(S: string): string[] {
    let resList: string[] = []

    backTrack(0, [...S], resList)

    return resList
}


function backTrack(first: number, list: string[], resList: string[]) {
    if (first === list.length) {
        resList.push(list.join(''))
        return
    }

    const used = new Set<string>()
    for (let i = first; i < list.length; i++) {
        const element = list[i]
        if (!used.has(element)) {
            used.add(element)
            swap(list, first, i)
            backTrack(first + 1, list, resList)
            swap(list, first, i)
        }
    }
}

function swap(list: any[], index1: number, index2: number) {
    list[index1] = list.splice(index2, 1, list[index1])[0]
}