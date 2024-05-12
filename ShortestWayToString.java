// Time Complexity : O(m*n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : yes
//Approach : Keep checking character in t is present in source.

class Solution {
    public int shortestWay(String source, String target) {
        int m = source.length();
        int n = target.length();
        Set<Character> set = new HashSet<>();

        for(char c : source.toCharArray()){
            set.add(c);
        }
        int i = 0 ; int j = 0; int count = 1;

        while(j < n){
            if(!set.contains(target.charAt(j))) return -1;
            if(source.charAt(i) == target.charAt(j)){
                j++;
            }
            if(j == n){
                return count;
            }

            i++;
            if(i == m){
                count++;
                i = 0;
            }
        }

        return count;
    }
}

//Optimized 

// Time Complexity : O(m + nlog(m)), 
// Space Complexity :  O(m) for storing the indices.
// Did this code successfully run on Leetcode : yes
//Approach : Keep checking character in t is present in source.

class Solution {
    public int shortestWay(String source, String target) {
        int m = source.length();
        int n = target.length();

        Map<Character,List<Integer>> map = new HashMap<>();
        
        //O(m)
        for(int i = 0; i < m; i++){
            if(!map.containsKey(source.charAt(i))){
                map.put(source.charAt(i), new ArrayList<>());
            }
            map.get(source.charAt(i)).add(i);
        }
        int count = 1;

        int i = 0; //source
        int j = 0; //target

        //nlogm
        while( j < n ){
            char tc = target.charAt(j);
            if(!map.containsKey(tc)) return -1;

            List<Integer> li = map.get(tc);
            int idx = Collections.binarySearch(li, i);
            if(idx < 0){
                idx = -idx-1;
            }

            if(idx == li.size()){
                count++;
                i = li.get(0);
            }
            else{
                i = li.get(idx);
            }

            i++;
            j++;
        }

        return count;
    }
}