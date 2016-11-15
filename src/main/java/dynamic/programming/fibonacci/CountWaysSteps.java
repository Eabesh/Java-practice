package dynamic.programming.fibonacci;

public class CountWaysSteps {

    /**
     * Count ways to reach the n’th stair. There are n stairs, a person standing at the bottom wants to reach the top.
     * The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.
     */
    int count(int n) {
        return new Fibonacci().fib(n+1);
    }

}
