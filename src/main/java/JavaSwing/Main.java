package JavaSwing;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JLabel label=new JLabel();
        label.setText("do you even code");
        label.setHorizontalTextPosition(JLabel.CENTER);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("welcome to Java");
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.add(label);
    }
}