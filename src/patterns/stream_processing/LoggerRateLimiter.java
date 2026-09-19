package patterns.stream_processing;

import java.sql.Time;
import java.util.*;

//https://leetcode.com/problems/logger-rate-limiter/description/
//Design a logger system that receives messages with timestamps.
//
//A message should be printed only if the same message has not been printed in the previous 10 seconds.

//
//Complexity
//
//Time per message
//O(1) average
//Space
//O(M)
//
//Where M = number of unique messages stored in the HashMap.
//
//4. Interview notes
//
//Pattern: HashMap + Timestamp Tracking
//
//Store the last printed timestamp for each message.
//
//If the message is new, print it and record the timestamp.
//
//If the message exists, check whether at least 10 seconds have passed.
//
//Update the timestamp only when the message is printed.
//
//Rejected messages must not update the timestamp.
public class LoggerRateLimiter {
    static class Logger {
        Map<String, Integer> map;

        public Logger() {
            map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if(!map.containsKey(message)){
                map.put(message, timestamp);
                return true;
            }else{
                if(map.get(message)<=timestamp-10){
                    map.put(message, timestamp);
                    return true;
                }
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "hi"));
        System.out.println(logger.shouldPrintMessage(2, "hi"));
        System.out.println(logger.shouldPrintMessage(2, "hello"));
        System.out.println(logger.shouldPrintMessage(12, "hi"));
        System.out.println(logger.shouldPrintMessage(12, "hello"));
        System.out.println(logger.shouldPrintMessage(22, "hi"));
        System.out.println(logger.shouldPrintMessage(22, "hello"));

 }
}
