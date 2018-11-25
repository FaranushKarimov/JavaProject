package TextEditor;

import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
    public MainFrame() {
        super();

        initMenus();
        initTextPane();

        currDir = System.getProperty("user.dir");

        aboutDialog = new AboutDialog(this);

		/* Default to 1024x576 */
        setSize(1024, 576);

		/* Force setChanged() to update the title. */
        bChanged = true;
        setChanged(false);

        addWindowListener(windowListener);

    }

    private void initMenus() {

		/* Create the menu bar */
        menuBar = new JMenuBar();

        JMenu menu = null;
        JMenuItem menuItem = null;

		/* Set up the "File" menu */
        menu = new JMenu("File");

        menuItem = new JMenuItem("New");
        menuItem.setActionCommand("new");
        menuItem.addActionListener(menuListener);
        menu.add(menuItem);

        menuItem = new JMenuItem("Open");
        menuItem.setActionCommand("open");
        menuItem.addActionListener(menuListener);
        menu.add(menuItem);

        menuItem = new JMenuItem("Save");
        menuItem.setActionCommand("save");
        menuItem.addActionListener(menuListener);
        menu.add(menuItem);

        menuItem = new JMenuItem("Save As");
        menuItem.setActionCommand("saveas");
        menuItem.addActionListener(menuListener);
        menu.add(menuItem);

        menu.addSeparator();

        menuItem = new JMenuItem("Exit");
        menuItem.setActionCommand("exit");
        menuItem.addActionListener(menuListener);
        menu.add(menuItem);

        menuBar.add(menu);

		/* Set up the "Help" menu */
        menu = new JMenu("Help");
        menuItem = new JMenuItem("About");
        menuItem.setActionCommand("help");
        menuItem.addActionListener(menuListener);
        menu.add(menuItem);

        menuBar.add(menu);

        this.setJMenuBar(menuBar);
    }

    private void initTextPane() {

        JScrollPane scrollPane = new JScrollPane();

        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        textArea = new JTextArea("");
        textArea.getDocument().addDocumentListener(documentListener);
        scrollPane.setViewportView(textArea);

        setContentPane(scrollPane);
    }

    private boolean openPrompt() {
        int ret = safeSave();
        if(ret < 0) {
            return true;
        } else if(ret == 0) {
            if(JOptionPane.showConfirmDialog(this,
                    "Error saving. Still open?") != JOptionPane.OK_OPTION) {
                return true;
            }
        }

        JFileChooser fc = new JFileChooser(currDir);
        fc.setMultiSelectionEnabled(false);

		/* If we've cancelled, do nothing. */
        if(fc.showOpenDialog(this) != JFileChooser.APPROVE_OPTION)
            return true;

		/* If we've clicked OK, then open the file. */
        File file = fc.getSelectedFile();
        currDir = file.getParent();

        return loadFile(file);
    }

    private boolean loadFile(File file) {

        System.out.printf("Opening \"%s\"...%s", file.getAbsolutePath(), LS);

		/* So we're not flooded with changes */
        textArea.getDocument().removeDocumentListener(documentListener);

        textArea.setText("");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));

			/* WARNING: This will change the file's line-endings to the system's
			 * native format when you save it. */
            for(String line; (line = reader.readLine()) != null;) {
                textArea.append(line);
                textArea.append(LS);
            }

            this.file = file;
            setTitle(String.format("%s - %s", WINDOW_NAME, getFileName()));
        } catch(IOException e) {
            System.err.printf("ERROR: Unable to open \"%s\": %s%s",
                    file.getAbsolutePath(), e.getMessage(), LS);

            textArea.setText("");
            this.file = null;
            return false;
        } finally {
            textArea.getDocument().addDocumentListener(documentListener);
            try {
                reader.close();
            } catch(IOException x) {
                System.err.printf("FATAL ERROR: Unable to close file: %s%s",
                        x.getMessage(), LS);
            }
        }

        return true;
    }

    private boolean saveAs() {
        JFileChooser fc = new JFileChooser(currDir);
        fc.setMultiSelectionEnabled(false);

		/* If we've cancelled, do nothing. */
        if(fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION)
            return true;

		/* If we've clicked OK, then open the file. */
        File file = fc.getSelectedFile();
        currDir = file.getParent();

        return saveFile(file);
    }

    private int safeSave() {
        if((file != null) || !bChanged)
            return 1;

        Object[] options = {"No", "Cancel", "Yes"};

        int retVal = JOptionPane.showOptionDialog(this,
                String.format("Save changes to %s", getFileName()), "",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[2]);

		/* Yes */
        if(retVal == 2) {
            return (file == null ? saveAs() : saveFile(file)) ? 1 : 0;
		/* No */
        } else if(retVal == 0) {
            return 1;
        }

		/* Cancelled */
        return -1;
    }

    private boolean saveFile(File file) {
        BufferedWriter writer = null;
        boolean closeFailed = false;

        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(textArea.getText());
            this.file = file;
            bChanged = true;
            setChanged(false);
        } catch(IOException e) {
            System.err.printf("ERROR: Unable to save \"%s\": %s%s",
                    file.getAbsolutePath(), e.getMessage(), LS);
            return false;
        } finally {
            try {
                writer.close();
            } catch(IOException x) {
                closeFailed = true;
                System.err.printf("FATAL ERROR: Unable to close file: %s%s",
                        x.getMessage(), LS);
            }
        }


        return !closeFailed;
    }

    private void cleanUp() {
        aboutDialog.setVisible(false);
        aboutDialog.dispose();

        dispose();
    }

    private void setChanged(boolean changed) {
        if(bChanged == changed)
            return;

        if(changed)
            setTitle(String.format("*%s - %s", WINDOW_NAME, getFileName()));
        else
            setTitle(String.format("%s - %s", WINDOW_NAME, getFileName()));

        bChanged = changed;
    }

    private String getFileName() {
        return file != null ? file.getName() : "[New File]";
    }

    private ActionListener menuListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            String cmd = e.getActionCommand();

			/* Basic event handler, pretty straight-forward. */
            if(cmd.equals("new")) {
                if(safeSave() < 0)
                    return;

                file = null;
                bChanged = true;
                setChanged(false);
                textArea.setText("");
            } else if(cmd.equals("open")) {
                openPrompt();
            } else if(cmd.equals("save")) {
                if(file == null) {
                    saveAs();
                } else {
                    saveFile(file);
                }
            } else if(cmd.equals("saveas")) {
                saveAs();
            } else if(cmd.equals("exit")) {
                int ret = safeSave();
                if(ret < 0) {
                    return;
                } else if(ret == 0) {

                    if(JOptionPane.showConfirmDialog(MainFrame.this,
                            "Error saving. Still exit?") != JOptionPane.OK_OPTION) {
                        return;
                    }
                }

                cleanUp();
            } else if(cmd.equals("help")) {
				/* This is a modal dialog, so it will freeze the main GUI */
                aboutDialog.setVisible(true);
            }

        }
    };

    private WindowListener windowListener = new WindowListener() {

        @Override
        public void windowOpened(WindowEvent arg0) { }

        @Override
        public void windowIconified(WindowEvent arg0) { }

        @Override
        public void windowDeiconified(WindowEvent arg0) { }

        @Override
        public void windowDeactivated(WindowEvent arg0) { }

        @Override
        public void windowClosing(WindowEvent arg0) {
			/* If the window's closing, we'd better hope there's no error
			 * whilst saving... */
            safeSave();
            cleanUp();
        }

        @Override
        public void windowClosed(WindowEvent arg0) { }

        @Override
        public void windowActivated(WindowEvent arg0) { }
    };

    private DocumentListener documentListener = new DocumentListener() {

        @Override
        public void removeUpdate(DocumentEvent e) {
            setChanged(true);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            setChanged(true);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            setChanged(true);
        }
    };

    private JMenuBar menuBar;
    private JTextArea textArea;
    private String currDir;
    private boolean bChanged;
    private File file;
    private AboutDialog aboutDialog;

    private static final String WINDOW_NAME = "Example Text Editor";
    private static final String LS = System.getProperty("line.separator");
}