import java.util.ArrayList;
import java.util.List;

public class SubSets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		ArrayList<Integer> empty = new ArrayList<Integer>();
		list.add(empty);
		int length = nums.length;
		empty = new ArrayList<>();
		int i = 0;
		int listLength = 1;
		for (int j = 0; j < length; j++) {
			listLength *= 2; 
		}
		List<Integer> indexes = new ArrayList<>();
		indexes.add(0);
		while(i < listLength) {
			List<List<Integer>> subList = subList(i, length, nums, list, indexes);
			if(subList != null)
				list.addAll(subList);
			i ++;
		}
        return list;
    }
	
	private List<List<Integer>> subList(int index, int length, int[] nums, List<List<Integer>> list, List<Integer> indexes) {
		//获取这次遍历的数组索引
		int next = indexes.get(index);
		//如果索引位置
		if(next == length) return null;
		List<Integer> empty = null;
		//获取结果对应位置的子集
		List<Integer> data = list.get(index);
		List<List<Integer>> temList = new ArrayList<>();
		for (int i = next; i < length; i++) {
			//设置下一次遍历的数组索引
			indexes.add(i + 1);
			empty = new ArrayList<>(data);
			empty.add(nums[i]);
			temList.add(empty);
		}
		//将empty设置为空
		empty = null;
		return temList;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,9};
		List<List<Integer>> list = new SubSets().subsets(nums);
		System.out.println(list.size());
		System.out.println(list);
	}
}
