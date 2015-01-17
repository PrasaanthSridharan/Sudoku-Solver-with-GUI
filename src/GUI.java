import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener {

	JPanel titlePanel, sudokuPanel, statusPanel, buttonPanel;
	JLabel sudokuTitle, statusLabel;
	static JLabel statusIndicatorLabel;
	JButton clearButton, solveButton;
	static JTextField[][] sudokuGrid = new JTextField[9][9];
	private static boolean hasRun = false;

	private Line2D createLine(int x1, int y1, int x2, int y2) {
		Line2D line = new Line2D.Double(x1, y1, x2, y2);
		return line;
	}

	public JPanel createContentPane() {
		// We create a bottom JPanel to place everything on.
		JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null);

		// Creation of a Panel to contain the title labels
		titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setLocation(0, 0);
		titlePanel.setSize(415, 50);
		titlePanel.setBackground(Color.white);
		totalGUI.add(titlePanel);
		
		sudokuTitle = new JLabel("Sudoku Solver");
		sudokuTitle.setSize(415, 50);
		sudokuTitle.setFont(new Font("Arial", Font.BOLD, 40));
		sudokuTitle.setHorizontalAlignment(JLabel.CENTER);
		sudokuTitle.setForeground(Color.black);
        titlePanel.add(sudokuTitle);

		// Creation of a Panel to contain the Sudoku grids
		sudokuPanel = new JPanel() {
			public void paintComponent( Graphics g ) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;
                
                g2.setColor(Color.gray);
                g2.setStroke(new BasicStroke(2));
                
                // Vertical Thin Lines
                g2.draw(createLine(47, 0, 47, 407));
                g2.draw(createLine(92, 0, 92, 407));
                g2.draw(createLine(182, 0, 182, 407));
                g2.draw(createLine(227, 0, 227, 407));
                g2.draw(createLine(317, 0, 317, 407));
                g2.draw(createLine(362, 0, 362, 407));
                
                // Horizontal Thin Lines
                g2.draw(createLine(0, 47, 407, 47));
                g2.draw(createLine(0, 92, 407, 92));
                g2.draw(createLine(0, 182, 407, 182));
                g2.draw(createLine(0, 227, 407, 227));
                g2.draw(createLine(0, 317, 407, 317));
                g2.draw(createLine(0, 362, 407, 362));
                
                g2.setColor(Color.black);
                g2.setStroke(new BasicStroke(4));
                
                // Vertical Thick Lines
                g2.draw(createLine(2, 0, 2, 407));
                g2.draw(createLine(137, 0, 137, 407));
                g2.draw(createLine(272, 0, 272, 407));
                g2.draw(createLine(407, 0, 407, 407));
                
                // Horizontal Thick Lines
                g2.draw(createLine(0, 2, 410, 2));
                g2.draw(createLine(0, 137, 407, 137));
                g2.draw(createLine(0, 272, 407, 272));
                g2.draw(createLine(0, 407, 407, 407));
			}
		};
		sudokuPanel.setLayout(null);
		sudokuPanel.setLocation(0, 50);
		sudokuPanel.setSize(415,415);
		sudokuPanel.setBackground(Color.white);
		totalGUI.add(sudokuPanel);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sudokuGrid[i][j] = new JTextField();
				sudokuGrid[i][j].setDocument(new JTextFieldCharIntLimit(1));
				sudokuGrid[i][j].setHorizontalAlignment(JTextField.CENTER);
				sudokuGrid[i][j].setLocation(((i)*40+(5*(i+1))),((j)*40+(5*(j+1))));
				sudokuGrid[i][j].setSize(40,40);
				sudokuGrid[i][j].setFont(new Font("Arial", Font.PLAIN, 30));
				sudokuPanel.add(sudokuGrid[i][j]);
			}
		}
		// Creation of a Panel to contain puzzle's solved status
		statusPanel = new JPanel();
		statusPanel.setLayout(null);
		statusPanel.setLocation(0, 465);
		statusPanel.setSize(415, 60);
		statusPanel.setBackground(Color.white);
		totalGUI.add(statusPanel);
        
		statusLabel = new JLabel("Status: ");
		statusLabel.setSize(67, 30);
		statusLabel.setLocation(15, 0);
		statusLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		statusLabel.setHorizontalAlignment(JLabel.LEFT);
		statusPanel.add(statusLabel);
		
		statusIndicatorLabel = new JLabel("Awaiting for user to click solve...");
		statusIndicatorLabel.setSize(333, 30);
		statusIndicatorLabel.setLocation(82, 0);
		statusIndicatorLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		statusIndicatorLabel.setHorizontalAlignment(JLabel.LEFT);
		statusPanel.add(statusIndicatorLabel);

		// Creation of a Panel to contain all the JButtons
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setLocation(0, 510);
		buttonPanel.setSize(415, 100);
		buttonPanel.setBackground(Color.white);
		totalGUI.add(buttonPanel);		
		
		solveButton = new JButton("Solve");
		solveButton.setLocation(10, 15);
		solveButton.setSize(190,55);
		solveButton.setBackground(new Color(97, 121, 173));
		solveButton.setForeground(Color.white);
		solveButton.setFocusPainted(false);
		solveButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		solveButton.addActionListener(this);
		buttonPanel.add(solveButton);
		
		clearButton = new JButton("Clear");
		clearButton.setLocation(210, 15);
		clearButton.setSize(190,55);
		clearButton.setBackground(new Color(97, 121, 173));
		clearButton.setForeground(Color.white);
		clearButton.setFocusPainted(false);
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		clearButton.addActionListener(this);
		buttonPanel.add(clearButton);
		
		totalGUI.setOpaque(true);
		return totalGUI;
	}

	public static void createAndShowGUI() {
		if (!hasRun) {
			hasRun = true;

			JFrame.setDefaultLookAndFeelDecorated(false);
			JFrame frame = new JFrame("Sudoku Solver");

			// Create and set up the content pane.
			GUI gui = new GUI();
			frame.setContentPane(gui.createContentPane());

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(415, 615);
			frame.setResizable(false);
			frame.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		
		if(source == solveButton) {
			if(isValidPuzzle(sudokuGrid)) {
				SudokuSolver.solveSudokuPuzzle();
			}
			else {
				statusIndicatorLabel.setText("Invalid sudoku puzzle entered");
			}
		} else if(source == clearButton) {
			for(int i = 0; i < 9; i ++) {
				for(int j = 0; j < 9; j++) {
					sudokuGrid[i][j].setText(null);
					sudokuGrid[i][j].setForeground(Color.black);
					sudokuGrid[i][j].setBackground(Color.white);
					statusIndicatorLabel.setText("Awaiting for user to click solve...");
				}
			}
		} 
	}

	private static boolean isValidPuzzle(JTextField[][] grid) {
		boolean isValid = true;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				GUI.sudokuGrid[i][j].setForeground(Color.black);
				GUI.sudokuGrid[i][j].setBackground(Color.white);
				if(!grid[i][j].getText().equals(null) && !grid[i][j].getText().equals("")){
					GUI.sudokuGrid[i][j].setBackground(new Color(197, 192, 248));
					
					// Horizontal
					for (int k = 0; k < 9; k++) {
						if(grid[i][j].getText().equals(grid[i][k].getText()) && j != k) {
							GUI.sudokuGrid[i][j].setForeground(Color.red);
							GUI.sudokuGrid[i][k].setForeground(Color.red);
							isValid = false;
						}
					}
	
					// Vertical
					for (int k = 0; k < 9; k++) {
						if(grid[i][j].getText().equals(grid[k][j].getText()) && i != k) {
							GUI.sudokuGrid[i][j].setForeground(Color.red);
							GUI.sudokuGrid[k][j].setForeground(Color.red);
							isValid = false;
						}
					}
	
					// Square Grid
					for (int m = ((i / 3) * 3); m < (((i / 3) * 3) + 3); m++) {
						for (int n = ((j / 3) * 3); n < (((j / 3) * 3) + 3); n++) {
							if(grid[i][j].getText().equals(grid[m][n].getText()) && i != m && j != n) {
								GUI.sudokuGrid[i][j].setForeground(Color.red);
								GUI.sudokuGrid[m][n].setForeground(Color.red);
								isValid = false;
							}
						}
					}
				}
			}
		}
		
		return isValid;
	}
}
