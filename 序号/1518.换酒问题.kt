// 方法一 模拟
// fun numWaterBottles(_numBottles: Int, numExchange: Int): Int {
//     var drink = 0
//     var emptyBottles = 0
//     var numBottles = _numBottles
//     while (numBottles>0){
//         drink++
//         emptyBottles++
//         numBottles--
//         if (emptyBottles==numExchange){
//             emptyBottles=0
//             numBottles++
//         }
//     }
//     return drink
// }

// logN
// fun numWaterBottles(_numBottles: Int, numExchange: Int): Int {
//     var ans = _numBottles // 一开始就有的都喝掉
//     var n = _numBottles // 拥有的空瓶子数量
//     while (n >= numExchange) {
//         val changeBottles = n / numExchange //空瓶子能换来的
//         ans += changeBottles // 喝换来的
//         n = changeBottles + n % numExchange // 现有空瓶子数量，刚换来的喝掉+之前不够换的空瓶子
//     }
//     return ans
// }

// 数学
fun numWaterBottles(_numBottles: Int, numExchange: Int): Int {
    // 每次换就少 numExchange-1 个瓶子，给你3个空瓶子，给我1个新的，我少了2个瓶子
    val change = _numBottles/(numExchange-1) // 总共能换多少次
    var ans = _numBottles+change // 答案为 本来就有的+可以换来的
    // 处理边界  我有2个  你需要3个  不能用上面的 2/(3-1)=1,这是换不了的
    if (_numBottles%(numExchange-1)==0) ans--
    return ans
}