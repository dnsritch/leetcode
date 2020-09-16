function minPathSum(grid: number[][]): number {
  if (!grid || grid.length === 0 || grid[0].length === 0) {
    return 0
  }

  const row = grid.length
  const col = grid[0].length

  // 处理第一行
  for (let i = 1; i < col; i++) {
    grid[0][i] += grid[0][i - 1]
  }

  // 处理第一列
  for (let i = 1; i < row; i++) {
    grid[i][0] += grid[i - 1][0]
  }

  for (let i = 1; i < row; i++) {
    for (let j = 1; j < col; j++) {
      let left = grid[i][j - 1] + grid[i][j]
      let top = grid[i - 1][j] + grid[i][j]
      grid[i][j] = Math.min(left, top)
    }
  }

  return grid[row - 1][col - 1]
}
