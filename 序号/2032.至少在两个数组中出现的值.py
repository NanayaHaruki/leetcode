class Solution:
    def twoOutOfThree(
        self, nums1: List[int], nums2: List[int], nums3: List[int]) -> List[int]:
        dict = defaultdict(int)
        for i in nums1:
            dict[i] = 1
        for i in nums2:
            dict[i] |=2
        for i in nums3:
            dict[i] |= 4
        return [x for x,v in m.items() if v not in (1,2,4)]