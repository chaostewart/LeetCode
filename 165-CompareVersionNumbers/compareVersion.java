class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1List = version1.split("\\.");   
        String[] v2List = version2.split("\\.");
        int len = Math.max(v1List.length, v2List.length);    
        for (int i = 0; i < len; i++) {
            Integer v1 = i < v1List.length ? Integer.parseInt(v1List[i]) : 0;  
            Integer v2 = i < v2List.length ? Integer.parseInt(v2List[i]) : 0;
            // Integer.parseInt("string") can be assigned to int primitive type, but int cannot do compareTo later
            int res = v1.compareTo(v2);    // if v1 < v2, returns -1, else if v1 > v2, returns 1, else returns 0
            if (res != 0)
                return res;
        }
        return 0;   // this happens when for loop completes, e.g. "2.5.0.0" = "2.5"
    }
}