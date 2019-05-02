Day76 (2/5/2019): 

Queue:

1. Queue using two stacks (Refer: https://photos.app.goo.gl/GVhR9fpmYNPXa7zi7)

2. Task scheduler: https://leetcode.com/problems/task-scheduler/ (Refer: https://leetcode.com/problems/task-scheduler/discuss/104500/Java-O(n)-time-O(1)-space-1-pass-no-sorting-solution-with-detailed-explanation)
OR priority queue can also be used
a. Assign priority based on occurrences
b. Once a higher priority task is processed increase it's priority to p+n (indicating that it can be processed after cooling time only)
c. After each step reduce the priority by one and continue till all tasks have been processed 
**At the end the size of gantt chart will be the answer**

3. Min max riddle: https://www.hackerrank.com/challenges/min-max-riddle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
4. Deque(Double ended queue): https://www.geeksforgeeks.org/priority-queue-set-1-introduction/