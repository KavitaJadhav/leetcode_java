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

public class StockPriceStatistics {

    private static final int WINDOW = 3600;

    class StockData {
        Queue<int[]> events;

        Deque<int[]> maximumPrices;
        Deque<int[]> minimumPrices;

        int currentPrice;

        StockData() {
            events = new LinkedList<>();
            maximumPrices = new ArrayDeque<>();
            minimumPrices = new ArrayDeque<>();
        }
    }

    Map<String, StockData> stocks;

    public StockPriceStatistics() {
        stocks = new HashMap<>();
    }

    public void add(int timestamp, String stockSymbol, int price) {

        StockData stock = stocks.computeIfAbsent(
                stockSymbol,
                key -> new StockData()
        );

        stock.events.offer(new int[]{timestamp, price});
        stock.currentPrice = price;

        // Maintain decreasing deque for maximum
        while (!stock.maximumPrices.isEmpty()
                && stock.maximumPrices.peekLast()[1] <= price) {

            stock.maximumPrices.pollLast();
        }

        stock.maximumPrices.offerLast(new int[]{timestamp, price});

        // Maintain increasing deque for minimum
        while (!stock.minimumPrices.isEmpty()
                && stock.minimumPrices.peekLast()[1] >= price) {

            stock.minimumPrices.pollLast();
        }

        stock.minimumPrices.offerLast(new int[]{timestamp, price});
    }

    private void removeExpired(StockData stock, int timestamp) {

        int startTime = timestamp - WINDOW;

        while (!stock.events.isEmpty()
                && stock.events.peek()[0] < startTime) {

            int[] expiredEvent = stock.events.poll();
            int expiredTimestamp = expiredEvent[0];

            if (!stock.maximumPrices.isEmpty()
                    && stock.maximumPrices.peekFirst()[0] == expiredTimestamp) {

                stock.maximumPrices.pollFirst();
            }

            if (!stock.minimumPrices.isEmpty()
                    && stock.minimumPrices.peekFirst()[0] == expiredTimestamp) {

                stock.minimumPrices.pollFirst();
            }
        }
    }

    public int getCurrentPrice(String stockSymbol) {

        return stocks.get(stockSymbol).currentPrice;
    }

    public int getMaxPrice(String stockSymbol, int timestamp) {

        StockData stock = stocks.get(stockSymbol);

        removeExpired(stock, timestamp);

        return stock.maximumPrices.peekFirst()[1];
    }

    public int getMinPrice(String stockSymbol, int timestamp) {

        StockData stock = stocks.get(stockSymbol);

        removeExpired(stock, timestamp);

        return stock.minimumPrices.peekFirst()[1];
    }

    public static void main(String[] args) {

        StockPriceStatistics stockPrices =
                new StockPriceStatistics();

        stockPrices.add(100, "AAPL", 150);
        stockPrices.add(200, "AAPL", 160);
        stockPrices.add(300, "AAPL", 140);
        stockPrices.add(400, "AAPL", 170);

        System.out.println(
                stockPrices.getCurrentPrice("AAPL")
        );
        // 170

        System.out.println(
                stockPrices.getMaxPrice("AAPL", 400)
        );
        // 170

        System.out.println(
                stockPrices.getMinPrice("AAPL", 400)
        );
        // 140
    }
}