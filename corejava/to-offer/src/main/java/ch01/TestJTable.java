package ch01;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TestJTable {


    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        DefaultTableModel model = new DefaultTableModel(1, 5);
        JTable jTable1 = new JTable(model);
        jframe.add(jTable1);
        jframe.setBounds(50, 50, 800, 600);
        jframe.setVisible(true);


    }

}
