package leetcode.solutions.medium.slidingwindow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Problem: Cheapest Flight in Every Window (not on LeetCode).
 * An API getFlights(startDay, endDay) returns a map from day to that day's flight record; only "price" matters.
 * For every window of dayRange consecutive days within [startDay, endDay], return the cheapest day and its price,
 * keyed by "start-end". Ties go to the earliest day.
 * Example: prices {3:100, 4:300, 5:500, 6:200, 7:400, 8:100}, getCheapestFlights(3, 3, 8) ->
 * {"3-5": {day:3, price:100}, "4-6": {day:6, price:200}, "5-7": {day:6, price:200}, "6-8": {day:8, price:100}}
 *
 * Pattern: Sliding Window (monotonic deque)
 * Time complexity: O(n), each day is pushed and popped from the deque at most once.
 * Space complexity: O(n) for the prices, the deque never holds more than dayRange entries at once.
 * Note: windows are calendar windows [d, d + dayRange - 1], so a missing day doesn't silently stretch a window.
 * Windows with no flights at all are omitted.
 */

public class CheapestFlightInEveryWindow {
    // Stub of the provided API (the real one calls a service).
    private final Map<Integer, Map<String, Integer>> data;

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
        Map<String, Map<String, Integer>> res = new LinkedHashMap<>();
        int span = endDay - startDay + 1;
        if (span < dayRange) return res;

        Map<Integer, Map<String, Integer>> flights = getFlights(startDay, endDay);

        // No sort needed: day numbers are dense integers, so we index by offset from startDay.
        int[] price = new int[span];
        int[] dq = new int[span]; // offsets, prices strictly increasing front -> back
        int head = 0, tail = 0;

        for (int i = 0; i < span; i++) {
            Map<String, Integer> f = flights.get(startDay + i);
            if (f != null && f.get("price") != null) {
                int p = f.get("price");
                price[i] = p;
                // Strict '>' keeps an earlier equal price in front: earliest-day tie-break.
                while (tail > head && price[dq[tail - 1]] > p) tail--;
                dq[tail++] = i;
            }

            int windowStart = i - dayRange + 1;
            if (windowStart < 0) continue;

            // Expire days that fell out of the window on the left.
            while (head < tail && dq[head] < windowStart) head++;
            if (head < tail) {
                int best = dq[head];
                res.put((startDay + windowStart) + "-" + (startDay + i),
                        Map.of("day", startDay + best, "price", price[best]));
            }
        }
        return res;
    }
}
