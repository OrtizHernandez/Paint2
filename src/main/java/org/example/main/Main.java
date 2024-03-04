package org.example.main;

import org.example.Visual.PaintGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new PaintGUI();
                frame.setSize(1000,800);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);

            }
        });
    }
}