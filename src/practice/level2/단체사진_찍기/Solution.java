package practice.level2.단체사진_찍기;

public class Solution {
    private int answer = 0;
    private String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

    public int solution(int n, String[] data) {
        boolean[] isVisited = new boolean[8];
        dfs("", isVisited, data);

        return answer;
    }

    private void dfs(String names, boolean[] isVisited, String[] data) {
        if(names.length() == 8) {
            if(isValid(names, data)) {
                answer++;
            }
            return;
        }
        for(int i=0; i < 8; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                String name = names + friends[i];
                dfs(name, isVisited, data);
                isVisited[i] = false;
            }
        }
    }

    /**
     * 조건충족 검증
     *
     */
    private boolean isValid(String names, String[] data) {

        for(String item : data) {

            int position1 = names.indexOf(item.charAt(0));
            int position2 = names.indexOf(item.charAt(2));
            char operation = item.charAt(3);        // =<>
            int gap = item.charAt(4) - '0' + 1;     // 간격

            if(operation == '=') {
                if(Math.abs(position1 - position2) != gap) return false;
            } else if(operation == '>') {
                if(Math.abs(position1 - position2) <= gap) return false;
            } else if(operation == '<') {
                if(Math.abs(position1 - position2) >= gap) return false;
            }
        }

        return true;
    }
}
