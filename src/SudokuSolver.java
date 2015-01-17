import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextField;


public abstract class SudokuSolver {

	public static void solveSudokuPuzzle(){
		Integer[][] sudoku = new Integer[9][9];
		ArrayList<Integer> choices = new ArrayList<Integer>(Arrays.asList(1, 2,
				3, 4, 5, 6, 7, 8, 9));
		boolean sudokuSolved = true;
		ArrayList<Integer[][]> sudoku_ghost = new ArrayList<Integer[][]>();
		int leastChoicesAvailable = 9;
		boolean guess = false;
		boolean hasGuessMade = false;
		ArrayList<Integer[]> guessMade = new ArrayList<Integer[]>();
		
		for(int i = 0; i < 9; i ++) {
			for(int j = 0; j < 9; j++) {
				try {
					sudoku[i][j] = Integer.parseInt(GUI.sudokuGrid[j][i].getText());
				} catch(Exception e) {
					sudoku[i][j] = 0;
				}
			}	
		}
		outerloop: do {
			sudokuSolved = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (sudoku[i][j] == 0) {
						// Horizontal
						for (int k = 0; k < 9; k++) {
							choices.remove((Integer) sudoku[i][k]);
						}

						// Vertical
						for (int k = 0; k < 9; k++) {
							choices.remove((Integer) sudoku[k][j]);
						}

						// Square Grid
						for (int m = ((i / 3) * 3); m < (((i / 3) * 3) + 3); m++) {
							for (int n = ((j / 3) * 3); n < (((j / 3) * 3) + 3); n++) {
								choices.remove((Integer) sudoku[m][n]);
							}
						}

						if (choices.size() == leastChoicesAvailable) {
							if (guess) {
								guess = false;
								hasGuessMade = true;
								for (int p = 0; p < guessMade.size(); p++) {
									if (guessMade.get(p)[0] == i
											&& guessMade.get(p)[1] == j) {
										choices.remove(guessMade.get(p)[2]);
									}
								}

								if (choices.size() > 1) { // Make guess if more
															// choices still
															// exist
									Integer[][] temp_ghost = new Integer[9][9];
									for (int m = 0; m < 9; m++) {
										for (int n = 0; n < 9; n++) {
											temp_ghost[m][n] = sudoku[m][n];
										}
									}
									sudoku_ghost.add(temp_ghost);
									
									Integer[] tempGuess = null;
									if(sudoku_ghost.size() > 1) {
										tempGuess = new Integer[] { i, j,
												choices.get(0), sudoku_ghost.size()-1 };
									} else {
										tempGuess = new Integer[]{ i, j,
												choices.get(0), 0 };
									}

									guessMade.add(tempGuess);
								}
								sudoku[i][j] = choices.get(0);
							}
						}
						
						if (leastChoicesAvailable > choices.size()) {
							leastChoicesAvailable = choices.size();
						}
						
						if (choices.size() == 1) {
							sudoku[i][j] = choices.get(0);
						} else if (choices.size() == 0) {
							sudokuSolved = false;

							if (sudoku_ghost.size() == 0) {
								break outerloop;
							} else {
								for (int m = 0; m < 9; m++) {
									for (int n = 0; n < 9; n++) {
										sudoku[m][n] = sudoku_ghost
												.get(sudoku_ghost.size() - 1)[m][n];
									}
								}
								
								for (int m = guessMade.size()-1; m >= 0; m--) {
									if(guessMade.get(m)[3] >= sudoku_ghost.size()) {
										guessMade.remove(m);
									}
								}

								sudoku_ghost.remove(sudoku_ghost.size() - 1);
							}
						} else {
							sudokuSolved = false;
						}
						choices = new ArrayList<Integer>(Arrays.asList(1, 2, 3,
								4, 5, 6, 7, 8, 9));

					}
				}
			}

			if (leastChoicesAvailable > 1 && hasGuessMade) {
				leastChoicesAvailable = 9;
				hasGuessMade = false;
			} else if (leastChoicesAvailable < 2) {
				leastChoicesAvailable = 9;
			} else if (leastChoicesAvailable > 1) {
				guess = true;
			}
		} while (!sudokuSolved);
		
		for(int i = 0; i < 9; i ++) {
			for(int j = 0; j < 9; j++) {
				GUI.sudokuGrid[j][i].setText(String.valueOf(sudoku[i][j]));
			}
		}
		
		GUI.statusIndicatorLabel.setText(sudokuSolved ? "Solved" : "Cannot Solve");
	}
}
