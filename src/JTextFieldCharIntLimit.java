import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


@SuppressWarnings("serial")
public class JTextFieldCharIntLimit extends PlainDocument{
	private int limit;
	
	public JTextFieldCharIntLimit(int limit) {
		this.limit = limit;
	}
	
	public void insertString(int offset, String str, AttributeSet set) throws BadLocationException {
		if(str == null) {
			return;
		} else if(((getLength() + str.length()) <= limit) && isNumericIntegerNonZero(str)) {
			super.insertString(offset, str, set);
		}
	}
	
	private boolean isNumericIntegerNonZero(String str) {
		try {
			return Integer.parseInt(str) > 0 ? true : false;
		} catch(NumberFormatException nfe) {
			System.out.println("LOG: " + nfe);
			return false;
		}
	}
}
