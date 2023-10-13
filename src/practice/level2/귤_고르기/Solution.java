package practice.level2.귤_고르기;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        // 크기별 갯수 분류
        Map<Integer, Integer> tangerineMap = new HashMap<>();
        for(int item : tangerine) {
            tangerineMap.put(item, tangerineMap.getOrDefault(item, 0) + 1);
        }

        // 갯수가 많은 것을 기준으로 우선순위 설정
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        tangerineMap.forEach((key, value) -> queue.add(value));

        while (k > 0) {
            if(queue.peek() > k) {
                queue.poll();
                answer++;
                break;
            } else {
                k -= queue.poll();
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        Solution s = new Solution();
        int result = s.solution(k, tangerine);
        System.out.println(result);
    }
}
