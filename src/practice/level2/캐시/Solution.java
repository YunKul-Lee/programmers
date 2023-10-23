package practice.level2.캐시;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int cacheSize, String[] cities) {
        Queue<String> cache = new LinkedList<>();
        int time = 0;

        if(cacheSize == 0) {
            return cities.length * 5;
        }

        for(String item: cities) {
            String city = item.toUpperCase();

            if(cache.contains(city)) {
                cache.remove(city);
                cache.offer(city);
                time++;
            } else {
                if(cache.size() >= cacheSize) {
                    cache.poll();
                }
                cache.offer(city);
                time += 5;
            }
        }

        return time;
    }

}
