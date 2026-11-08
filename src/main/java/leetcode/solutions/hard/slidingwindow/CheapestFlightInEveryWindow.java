package leetcode.solutions.hard.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Problem: Cheapest Flight in Every Window.
 * An API getFlights(startDay, endDay) returns a map from day to that day's flight record; only "price" matters.
 * For every window of dayRange consecutive days within [startDay, endDay], return the cheapest day and its price,
 * keyed by "start-end". Ties go to the earliest day.
 * 
 * Example: prices {3:100, 4:300, 5:500, 6:200, 7:400, 8:100}, getCheapestFlights(3, 3, 8) ->
 * {"3-5": {day:3, price:100}, "4-6": {day:6, price:200}, "5-7": {day:6, price:200}, "6-8": {day:8, price:100}}
 *
 * Pattern: Sliding Window (monotonic deque)
 * Time complexity: O(n), each day is pushed and popped from the deque at most once.
 * Space complexity: O(n) for the prices, the deque never holds more than dayRange entries at once.
 */

public class CheapestFlightInEveryWindow {
    // Stub of the provided API (the real one calls a service).
    private final Map<Integer, Map<String, Integer>> data;
    private static final String PRICE = "price";

    public CheapestFlightInEveryWindow(Map<Integer, Map<String, Integer>> data) {
        this.data = data;
    }

    public Map<Integer, Map<String, Integer>> getFlights(int startDay, int endDay) {
        Map<Integer, Map<String, Integer>> out = new HashMap<>();
        for (int d = startDay; d <= endDay; d++) {
            if (data.containsKey(d)) out.put(d, data.get(d));
        }
        return out;
    }

    public Map<String, Map<String, Integer>> getCheapestFlights(int dayRange, int startDay, int endDay) {
        if (dayRange <= 0) throw new IllegalArgumentException("dayRange must be positive");
        
        // LinkedHashMap preserves insertion order, which we need as
        // windows are inserted chronologically: 3-5, 4-6, 5-7, 6-8.
        Map<String, Map<String, Integer>> res = new LinkedHashMap<>();

        // Total number of days between startDay and endDay, inclusive.
        int span = endDay - startDay + 1;
        
        // Fetch flights data from an API.
        Map<Integer, Map<String, Integer>> flights = getFlights(startDay, endDay);
        
        // `prices` will contain the price of the flight on the ith day.
        int[] prices = new int[span];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < span; i++) {
            // Fetch flight on the current day.
            Map<String, Integer> flightMap = flights.get(startDay + i);

            if (flightMap != null && flightMap.get(PRICE) != null) {
                int price = flightMap.get(PRICE);
                prices[i] = price;

                // If price is smaller than current prices stored in queue, remove them, 
                // as they are not needed anymore in the window.
                while (!dq.isEmpty() && prices[dq.peekLast()] > price) dq.removeLast();
                dq.addLast(i);
            }
            
            int windowStart = i - dayRange + 1;
            // Fetch smallest price and create output for the current dayRange.
            if (i + 1 >= dayRange) {
                // Remove from queue days that 'fell out' of the window.
                while (!dq.isEmpty() && dq.peekFirst() < windowStart) dq.removeFirst();

                if (!dq.isEmpty()) {
                    int best = dq.peekFirst();
                    res.put((startDay + windowStart) + "-" + (startDay + i),
                            Map.of("day", startDay + best, PRICE, prices[best]));
                }
            }
        }
        return res;
    }
}
