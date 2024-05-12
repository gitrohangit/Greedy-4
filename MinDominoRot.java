// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : yes
//approach : target will be present in both tops[i] and bottoms[i]

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = check(tops,bottoms, tops[0]);

        if(result != -1){
            return result;
        }

        return check(tops,bottoms, bottoms[0]);
    }

    private int check(int[] tops, int[] bottoms, int target){
        int tRot = 0;
        int bRot = 0;

        for(int i = 0 ; i < tops.length ; i++){
            if(tops[i] != target && bottoms[i] != target) return -1;
            if(tops[i] != target) tRot++;
            if(bottoms[i] != target) bRot++;
        }

        return Math.min(tRot, bRot);
    }
}