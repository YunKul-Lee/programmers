package practice.level2.다음_큰_숫자;

import java.util.Arrays;

public class Solution {

    public int solution(int n) {
        int answer = 0;

        String nBinaryStr = Integer.toBinaryString(n);
        int countOne = 0;
        for(int i=0; i < (nBinaryStr.lastIndexOf('1') + 1); i++) {
            if(nBinaryStr.charAt(i) == '1') {
                countOne++;
            }
        }

        for(int i=n+1; i < 1_000_000; i++) {
            int countI = 0;
            String iBinaryStr = Integer.toBinaryString(i);

            for(int j=0; j < (iBinaryStr.lastIndexOf('1') + 1); j++) {
                if(iBinaryStr.charAt(j) == '1') {
                    countI++;
                }
            }

            if(countOne == countI) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
