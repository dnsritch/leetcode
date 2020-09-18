function longestCommonSubsequence(text1: string, text2: string): number {
  const m = text1.length
  const n = text2.length

  const list = Array(m + 1)
    .fill(0)
    .map(() => Array(n + 1).fill(0))

  //注意 i,j 初值
  for (let i = 1; i <= m; i++) {
    for (let j = 1; j <= n; j++) {
      if (text1[i - 1] === text2[j - 1]) {
        list[i][j] = list[i - 1][j - 1] + 1
      } else {
        list[i][j] = Math.max(list[i - 1][j], list[i][j - 1])
      }
    }
  }

  return list[m][n]
}
