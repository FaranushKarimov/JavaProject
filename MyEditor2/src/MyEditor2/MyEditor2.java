package MyEditor2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import javax.swing.undo.*;
import javax.swing.event.*;
import javax.swing.text.DefaultEditorKit.*;
import javax.swing.text.StyledEditorKit.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class MyEditor2 {


    private JFrame frame__;
    private JTextPane editor__;
    private UndoManager undoMgr__;

    private static final String MAIN_TITLE = "My Editor 2";
    private static final String DEFAULT_FONT_FAMILY = "SansSerif";
    private static final int DEFAULT_FONT_SIZE = 18;


    public static void main(String [] args)
            throws Exception {

        UIManager.put("TextPane.font",
                new Font(DEFAULT_FONT_FAMILY, Font.PLAIN, DEFAULT_FONT_SIZE));
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                new MyEditor2().createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {

        frame__ = new JFrame(MAIN_TITLE);
        editor__ = new JTextPane();
        JScrollPane editorScrollPane = new JScrollPane(editor__);

        editor__.setDocument(new DefaultStyledDocument());

        undoMgr__ = new UndoManager();
        getEditorDocument().addUndoableEditListener(new UndoEditListener());

        EditButtonActionListener editButtonActionListener = new EditButtonActionListener();

        JButton cutButton = new JButton(new CutAction());
        cutButton.setHideActionText(true);
        cutButton.setText("Cut");
        cutButton.addActionListener(editButtonActionListener);
        JButton copyButton = new JButton(new CopyAction());
        copyButton.setHideActionText(true);
        copyButton.setText("Copy");
        copyButton.addActionListener(editButtonActionListener);
        JButton pasteButton = new JButton(new PasteAction());
        pasteButton.setHideActionText(true);
        pasteButton.setText("Paste");
        pasteButton.addActionListener(editButtonActionListener);

        JButton boldButton = new JButton(new BoldAction());
        boldButton.setHideActionText(true);
        boldButton.setText("Bold");
        boldButton.addActionListener(editButtonActionListener);
        JButton italicButton = new JButton(new ItalicAction());
        italicButton.setHideActionText(true);
        italicButton.setText("Italic");
        italicButton.addActionListener(editButtonActionListener);
        JButton underlineButton = new JButton(new UnderlineAction());
        underlineButton.setHideActionText(true);
        underlineButton.setText("Underline");
        underlineButton.addActionListener(editButtonActionListener);

        JButton colorButton = new JButton("Set Color");
        colorButton.addActionListener(new ColorActionListener());

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(new UndoActionListener("UNDO"));
        JButton redoButton = new JButton("Redo");
        redoButton.addActionListener(new UndoActionListener("REDO"));

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(cutButton);
        panel1.add(copyButton);
        panel1.add(pasteButton);
        panel1.add(new JSeparator(SwingConstants.VERTICAL));
        panel1.add(boldButton);
        panel1.add(italicButton);
        panel1.add(underlineButton);
        panel1.add(new JSeparator(SwingConstants.VERTICAL));
        panel1.add(colorButton);
        panel1.add(new JSeparator(SwingConstants.VERTICAL));
        panel1.add(undoButton);
        panel1.add(redoButton);

        JPanel toolBarPanel = new JPanel();
        toolBarPanel.setLayout(new BoxLayout(toolBarPanel, BoxLayout.PAGE_AXIS));
        toolBarPanel.add(panel1);

        frame__.add(toolBarPanel, BorderLayout.NORTH);
        frame__.add(editorScrollPane, BorderLayout.CENTER);

        frame__.setSize(900, 500);
        frame__.setLocation(150, 80);
        frame__.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame__.setVisible(true);

        editor__.requestFocusInWindow();
    }

    private StyledDocument getEditorDocument() {

        StyledDocument doc = (DefaultStyledDocument) editor__.getDocument();
        return doc;
    }

    private class EditButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            editor__.requestFocusInWindow();
        }
    }

    private class ColorActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Color newColor = JColorChooser.showDialog(frame__, "Choose a color",
                    Color.BLACK);
            if (newColor == null) {

                editor__.requestFocusInWindow();
                return;
            }

            SimpleAttributeSet attr = new SimpleAttributeSet();
            StyleConstants.setForeground(attr, newColor);
            editor__.setCharacterAttributes(attr, false);
            editor__.requestFocusInWindow();
        }
    }

    private class UndoEditListener implements UndoableEditListener {

        @Override
        public void undoableEditHappened(UndoableEditEvent e) {

            undoMgr__.addEdit(e.getEdit()); // remember the edit
        }
    }

    private class UndoActionListener implements ActionListener {

        private String type;

        public UndoActionListener(String type) {

            this.type = type;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (type) {

                case "UNDO":
                    if (! undoMgr__.canUndo()) {

                        editor__.requestFocusInWindow();
                        return; // no edits to undo
                    }

                    undoMgr__.undo();
                    break;

                case "REDO":
                    if (! undoMgr__.canRedo()) {

                        editor__.requestFocusInWindow();
                        return; // no edits to redo
                    }

                    undoMgr__.redo();
            }

            editor__.requestFocusInWindow();
        }
    } // UndoActionListener
}
