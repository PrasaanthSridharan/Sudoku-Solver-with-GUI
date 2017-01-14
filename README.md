# Sudoku-Solver-with-GUI
**Time to complete**: 8 hours (1 day)

This application solves any solvable Sudoku puzzle of 9x9 grid. This was an experiment to see how convoluted the implementation would be if recursion was NOT used **(Some languages associated with machine learning, like SAP's Event Stream Processing, don't support recursion)**. The obviously efficient implementation would be to use recursion, but the same efficient principles are followed using a do-while loop.
## Solution Demonstration 
###Sample Test Case:  
![alt tag](https://github.com/PrasaanthSridharan/Sudoku-Solver-with-GUI/blob/master/images/TestCase1.png)
###Solved Using This Application:  
![alt tag](https://github.com/PrasaanthSridharan/Sudoku-Solver-with-GUI/blob/master/images/1.1.png) 
![alt tag](https://github.com/PrasaanthSridharan/Sudoku-Solver-with-GUI/blob/master/images/1.2.png)
## Test Cases
### Case 1 (Cannot Solve)
Notice the empty space in the first column. The numbers in this column are 1, 4, 5, _, 2, 7, 8, 9, 6. The missing number is a 3 for this column. However, the 3x3 grid of this empty space already contains a 3. Hence, this puzzle is unsolvable.  
  
![alt tag](https://github.com/PrasaanthSridharan/Sudoku-Solver-with-GUI/blob/master/images/1.3.png)

### Case 2 (Cannot Solve)
This case is similar in that the first column requires a 3, but the 3x3 grid already contains a 3. The first 3 rows have been completed in this example to test the different scenarios of the algorithm.  
  
![alt tag](https://github.com/PrasaanthSridharan/Sudoku-Solver-with-GUI/blob/master/images/1.4.png)

### Case 3 (Cannot Solve)
The problem, in this case, lies with the 6th row and 9th column.  
- **Row 6**:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7, 1, 6, 8, 3, 4, _, _, _  
- **Column 9**:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2, 5, 7, _, _, _, _, _, 9  
- **Associated Grid of Row 6, Column 9**: &nbsp;3, 7  

The part of the puzzle that the program has filled in are definitive and no other numbers can go in those places. At Row 6 and Column 9, there are no possible numbers that can fill the position.  
  
![alt tag](https://github.com/PrasaanthSridharan/Sudoku-Solver-with-GUI/blob/master/images/1.5.png)

### Case 4 (Cannot Solve)
The problem is in the 4th row and 8th column.
- **Row 4**:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3, 5, 4, 1, 2, 7, _, _, _  
- **Column 8**:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;9, 3, 6, _, _, _, _, 8, _  
- **Associated Grid of Row 4, Column 8**: &nbsp;&lt;empty&gt;  

At Row 4 and Column 8, there are no possible numbers that can fill the position.  
  
![alt tag](https://github.com/PrasaanthSridharan/Sudoku-Solver-with-GUI/blob/master/images/1.6.png)

### Case 5 (Solved)
This case is an augmentation of the puzzle presented in **Case 4**. In this case, the initial conditions given to the program have been tinkered, allowing for a solvable Sudoku puzzle.  
  
![alt tag](https://github.com/PrasaanthSridharan/Sudoku-Solver-with-GUI/blob/master/images/1.7d.png)

### Case 6 (Cannot Solve)
The only number that can go in the 4th row is 9, but the 8th column already contains a 9. Hence, this puzzle is unsolvable.  
  
![alt tag](https://github.com/PrasaanthSridharan/Sudoku-Solver-with-GUI/blob/master/images/1.8.png)
