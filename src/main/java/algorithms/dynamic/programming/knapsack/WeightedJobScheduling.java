package algorithms.dynamic.programming.knapsack;

import java.util.Arrays;

public class WeightedJobScheduling {

    /**
     * Given N jobs where every job is represented by following three elements of it.
     1. Start Time
     2. Finish Time
     3. Profit or Value Associated
     Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
     */

    class Job implements Comparable<Job>{

        int start;
        int finish;
        int profit;

        Job(int start, int finish, int profit) {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }

        public int compareTo(Job job) {
            return job.finish - this.finish;
        }

    }

    int maxProfit(Job[] jobs) {
        Arrays.sort(jobs);
        return maxProfitRec(jobs, jobs.length);
    }

    int maxProfitRec(Job[] jobs, int n) {
        if (n == 1) return jobs[0].profit;
        else {
            int excluded = maxProfitRec(jobs, n-1);
            int included = jobs[n-1].profit;
            int j = nextValidJobIndex(jobs,n-1);
            if (j > 0) included += maxProfitRec(jobs,j+1);
            return Math.max(excluded, included);
        }
    }

    int nextValidJobIndex(Job[] jobs, int i) {
        for (int j = i - 1; j >= 0; j++) {
            if (jobs[j].finish < jobs[i].start) return j;
        }
        return -1;
    }

}
