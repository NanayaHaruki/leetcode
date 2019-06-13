import java.io.File
import java.io.PrintWriter
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

/**
 *@Author: taoye
 *@Description:
 *@Date: 14:50 2019/2/18
 */


object KotlinMain {
    var i: Int? = null
    @JvmStatic
    fun main(args: Array<String>) {
        val res = isValid("()")
        println(res)
    }

    fun isValid(s: String): Boolean {
        val map = mapOf<Char,Char>(Pair(')','('),
                Pair(']','['),
                Pair('}','{'))
        val stack= Stack<Char>()
        for (c in s) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c)
            }else {
                if (map[c] == stack.peek()) {
                    stack.pop()
                }
            }
        }
        return stack.isEmpty()
    }

    private fun twoBall(): Double {
        val balls = arrayOf(arrayOf("red", "blue"), arrayOf("red", "red"), arrayOf("blue", "blue"))
        val random = Random()
        val result = mutableListOf<Array<String>>()
        var firstSelectRed = 0
        var firstRedSecondBlue = 0
        var firstRedSecondRed = 0
        repeat(10000) {
            val firstSelect = random.nextInt(3)
            val secondSelect = random.nextInt(2)
            val ball = balls[firstSelect][secondSelect]
            if (ball == "red") {
                firstSelectRed++
                if (secondSelect == 0) {
                    if (balls[firstSelect][1] == "blue") {
                        firstRedSecondBlue++
                    } else {
                        firstRedSecondRed++
                    }
                } else {
                    if (secondSelect == 1) {
                        if (balls[firstSelect][0] == "blue") {
                            firstRedSecondBlue++
                        } else {
                            firstRedSecondRed++
                        }
                    }
                }
            }
            result.add(arrayOf(balls[firstSelect][secondSelect]))
        }

        println("""
          第一次选中红球次数:$firstSelectRed
            第二次选中篮球次数：$firstRedSecondBlue
            第二次选中红球次数：$firstRedSecondRed
            一红二红：${firstRedSecondRed.toDouble() / firstSelectRed}
            一红二蓝：${firstRedSecondBlue.toDouble() / firstSelectRed}
        """.trimIndent())
        return firstRedSecondBlue.toDouble() / firstSelectRed
    }


    private fun base64ToFile() {
        val dir = File("d:/v3_mobilenet.pb")
        val base64 = base64(dir.readBytes())
        val os = PrintWriter("d:/v3_pb_base64.txt")
        os.write(base64)
        os.flush()
        os.close()
    }


    fun getSign() {
        val time = System.currentTimeMillis()
        println(time)
        val origin = "ESSELLESL2019KSGG" + "es010101" + time
        println(origin)
        val md5StringFor = origin.md5()
        println(md5StringFor)
    }

    fun base64(datas: ByteArray): String {
        return Base64.getEncoder().encodeToString(datas)
    }


    fun String.md5(): String {
        if (isEmpty()) return ""
        var md5: MessageDigest? = null
        try {
            md5 = MessageDigest.getInstance("MD5")
            val bytes = md5!!.digest(this.toByteArray())
            var result = ""
            for (b in bytes) {
                var temp = Integer.toHexString(b.toInt() and 0xff)
                if (temp.length == 1) {
                    temp = "0$temp"
                }
                result += temp
            }
            return result
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        return ""
    }
}