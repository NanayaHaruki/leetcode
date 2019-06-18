# 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
#
# 如果不存在最后一个单词，请返回 0 。
#
# 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
from queue import PriorityQueue
from queue import Queue


class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        split = s.strip().split(' ')
        if len(split) == 0:
            return 0
        else:
            return len(split[-1])


if __name__ == '__main__':
    res = Solution().lengthOfLastWord("a ")
    print(res)
