public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		loop1 : for (int i = 0; i < nums.length; i++) {
			 for (int j = i + 1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					break loop1;
				}
				
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		int [] nums = {3,2,4};
		int[] twoSum = new TwoSum().twoSum(nums, 6);
		for (int i = 0; i < twoSum.length; i++) {
			System.out.println(twoSum[i]);
		}
	}
}
