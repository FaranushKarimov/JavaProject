package TextEditor;

import javax.swing.SwingUtilities;

public class TextEditor {
    public static void main(String[] args) {

		/* Start the main dialog. */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);

            }
        });
    }
}