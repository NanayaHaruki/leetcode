val k = 3
fun majorityElement(nums: IntArray): List<Int> {
    // 找出现次数多于n/3的数   这样的数最多只有2个
    // 找出现次数多过N/k的数 建立二维数组，数组长度为k-1，元素为【次数，数】
    // 遍历数组，本来就是候选，次数+1； 找次数为0的，替换掉，次数+1 ，其他候选次数-1
    val voteArr = Array(k-1){IntArray(2)}
    for (i in nums){
        val index = voteArr.indexOfFirst { it[1]==i }
        if (index != -1){
            // 本来就是候选
            voteArr[index][0]+=1 //次数自增
        }else {
            // 不是候选，找到次数为0的，加入候选，其他候选次数+1
            val emptyIndex = voteArr.indexOfFirst { it[0]==0 }
            if (emptyIndex!=-1){
                // 有空的位置
                voteArr[emptyIndex][0]=1
                voteArr[emptyIndex][1]=i
            }else {
                // 没有空的位置，所有候选次数抵消一次
                voteArr.forEach { it[0]-=1 }
            }
        }
    }

    // 此时voteArr中为可能的候选，还需要再次遍历，检查次数是否大于n/k
    val limit = nums.size/k
    val ans = mutableListOf<Int>()
    // 将出现次数清0,此时的次数是被加加减减抵消过后的，清空后面重新遍历检查次数
    voteArr.forEach { it[0]=0 }
    for (i in nums){
        for (intArr in voteArr){
            if (intArr[1]==i) {
                intArr[0]+=1
                break
            }
        }
    }
    voteArr.forEach {
        if (it[0]>limit) ans.add(it[1])
    }
    return ans
}