fun checkPerfectNumber(num: Int): Boolean {
    if (num==1) return false
    var sum = 1
    var i = 2
    while (i * i <= num) {
        if (num % i == 0) {
            sum += i
            if (num / i != i) {
                sum += num / i
            }
        }
        i++
    }
    return sum == num
}