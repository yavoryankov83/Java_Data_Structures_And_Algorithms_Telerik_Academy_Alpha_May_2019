package next_greater_element;

import java.util.*;

class Solution {
  List<Integer> nextGreaterElement(List<Integer> nums1, List<Integer> nums2) {
    Map<Integer, Integer> hashMap = new HashMap<>();
    Deque<Integer> stack = new ArrayDeque<>();

    for (int num : nums2) {
      while (!stack.isEmpty() && stack.peek() < num) {
        hashMap.put(stack.pop(), num);
      }
      stack.push(num);
    }

    List<Integer> result = new ArrayList<>(nums1.size());
    for (int i = 0; i < nums1.size(); i++) {
      result.add(i, hashMap.getOrDefault(nums1.get(i), -1));
    }
    return result;
  }
}
