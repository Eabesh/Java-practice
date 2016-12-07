package algorithms.greedy;

import java.util.Arrays;
import java.util.Vector;

public class ActivitySelectionProblem {

    /**
     * You are given n activities with their start and finish times. Select the maximum number of activities that can
     * be performed by a single person, assuming that a person can only work on a single activity at a time.
     * Consider the following 6 activities.
        start[]  =  {1, 3, 0, 5, 8, 5};
        finish[] =  {2, 4, 6, 7, 9, 9};
     The maximum set of activities that can be executed by a single person is {0, 1, 3, 4}
     */
    class Activity implements Comparable<Activity> {

        int start;
        int finish;

        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        public int compareTo(Activity activity) {
            return this.finish - finish;
        }

    }

    Vector<Activity> activity(int[] start, int[] finish) {
        Activity[] activities = new Activity[start.length];
        for (int i = 0; i < start.length; i++) activities[i] = new Activity(start[i], finish[i]);
        Arrays.sort(activities);
        Vector<Activity> result = new Vector<Activity>();
        result.add(activities[0]);
        for (int j = 1; j < activities.length; j++) {
            if (activities[j].start > activities[j-1].finish) result.add(activities[j]);
        }
        return result;
    }

}
