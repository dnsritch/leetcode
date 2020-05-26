/**
 * @param {string} pattern
 * @param {string} str
 * @return {boolean}
 */
var wordPattern = function (pattern, str) {
    let slist = str.split(' ')
    let length = pattern.length

    if (slist.length != length)
        return false

    for (let i = 0; i < length; i++) {
        if (pattern.indexOf(pattern[i], i + 1) !== slist.indexOf(slist[i], i + 1))
            return false
    }
    return true
};
