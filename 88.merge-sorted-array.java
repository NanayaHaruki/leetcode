class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int j : nums2) {
            set.add(j);
        }
        Iterator iterator = set.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            nums1[index++] = (int) iterator.next();
        }
    }
}
