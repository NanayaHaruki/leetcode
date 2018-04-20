class Solution {
    public String reverseVowels(String s) {
        List<Integer> list = new ArrayList<>();
        String viwels = "aiueoAIUEO";
        for (int i = 0; i < s.length(); i++) {
//            找出元音的角标，保存起来
            if (viwels.contains(String.valueOf(s.charAt(i)))) {
                list.add(i);
            }
        }
        char[] charArr = s.toCharArray();
        for(int i = 0 ;i<list.size()/2;i++) {
            Character temp = charArr[list.get(i)];
            charArr[list.get(i)] = charArr[list.get(list.size() - 1 - i)];
            charArr[list.get(list.size() - 1 - i)] = temp;
        }
        return new String(charArr);
    }
}
