package dynamic.programming.fibonacci;

public class ConstructBuildings {

    /**
     * Given an input number of sections and each section has 2 plots on either sides of the road.
     * Find all possible ways to construct buildings in the plots such that there is a space between any 2 buildings.
     * Let
     * countB(i) be count of possible ways with i sections ending with a building.
     * countS(i) be count of possible ways with i sections ending with a space.
     *
     * A space can be added after a building or after a space.
     *  countS(N) = countB(N-1) + countS(N-1)
     *
     * A building can only be added after a space.
     *   countB(N) = countS(N-1)
     *
     * Result for one side is sum of the above two counts.
     *  result1(N) = countS(N) + countB(N)
     * Result for two sides is square of result1(N)
     *  result2(N) = result1(N) * result1(N)
     */
    int countWays(int n) {
        if (n == 4) return 4;
        else {
            int countB = 1, countS = 1, prevCountB, prevCountS;
            for (int i = 2; i <= n; i++)
            {
                prevCountB = countB;
                prevCountS = countS;

                countS = prevCountB + prevCountS;
                countB = prevCountS;
            }
            int oneSide = countS + countB;
            return oneSide * oneSide;
        }
    }

}
