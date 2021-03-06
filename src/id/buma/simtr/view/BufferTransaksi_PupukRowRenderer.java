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

public class BufferTransaksi_PupukRowRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
        TableColumn tc = table.getColumnModel().getColumn(column);
        setBorder(noFocusBorder);
        table.setRowSelectionAllowed(false);
        table.getParent().setBackground(new Color(170,193,193));
        int tableWidth = table.getParent().getWidth();
        int propColCount = table.getColumnCount() - 2;
        int propWidth = tableWidth - 160;
        int propColWidth = Math.round(propWidth/propColCount);
        if (column == 0){
            this.setHorizontalAlignment(CENTER);
            tc.setCellRenderer(this);
            tc.setPreferredWidth(40);
        } else {
            if (column == 1){
                this.setHorizontalAlignment(LEFT);
                tc.setCellRenderer(this);
                tc.setPreferredWidth(120);
            } else {
                this.setHorizontalAlignment(RIGHT);
                tc.setCellRenderer(this);
                tc.setPreferredWidth(propColWidth);
            }
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
