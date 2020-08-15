let testArray = Array.from({ length: 100000 }).fill(0)

console.time('Object.values(list)')
let array1 = Object.values(testArray)
console.timeEnd('Object.values(list)')

console.time('[...list]')
let array2 = [...testArray]
console.timeEnd('[...list]')

console.time('Array.of(...list)')
let array3 = Array.of(...testArray)
console.timeEnd('Array.of(...list)')


console.time('Object.assign([],list)')
let array4 = Object.assign([], testArray)
console.timeEnd('Object.assign([],list)')


console.time('[].concat(list)')
let array5 = [].concat(testArray)
console.timeEnd('[].concat(list)')



console.time('list.map(i=>i)')
let array6 = testArray.map(i => i)
console.timeEnd('list.map(i=>i)')



console.time('list.slice()')
let array7 = testArray.slice()
console.timeEnd('list.slice()')

console.time('JSON.parse(JSON.stringify(list))')
let array8 = JSON.parse(JSON.stringify(testArray))
console.timeEnd('JSON.parse(JSON.stringify(list))')




















