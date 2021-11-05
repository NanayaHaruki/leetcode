fun isPerfectSquare(num: Int): Boolean {
    if(num==1) return true
    var l = 1
    var r = num
    while(l<=r){
        val m = l+(r-l)/2
        val div = num/m
        when {
            div==m -> {
                //  5/2=2 显然5不是答案，模一下检查
                if (num%m==0) {
                    return true
                }else {
                    // 模不为0,说明div大了，即m小了
                    l=m+1
                }
            }
            div>m -> {
                l=m+1
            }
            div<m -> {
                r=m-1
            }
        }
    }
    return false
}