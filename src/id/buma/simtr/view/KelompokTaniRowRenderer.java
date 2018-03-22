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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class KelompokTaniRowRenderer extends DefaultTableCellRenderer implements TableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column){
        Component c = super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
        TableColumn tc = table.getColumnModel().getColumn(column);
        setBorder(noFocusBorder);
        switch (column){
            case 0 :
                // Nomor
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                tc.setPreferredWidth(40);
                break;
            case 1 :
                // ID Kelompok
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                tc.setPreferredWidth(100);
                break;
            case 2 :
                // Afdeling
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                tc.setPreferredWidth(40);
                break;
            case 3 :
                // Tahun
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                tc.setPreferredWidth(70);
                break;
            case 4 :
                // Nama Kelompok
                this.setHorizontalAlignment(LEFT);
                tc.setCellRenderer(this);
                tc.setPreferredWidth(250);
                break;
            case 5 :
                // No Kontrak
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                tc.setPreferredWidth(110);
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
