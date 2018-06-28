class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);  // row # 0
        for (int row = 1; row <= rowIndex; row++) {
            for (int i = row - 1; i >= 1; i--) {
                int newVal = ans.get(i) + ans.get(i - 1);   // update all nodes backwards
                ans.set(i, newVal);   
            }
            ans.add(1);   // add the last node 1
        }
        return ans;
    }
}