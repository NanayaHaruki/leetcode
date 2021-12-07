fun truncateSentence(s: String, k: Int): String {
    val arr = s.split(" ")
    val sb = StringBuilder()
    for(i in 0 until k){
        sb.append(arr[i])
        if(i!=k-1) sb.append(" ")
    }
    return sb.toString()
}