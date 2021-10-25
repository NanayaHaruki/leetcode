fun fizzBuzz(n: Int): List<String> {
    val ans = mutableListOf<String>()
    for (i in 1..n) {
        when {
            i%15==0 -> ans.add("FizzBuzz")
            i%3==0-> ans.add("Fizz")
            i%5==0->ans.add("Buzz")
            else -> ans.add(i.toString())
        }
    }
    return ans
}