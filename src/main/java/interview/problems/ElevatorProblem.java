package interview.problems;

/**
 *  Two linked list one for upward direction movement requests and another for downward direction movement request.

 e.g

 First request: a).while lift is on 0th floor and a requests come for 3rd floor.

 linked list for upward movement.

 3->null.

 linked list for downward movement.

 null.

 Second request: b). while lift has moved to 1st floor and a request comes from 2nd floor for upward movement.

 linked list for upward movement.

 2->3->null

 linked list for downward movement.

 null.

 Third request: c) Suppose 2 persons enter on the 2nd floor, one presses button for 5th floor and another for 1st.

 linked list for upward movement.

 3->5->null

 Note: Here 2 has been deleted from upward linked list as it has been reached.

 linked list for downward movement.

 1->null.

 d)Suppose a person enters on 3rd floor and presses button for 0th floor

 linked list for upward movement.

 5->null

 linked list for downward movement.

 1->0->null.

 Once 5th floor iis reached upward requests linked list becomes empty so downwards linked list can be considered for movement.

 If both the linked list are empty then elevator would be at rest.
 */
public class ElevatorProblem {

}
