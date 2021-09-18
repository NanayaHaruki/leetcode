fun canWinNim(n: Int): Boolean {
    // 每人拿1-3个石头，那么赢就必须每次让对手剩余4的倍数
    return n%4!=0
}