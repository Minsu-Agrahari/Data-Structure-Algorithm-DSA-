// Time Complexity : O(nlog(n))

/*
Best Case Omega(n log(n)) :
    Building the heap takes O(n) and extracting elements always cost O(log(n)).

Average Case Theta(n log(n)) :
    Heap operations are independents of input order.

Worst Case O(n log(n)) :
    Even in the worst arrangement, heapify and removeal maintain logarithmic time.
 */

package Array.Sorting;
