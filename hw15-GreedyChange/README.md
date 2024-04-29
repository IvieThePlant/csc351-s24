# Exact Change: Find the minimum number of coins (from a finite list) to make the exact needed change. Note that this is almost identical to your Summer.java code

## Implementation

- Initialization: Create an initialization of a problem that randomly generates the change and list of coins
- Recursive Dynamic Programming Exact Change: Write the recursive version of the exact change problem.
- Iterative Dynamic Programming Exact Change: Write the iterative version of exact change. This can be accomplished with a nested for loop that fills the memoization and choice table row by row.
- Greedy Exact Change: Write a greedy algorithm for exact change. The greedy choice is the largest coin value that does not exceed the remaining needed change. As part of the algorithm, maintain a list of choices. The “cost” is the length of the choices made. You may use any of the Java built-in sorting algorithms.
- Solution of Choices: For the dynamic programming approaches, maintain a table of choices in addition to the memoization table. Generate a list of choices that make up the optimal solution.

You may use any built-in Java data structures and sorting algorithms.
