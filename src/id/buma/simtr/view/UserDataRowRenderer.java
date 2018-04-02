/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class UserDataRowRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
        setBorder(noFocusBorder);
        TableColumn tc = table.getColumnModel().getColumn(column);
        table.setRowSelectionAllowed(true);
        table.getParent().setBackground(new Color(170,193,193));
        int tableWidth = table.getParent().getWidth();
        switch(column){
            case 0:
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.1*tableWidth));
                break;
            case 1:
                this.setHorizontalAlignment(LEFT);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.4*tableWidth));
                break;
            case 2:
                this.setHorizontalAlignment(LEFT);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.3*tableWidth));
                break;
            case 3:
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.1*tableWidth));
                break;
            case 4:
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.1*tableWidth)+1);
                break;
        }
        if (row % 2 == 0){
            c.setBackground(new Color(205,219,219));
            c.setForeground(Color.DARK_GRAY);
            c.setFont(new Font("Consolas", Font.PLAIN, 12));
        } else {
            c.setBackground(new Color(85,131,131));
            c.setForeground(Color.WHITE);
            c.setFont(new Font("Consolas", Font.PLAIN, 12));
        }
        
        if (isSelected){
            setBackground(new Color(70,70,0));
            setForeground(Color.WHITE);
            c.setFont(new Font("Consolas", Font.PLAIN, 12));
        }
        return c;
    }
    
}
