package practice.level2.뒤에_있는_큰_수_찾기;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=(numbers.length - 1); i >=0; i--) {
            while (!stack.isEmpty()) {
                if(stack.peek() > numbers[i]) {
                    answer[i] = stack.peek();
                    break;
                } else {
                    stack.pop();
                }
            }
            if(stack.isEmpty()) {
                answer[i] = -1;
            }

            stack.push(numbers[i]);
        }

        return answer;
    }
}
