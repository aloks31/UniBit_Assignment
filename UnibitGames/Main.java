public class Main {

    public static void main(String[] args) {

        int[] arr = { 1, 3, 2, 2, -4, -6, -2, 8 };
        int target = 4;

        int[][] firstCombination = findCombinations(arr, target);
        System.out.println("First Combination for \"" + target + "\": " + Arrays.deepToString(firstCombination));

        List<Integer> mergedList = mergeLists(firstCombination);
        System.out.println("Merge Into a Single List: " + mergedList);

        // int doubleTarget = target * 2;
        // int[][] secondCombination = findCombinations(mergedArray, doubleTarget);
        // System.out.println("Second Combination for \"" + doubleTarget + "\": " + Arrays.deepToString(secondCombination));

    }

    public static List<List<Integer>> findCombinations(List<Integer> list, int target) {

        List<List<Integer>> combinations = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (Integer num : list) {
            int complement = target - num;

            if (seen.contains(complement)) {
                combinations.add(Arrays.asList(num, complement));
            }

            seen.add(num);
        }

        return combinations;
    }

    public static List<Integer> mergeLists(List<List<Integer>> lists) {
        List<Integer> mergedList = new ArrayList<>();

        for (List<Integer> list : lists) {
            mergedList.addAll(list);
        }

        Collections.sort(mergedList);

        return mergedList;
    }





}    