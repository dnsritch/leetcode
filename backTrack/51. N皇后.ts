function solveNQueens(n: number): string[][] {
    let resList: string[][] = []

    let queens: number[] = Array(n).fill(0)
    // 0-可用  1 不可使用 
    let colFlag = Array(n).fill(0)                      // 行标志位
    let mainFlag = Array(2 * n - 1).fill(0)             //主对角线 y=x   row + col = const
    let secondaryFlag = Array(2 * n - 1).fill(0)        //次对角线 y=-x  row - col = const

    backTrack(0)

    return resList



    function backTrack(row: number) {
        if (row === n) {
            resList.push(genResult())
            return
        }

        for (let col = 0; col < n; col++) {
            if (checkValid(row, col)) {
                setQueen(row, col)
                backTrack(row + 1)
                removeQueen(row, col)
            }
        }
    }

    function setQueen(row: number, col: number) {
        queens[row] = col
        setFlag(row, col, 1)
    }

    function removeQueen(row: number, col: number) {
        queens[row] = 0
        setFlag(row, col, 0)
    }

    // 设置标志位
    function setFlag(row: number, col: number, type: number) {
        colFlag[col] = type
        mainFlag[row + col] = type
        secondaryFlag[row - col + n - 1] = type
    }

    // 检查是否可用
    function checkValid(row: number, col: number): boolean {
        let sum = colFlag[col] + mainFlag[row + col] + secondaryFlag[row - col + n - 1]
        return sum === 0
    }

    function genResult(): string[] {
        let res: string[] = []
        for (let index of queens) {
            let str = Array(n).fill('.')
            str.splice(index, 1, 'Q')
            res.push(str.join(''))
        }
        return res
    }
}

