package texteditor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Gui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gui frame = new Gui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    JButton btnSave = new JButton("Save");
    JButton btnOpen = new JButton("Open");
    JTextPane textPane = new JTextPane();
    String globalSaveName = "";

    public Gui() {



        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {

                // read last saved/opened file and compare to current open file
                String openData = "";
                FileReader lastSavedFile = null;

                if (globalSaveName != "") { // skip all this if no file activity

                    try {
                        lastSavedFile = new FileReader(globalSaveName);
                    } catch (FileNotFoundException e) { e.printStackTrace(); }


                    BufferedReader read = new BufferedReader(lastSavedFile);
                    try {
                        int nLines = numLines();
                        for (int i = 0; i < nLines; i++) {
                            openData = openData + read.readLine() + "\n";
                        }
                    } catch (IOException e) { e.printStackTrace(); }


                    if (openData == textPane.getText()) {
                        dispose();
                    } else {
                        int confirm = JOptionPane.showConfirmDialog(null, "Do you want to exit? You have unsaved changes!", "Confirm exit", JOptionPane.YES_NO_CANCEL_OPTION);

                        if (confirm == JOptionPane.YES_OPTION) {
                            // wants to exit without saving
                            dispose();
                        } else if (confirm == JOptionPane.NO_OPTION) {
                            //wants to save
                            save();
                        }
                    }
                } else if (globalSaveName == "" && !(textPane.getText().isEmpty())) { // new text but not saved yet
                    int confirm = JOptionPane.showConfirmDialog(null, "Do you want to exit? You have unsaved changes!", "Confirm exit", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        // wants to save data
                        save();
                    } else if (confirm == JOptionPane.NO_OPTION) {
                        dispose();
                    } else if (confirm == JOptionPane.CANCEL_OPTION) {

                    }
                }

            }
        });


        setTitle("Text Editor v0.3b");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);


        // initialize everything

        JMenuBar menuBar = new JMenuBar();
        menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        menuBar.setBackground(Color.GRAY);
        setJMenuBar(menuBar);
        btnSave.setBackground(Color.BLACK);

        btnSave.setContentAreaFilled(false); btnSave.setFocusPainted(false);
        menuBar.add(btnSave);
        btnOpen.setContentAreaFilled(false); btnOpen.setFocusPainted(false);
        menuBar.add(btnOpen);

        contentPane.add(scrollPane, BorderLayout.EAST);
        textPane.setBackground(Color.LIGHT_GRAY);


        contentPane.add(textPane, BorderLayout.CENTER);


        // end initalization of everything

        // start of actions

        textPane.addKeyListener(new KeyAdapter() {

            @Override // happens everytime a key is pressed
            public void keyPressed(KeyEvent arg0) {
                // S = 83; O = 79; Ctrl = 2
                if (arg0.getModifiers() == 2) {
                    if (arg0.getKeyCode() == 83) {
                        // Ctrl + S
                        save();
                    }
                    if (arg0.getKeyCode() == 79) {
                        // Ctrl + O
                        open();
                    }
                }

            }
        });


        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {

                save();

            }
        });

        btnOpen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {

                open();

            }
        });

    }

    JFileChooser fc = new JFileChooser();
    private final JScrollPane scrollPane = new JScrollPane();


    public void save() {

        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

        if (fc.showSaveDialog(btnSave) == JFileChooser.APPROVE_OPTION) {
            File saveFile = fc.getSelectedFile();
            globalSaveName = saveFile.getPath();

            try (PrintWriter out = new PrintWriter(saveFile + ".txt")) {
                out.write(textPane.getText());


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public void open() {

        int openResult = fc.showOpenDialog(btnOpen);

        if (openResult == JFileChooser.APPROVE_OPTION) {

            String openData = "";
            FileReader openFile = null;
            try {
                openFile = new FileReader(fc.getSelectedFile());
                globalSaveName = fc.getSelectedFile().getPath();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            BufferedReader in = new BufferedReader(openFile);

            try {
                int nLines = numLines();
                for (int i = 0; i < nLines; i++) {
                    openData = openData + in.readLine() + "\n";
                    textPane.setText(openData);
                }
            } catch (IOException e) {

                e.printStackTrace();
            }


        }
        else if (openResult == JFileChooser.CANCEL_OPTION) {

        }

    }

    public void read() {

        //reads the current file, and saves to openData

        String openData = "";
        FileReader openFile = null;
        try {
            openFile = new FileReader(fc.getSelectedFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader in = new BufferedReader(openFile);

        try {
            int nLines = numLines();
            for (int i = 0; i < nLines; i++) {
                openData = openData + in.readLine() + "\n";

            }
        } catch (IOException e) {

            e.printStackTrace();
        }


    }

    public int numLines() throws IOException {

        FileReader file = new FileReader(fc.getSelectedFile());
        BufferedReader buffer = new BufferedReader(file);

        int numLines = 0;
        @SuppressWarnings("unused") // bitch
                String line;
        while ((line = buffer.readLine()) != null) {
            numLines++;
        }
        buffer.close();
        return numLines;
    }


}
