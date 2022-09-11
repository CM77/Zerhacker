package Zerhacker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ZerhackerApp extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	static JFrame jFrame;
	static JButton hackTextBt;
	static JButton restoreOriginalTextBt;
	static JButton emptyTextBt;
	static JLabel label;
	static JTextArea textArea;
	static JPanel panel;
	static String originalText;
	static String hackedText;

	public static void main(String[] args) {

		jFrame = new JFrame("textfield");
		jFrame.setTitle("Zerhacker 1.0.0");

		label = new JLabel();

		hackTextBt = new JButton("hack text");
		restoreOriginalTextBt = new JButton("restore text");
		emptyTextBt = new JButton("empty text");

		ZerhackerApp app = new ZerhackerApp();

		hackTextBt.addActionListener(app);
		restoreOriginalTextBt.addActionListener(app);
		emptyTextBt.addActionListener(app);

		textArea = new JTextArea(22, 35);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);

		JPanel panel = new JPanel();

		panel.add(textArea);
		panel.add(hackTextBt);
		panel.add(restoreOriginalTextBt);
		panel.add(emptyTextBt);
		panel.add(label);

		jFrame.add(panel);
		jFrame.setSize(500, 450);
		jFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("hack text")) {
			originalText = textArea.getText();
			if (checkIfTextAreaIsEmpty()) {
				label.setText(setLabelText(true));
			} else {
				replaceChars();
				textArea.setText(hackedText);
				label.setText(setLabelText(false));
			}
		} else if (s.equals("restore text")) {
			textArea.setText(originalText);
		} else if (s.equals("empty text")) {
			textArea.setText(null);
		}
	}

	private String setLabelText(boolean textAreaEmpty) {
		if (textAreaEmpty) {
			return "Enter original text";
		} else {
			return null;
		}
	}

	private boolean checkIfTextAreaIsEmpty() {
		return originalText.isEmpty();
	}

	private void replaceChars() {
		hackedText = originalText.replace("s", "$");
		hackedText = hackedText.replace("a", " @");
		hackedText = hackedText.replace("e", "€ ");
		hackedText = hackedText.replace("u", "ú,");
		hackedText = hackedText.replace("i", "¡");
		hackedText = hackedText.replace("o", "ø");
	}
}
