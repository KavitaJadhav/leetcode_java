//https://algo.monster/liteproblems/359
//LeetCode: Logger Rate Limiter
        package mock_practice;

import java.util.*;

class Logger {

    private HashMap<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        }

        int lastTime = map.get(message);

        if (timestamp - lastTime >= 10) {
            map.put(message, timestamp);
            return true;
        }

        return false;
    }
}