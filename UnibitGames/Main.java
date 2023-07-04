
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        
        int[] arr = {1, 3, 2, 2, -4, 6, -2, 8};
        int target = 4;

        int[][] res = firstCombination(arr, target);
		System.out.println("combination for first target  ->" + Arrays.deepToString(res));
        
        int[] ans = mergedArr(res);
        System.out.println("merged array ->" + Arrays.toString(ans));
        
        System.out.println("combination for doubled target" + secondCombination(ans, target * 2));
        
    }
    
    
    
    public static int[][] firstCombination(int[] nums, int target) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {

			int number = target - nums[i];

			if (map.containsKey(number)) {
				List<Integer> indices = map.get(number);
				for (int index : indices) {
					list.add(new int[] { nums[index], nums[i] });
				}
			}
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], new ArrayList<>());
			}
			map.get(nums[i]).add(i);
		}

		int[][] result = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}

		return result;
	}

    public static int[] mergedArr(int[][] res) {
       
      List<Integer> list = new ArrayList<>();
        for (int[] row : res) {
            for (int col : row) {
               list.add(col);
            }
        }
      
        int[] result = new int[list.size()];
      
       for (int i = 0 ; i < result.length ; i++){
            result[i] = list.get(i);
        }
		
		Arrays.sort(result);
		return result;
    }
    
    public static List<List<Integer>> secondCombination(int[] arr, int target) {
		List<List<Integer>> res = new ArrayList<>();

		int left = 0;
		int right = arr.length - 1;
		for (int a = 0; a < (arr.length) / (target / 2); a++) {
		    
			List<Integer> list = new ArrayList<>();
			
			list.add(arr[left++]);
			list.add(arr[right--]);
			list.add(arr[left++]);
			list.add(arr[right--]);
			
			res.add(list);

		}

		return res;

	}
    
}
