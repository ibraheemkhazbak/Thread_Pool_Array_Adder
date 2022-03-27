package com.khazbak.display;

import com.khazbak.thread.OtherThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    JPanel panel;
    JLabel result;
    private static final String CALCULATE_BUTTON_NAME ="calculate_button";
    public Window(){
        initializeWindow();
        addComponents();
    }

    private void initializeWindow() {
        setVisible(true);
        setSize(new Dimension(600,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        add(panel);
    }

    private void addComponents() {
        result=new JLabel("Nan");
        JButton calculate = new JButton("Calculate");
        calculate.setName(CALCULATE_BUTTON_NAME);
        calculate.addActionListener(this);
        panel.add(result);
        panel.add(calculate);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
      JButton button =  (JButton) e.getSource();
      if(button.getName().equals(CALCULATE_BUTTON_NAME)){
          Thread otherThread = new OtherThread(result);
          otherThread.start();
      }
    }
}
