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
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.LEFT;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class PetaniRowRenderer extends DefaultTableCellRenderer implements TableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column){
        Component c = super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
        TableColumn tc = table.getColumnModel().getColumn(column);
        table.getParent().setBackground(new Color(170,193,193));
        setBorder(noFocusBorder);
        table.setRowSelectionAllowed(true);
        table.getParent().setBackground(new Color(170,193,193));
        int tableWidth = table.getParent().getWidth();
        switch (column){
            case 0 :
                // Nomor
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                //tc.setPreferredWidth(30);
                tc.setPreferredWidth((int) Math.round(0.0700*tableWidth));
                break;
            case 1 :
                // Nama Petani
                this.setHorizontalAlignment(LEFT);
                tc.setCellRenderer(this);
                //tc.setPreferredWidth(240);
                tc.setPreferredWidth((int) Math.round(0.5660*tableWidth));
                break;
            case 2 :
                // Luas
                this.setHorizontalAlignment(RIGHT);
                tc.setCellRenderer(this);
                //tc.setPreferredWidth(50);
                tc.setPreferredWidth((int) Math.round(0.1179*tableWidth));
                break;
            case 3 :
                // MT
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                //tc.setPreferredWidth(40);
                tc.setPreferredWidth((int) Math.round(0.0943*tableWidth));
                break;
            case 4 :
                // Varietas
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                //tc.setPreferredWidth(64);
                tc.setPreferredWidth((int) Math.round(0.1509*tableWidth));
                break;
        }
        
        if (row % 2 == 0){
            c.setBackground(new Color(205,219,219));
            c.setForeground(Color.DARK_GRAY);
            c.setFont(new Font("Consolas", Font.PLAIN, 14));
        } else {
            c.setBackground(new Color(85,131,131));
            c.setForeground(Color.WHITE);
            c.setFont(new Font("Consolas", Font.PLAIN, 14));
        }
        
        if (isSelected){
            setBackground(new Color(70,70,0));
            setForeground(Color.WHITE);
            c.setFont(new Font("Consolas", Font.PLAIN, 14));
        }
        
        return c;
    }
    
}
