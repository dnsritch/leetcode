/**
 Do not return anything, modify matrix in-place instead.
 */
function rotate(matrix: number[][]): void {
    let length = matrix.length
    // 对角线对折
    for (let i = 1; i < length; i++) {
        for (let j = 0; j < i; j++) {
            [matrix[i][j], matrix[j][i]] = [matrix[j][i], matrix[i][j]]
        }
    }
    // 按水平中线对折
    for (let i = 0; i < length; i++) {
        for (let j = 0; j < length / 2; j++) {
            [matrix[i][j], matrix[i][length - 1 - j]] = [matrix[i][length - 1 - j], matrix[i][j]]
        }
    }
}
