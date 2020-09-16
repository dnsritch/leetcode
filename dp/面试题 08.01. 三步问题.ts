function waysToStep(n: number): number {
  let list = [0, 1, 2, 4]
  if (n < 4) {
    return list[n]
  }

  for (let i = 4; i <= n; i++) {
    list[i] = (list[i - 1] + list[i - 2] + list[i - 3]) % 1000000007
  }

  return list[n]
}
