package main.kotlin


import java.io.File
import java.util.*

class Solution {

    fun simplifyPath(path: String): String {
        // 简化 必须/开头  两个路径只有一个/  结尾没有/
        // 遍历 缓存两个/之间的相对路径cache 遇到/ 拿出缓存的相对路径比对
        // . 表示当前路径，cache清空，继续遍历
        // .. 表示父级 /a/b/ ../   cache为缓存 ，/ 为当前位置 ，需要回到/a/ cache清空,ans删除，
        // 保存/索引的q先poll一次再peek找到位置，如果没有了就是顶级目录

        var ans = ""
        // 遍历时遇/处理一层目录，在末尾加一个/ 用来处理最后一级
        val chars = ("$path/").toCharArray()
        val q = ArrayDeque<Int>() // 记录分割符位置
        if (chars.first() != '/') {
            ans+='/'
            q.addLast(0)
        }
        var cache = ""
        for (i in chars.indices) {
            val c = chars[i]
            if (c == '/') {
                if (i > 0 && chars[i - 1] == '/') {
                    // 左边也是/ 跳过
                    continue
                } else {
                    when (cache) {
                        "." -> {
                            // 当前路径，cache清空，跳过此次/
                            cache=""
                        }
                        ".." -> {
                            // 上一路径  保留顶级目录,所以>1
                            if (q.size > 1) {
                                q.removeLast()
                            }
                            val lastSeqIndex = q.last()
                            if (lastSeqIndex+1<ans.length){
                                ans = ans.removeRange(lastSeqIndex+1,ans.length)
                            }
                            cache = ""
                        }
                        else -> {
                            ans = "${ans}${cache}/"
                            q.addLast(ans.length-1)
                            cache = ""
                        }
                    }

                }
            } else {
                cache+=c
            }
        }
        if (ans.length > 1 && ans.last() == '/') {
            ans = ans.dropLast(1)
        }
        return ans
    }
}

