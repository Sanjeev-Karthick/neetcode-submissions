class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elementFreqMap = new HashMap();
        Map<Integer, ArrayList<Integer>> freqToElementMap = new TreeMap(Comparator.reverseOrder());
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            elementFreqMap.put(nums[i], elementFreqMap.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : elementFreqMap.entrySet()) {
            ArrayList<Integer> temp =
                freqToElementMap.getOrDefault(entry.getValue(), new ArrayList<Integer>());
            temp.add(entry.getKey());
            freqToElementMap.put(entry.getValue(), temp);
        }

        int index = 0;

        for (Map.Entry<Integer, ArrayList<Integer>> entry : freqToElementMap.entrySet()) {
             ArrayList<Integer> temp = entry.getValue();
             for(int i = 0; i < temp.size() ; i++){
                result[index] = temp.get(i);
                index++;
                if(index == k)
                    return result;
             }

            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        return result;
    }
}
