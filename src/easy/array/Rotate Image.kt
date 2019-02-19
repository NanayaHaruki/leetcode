package easy.array

/**
 * 旋转图像
 */

//给定一个 n × n 的二维矩阵表示一个图像。
//
//将图像顺时针旋转 90 度。
//
//说明：
//
//你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
//
//示例 1:
//
//给定 矩阵matrix =
//[
//[1,2,3],
//[4,5,6],
//[7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//[7,4,1],
//[8,5,2],
//[9,6,3]
//]
//示例 2:
//
//给定 matrix =
//[
//[ 5, 1, 9,11],
//[ 2, 4, 8,10],
//[13, 3, 6, 7],
//[15,14,12,16]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//[15,13, 2, 5],
//[14, 3, 4, 1],
//[12, 6, 8, 9],
//[16, 7,10,11]
//]

/**
 *  python 解法 一行
 *  A[:] = zip(*A[::-1])
 *
 *  1、切片：[startIndex:endIndex:skipCount]
 *      skipCount 为负，则倒着切
 *   123
 *   456
 *   789
 *   经过切片后，为
 *   789
 *   456
 *   123
 *
 *   2、星号为解包，即将二维拆分为一维的3个元组。
 *   zip压缩即将三个元组压缩，角标对齐后的新的二维元组即为所求的
 *   741
 *   852
 *   963
 *
 *
 *   解法二：
 *   所有旋转问题都可以转换为中心对称+轴对称问题，本题顺时针转90°，可以理解为
 *   先中心翻转（横纵坐标互换），再横向翻转（横坐标x和长度len-x 互换）
 *   123        147        741
 *   456   ->   258    ->  852
 *   789        369        963
 *
 * */
fun rotate(matrix: Array<IntArray>): Unit {
    if (matrix.isEmpty() || matrix.size!= matrix.first().size) return
    // 中心翻转，横纵坐标互换
    for (i in matrix.indices) {
        for (j in i..matrix.lastIndex) {
            val tmp = matrix[i][j]
            matrix[i][j]=matrix[j][i]
            matrix[j][i]=tmp
        }
    }

    // 横向翻转
    for (i in matrix.indices) {
        // 只翻转左半部分
        for (j in 0 until matrix.size / 2) {
            val tmp = matrix[i][j]
            matrix[i][j]=matrix[i][matrix.lastIndex-j]
            matrix[i][matrix.lastIndex-j] = tmp
        }
    }
}