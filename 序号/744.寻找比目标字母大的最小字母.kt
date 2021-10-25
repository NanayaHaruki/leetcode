fun nextGreatestLetter(letters: CharArray, target: Char): Char {
    // 二分查找，左边界。 找不到则返回letters[0]
    var l = 0
    var r = letters.lastIndex
    while (l <= r) {
        val m = l + (r - l) / 2
        if (letters[m] <= target) l = m + 1
        else r = m - 1
    }
    return if (l > letters.lastIndex) letters.first() else letters[l]
}