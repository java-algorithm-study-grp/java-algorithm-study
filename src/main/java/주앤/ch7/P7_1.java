package 주앤.ch7;

/*
	풀이 방법 : 완전 탐색
	시간 복잡도 : O(n^2)
	실행시간 및 메모리 : 45 ms,44 MB
 */
public class P7_1 {
	public int[] twoSum(int[] nums, int target) {
     int start = 0;
     int end = nums.length - 1;

     while(start < end){
         if(nums[start]+nums[end] == target){
             return new int[]{start,end};
         }

         if(start + 1 == end){
             start = 0;
             end--;
         }else {
             start++;
         }
     }

     return null;
 }
}
