/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcounter;

/**
 *
 * @author ajay_saini
 */

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class WordCounter extends JFrame implements ActionListener {
    private JLabel titleLabel, resultLabel;
    private JTextArea paragraphArea; // Changed to JTextArea
    private JButton countButton;

    public WordCounter() {
        setTitle("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        titleLabel = new JLabel("Enter a paragraph:");
        titleLabel.setBounds(50, 30, 150, 30);
        add(titleLabel);

       paragraphArea = new JTextArea(); // Changed to JTextArea
        JScrollPane scrollPane = new JScrollPane(paragraphArea); // Add JTextArea to JScrollPane
        scrollPane.setBounds(50, 70, 400, 150); // Adjusted position and size of JScrollPane
        add(scrollPane);

        countButton = new JButton("Count Words");
        countButton.setBounds(150, 240, 200, 30);
        countButton.addActionListener(this);
        add(countButton);

        resultLabel = new JLabel();
        resultLabel.setBounds(200, 290, 100, 20);
        add(resultLabel);

        setSize(500, 500);
        setResizable(false);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String paragraph = paragraphArea.getText(); // Retrieve text from JTextArea
            int wordCount = countWords(paragraph);
            resultLabel.setText("Word count: " + wordCount);
        }
    }

    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        new WordCounter();
    }
}

