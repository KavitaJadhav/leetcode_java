//Given a stream of stock events:
//
//`(timestamp, stockSymbol, price)`
//
//Design a data structure supporting:
//
//* `add(timestamp, stockSymbol, price)`
//* `getCurrentPrice(stockSymbol)`
//* `getMaxPrice(stockSymbol, timestamp)` → maximum price in the **previous 1 hour**
//* `getMinPrice(stockSymbol, timestamp)` → minimum price in the **previous 1 hour**
//
//**Twist:** Events initially arrive in timestamp order. Then discuss how you'd handle **out-of-order events**.
//
//**Pattern:** HashMap + Sliding Window + Monotonic Deque
//
//**Complexity target**
//
//* `add()` → **O(1)** amortized
//* `getCurrentPrice()` → **O(1)**
//* `getMaxPrice()` → **O(1)**
//* `getMinPrice()` → **O(1)**
//* Space → **O(E)**
//
//`E` = events currently retained in the window.
//


package patterns.stream_processing;

import java.util.*;

public class StockPriceStatisticsUnOrdered {

    private static final int WINDOW = 3600;

    class StockData {

        // timestamp -> prices at that timestamp
        TreeMap<Integer, ArrayList<Integer>> events;

        // price -> number of occurrences
        TreeMap<Integer, Integer> prices;

        int currentPrice;

        StockData() {
            events = new TreeMap<>();
            prices = new TreeMap<>();
        }
    }

    Map<String, StockData> stocks;

    public StockPriceStatisticsUnOrdered() {
        stocks = new HashMap<>();
    }

    public void add(int timestamp, String stockSymbol, int price) {

        StockData stock = stocks.computeIfAbsent(
                stockSymbol,
                key -> new StockData()
        );

        // Store event by timestamp
        stock.events
                .computeIfAbsent(timestamp, key -> new ArrayList<>())
                .add(price);

        // Store price frequency
        stock.prices.put(
                price,
                stock.prices.getOrDefault(price, 0) + 1
        );

        // Current price means latest timestamp
        if (stock.events.lastKey() == timestamp) {
            stock.currentPrice = price;
        }
    }

    private void removeExpired(StockData stock, int timestamp) {

        int startTime = timestamp - WINDOW;

        // Everything before startTime is expired
        NavigableMap<Integer, ArrayList<Integer>> expired =
                stock.events.headMap(startTime, false);

        // Copy timestamps because we modify the original map
        List<Integer> expiredTimestamps =
                new ArrayList<>(expired.keySet());

        for (int expiredTimestamp : expiredTimestamps) {

            ArrayList<Integer> expiredPrices =
                    stock.events.remove(expiredTimestamp);

            for (int price : expiredPrices) {

                int frequency = stock.prices.get(price);

                if (frequency == 1) {
                    stock.prices.remove(price);
                } else {
                    stock.prices.put(price, frequency - 1);
                }
            }
        }
    }

    public int getCurrentPrice(String stockSymbol) {

        return stocks.get(stockSymbol).currentPrice;
    }

    public int getMaxPrice(
            String stockSymbol,
            int timestamp) {

        StockData stock = stocks.get(stockSymbol);

        removeExpired(stock, timestamp);

        return stock.prices.lastKey();
    }

    public int getMinPrice(
            String stockSymbol,
            int timestamp) {

        StockData stock = stocks.get(stockSymbol);

        removeExpired(stock, timestamp);

        return stock.prices.firstKey();
    }

    public static void main(String[] args) {

        StockPriceStatisticsUnOrdered stocks =
                new StockPriceStatisticsUnOrdered();

        // Arrive OUT OF ORDER
        stocks.add(100, "AAPL", 150);
        stocks.add(300, "AAPL", 170);
        stocks.add(200, "AAPL", 140);
        stocks.add(400, "AAPL", 160);

        System.out.println(
                stocks.getMinPrice("AAPL", 400)
        );
        // 140

        System.out.println(
                stocks.getMaxPrice("AAPL", 400)
        );
        // 170
    }
}