package TextEditor;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

@SuppressWarnings("serial")
public class AboutDialog extends JDialog {

    public AboutDialog(JFrame owner) {
        super(owner, "About", true);

        setSize(400, 250);
        setResizable(false);

		/* By default, the frame uses a BorderLayout with the content pane
		 * set to BorderLayout.CENTER to make it fill the entire frame.
		 * Everything inside the content pane, however is done using
		 * GridBagLayout. */

        GridBagConstraints gbc = new GridBagConstraints();

		/* Create the content pane and setup the GridBagLayout */
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);

		/* Attempt to display the icon.
		 * Taken from:
		 * http://goldenmercurydragon.deviantart.com/art/Day-and-Night-215253122
		 */
        URL url = getClass().getResource("D:/Архив/Java-технологии Байрашева/icon.png");
        if(url != null) {
            contentPane.add(new JLabel(new ImageIcon(url)), gbc);
            ++gbc.gridy;
        } else {
            System.err.printf("WARNING: Unable to find icon.png...\n");
        }

		/* Add the main text. */
        JLabel text = new JLabel("Example Text Editor");
        text.setFont(new Font(text.getFont().getName(), Font.BOLD, 25));
        contentPane.add(text, gbc);
        ++gbc.gridy;

		/* Add the description. */
        text = new JLabel("An example on how to use Java GUIs!");
        contentPane.add(text, gbc);
        ++gbc.gridy;

		/* Add the copyright notice. */
        text = new JLabel("Copyright (C) 2014 Zane van Iperen");
        contentPane.add(text, gbc);
        ++gbc.gridy;

		/* Create the OK button and anchor it to the bottom of the frame. */
        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(buttonListener);
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.weightx = 1.0f;
        gbc.weighty = 1.0f;
        gbc.insets = new Insets(0, 0, 15, 0);
        contentPane.add(okBtn, gbc);
        ++gbc.gridy;

        setContentPane(contentPane);

    }

    private ActionListener buttonListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            AboutDialog.this.setVisible(false);
        }
    };
}
