package com.company;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PDGUI extends JFrame {
    // GUI components
    private JLabel nameLabel, numberLabel;
    private JTextField nameText, numberText;
    private JButton previousButton, nextButton, addButton, searchButton, saveButton;
    private JPanel buttonPanel, otherPanel;

    private PhoneDirectory phoneDirectory = new ArrayBasedPD();

    public PDGUI() {
        phoneDirectory.loadData("details.txt");
        buildGUI();

        //populate text boxes with first name/number in list

        PhoneDirectoryEntry entry = phoneDirectory.getFirst();
        if (entry != null) {
            nameText.setText(entry.getName());
            numberText.setText(entry.getNumber());
        }
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == nextButton) {
                PhoneDirectoryEntry entry = phoneDirectory.getNext();
                if (entry != null) {
                    nameText.setText(entry.getName());
                    numberText.setText(entry.getNumber());
                }

            } else if (e.getSource() == previousButton) {
                PhoneDirectoryEntry entry = phoneDirectory.getPrevious();
                if(entry != null)
                {
                    nameText.setText(entry.getName());
                    numberText.setText(entry.getNumber());
                }
                //code to be completed

            } else if (e.getSource() == addButton) {
                String name = JOptionPane.showInputDialog("Enter Name");
                String number = JOptionPane.showInputDialog("Enter Number");
                phoneDirectory.addEntry(name, number);

            } else if (e.getSource() == saveButton) {
                //code to be completed
            } else if (e.getSource() == searchButton) {
                //code to be completed
                String name = JOptionPane.showInputDialog("Enter Name");

                JOptionPane.showMessageDialog(null,"Number for \"" + name.toUpperCase() + "\" is : " + phoneDirectory.search(name));
            }
        }
    }

    private void buildGUI() {
        setTitle("Phone Directory Application");
        setSize(400, 200);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        otherPanel = new JPanel();
        otherPanel.setLayout(new FlowLayout());

        // add panel to frame
        Container c = getContentPane();
        c.add(otherPanel, BorderLayout.CENTER);
        c.add(buttonPanel, BorderLayout.SOUTH);

        nameLabel = new JLabel("Name");
        numberLabel = new JLabel("Number");
        nameText = new JTextField(10);
        numberText = new JTextField(10);

        previousButton = new JButton("Previous");
        nextButton = new JButton("Next");
        addButton = new JButton("Add");
        searchButton = new JButton("Search");
        saveButton = new JButton("Save Directory");

        //add GUI components to panel
        otherPanel.add(nameLabel);
        otherPanel.add(nameText);

        otherPanel.add(numberLabel);
        otherPanel.add(numberText);

        otherPanel.add(previousButton);
        otherPanel.add(nextButton);

        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(saveButton);

        //add action listeners to buttons
        ButtonHandler b = new ButtonHandler();
        previousButton.addActionListener(b);
        nextButton.addActionListener(b);
        addButton.addActionListener(b);
        searchButton.addActionListener(b);
        saveButton.addActionListener(b);
    }
}





