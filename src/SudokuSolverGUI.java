import javax.swing.SwingUtilities;

public class SudokuSolverGUI {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI.createAndShowGUI();
            }
        });
	}
}
