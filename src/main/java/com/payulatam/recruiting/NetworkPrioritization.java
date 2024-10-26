package com.payulatam.recruiting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NetworkPrioritization {

    public enum Criteria {
        RESPONSE_TIME, COST;
    }

    public int[] prioritizeNetwork(int[] responseTimes, int[] cost, Criteria priority) {
        int n = responseTimes.length;
        List<Integer> index = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            index.add(i);
        }
        NetworkComparator comparator = new NetworkComparator(responseTimes, cost, priority);
        index.sort(comparator);
        return index.stream().mapToInt(Integer::intValue).toArray();
    }
}
