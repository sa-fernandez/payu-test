package com.payulatam.recruiting;

import java.util.Comparator;

import com.payulatam.recruiting.NetworkPrioritization.Criteria;

public class NetworkComparator implements Comparator<Integer> {

    private int[] responseTimes;
    private int[] costs;
    private Criteria criteria;

    public NetworkComparator(int[] responseTimes, int[] cost, Criteria criteria) {
        this.responseTimes = responseTimes;
        this.costs = cost;
        this.criteria = criteria;
    }

    @Override
    public int compare(Integer i, Integer j) {
        if(this.criteria == Criteria.RESPONSE_TIME) {
            int result = Integer.compare(responseTimes[i], responseTimes[j]);
            return (result != 0) ? result : Integer.compare(costs[i], costs[j]);
        } else {
            int result = Integer.compare(costs[i], costs[j]);
            return (result != 0) ? result : Integer.compare(responseTimes[i], responseTimes[j]);
        }
    }

}