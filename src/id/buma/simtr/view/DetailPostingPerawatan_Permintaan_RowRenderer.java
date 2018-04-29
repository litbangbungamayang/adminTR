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

public class DetailPostingPerawatan_Permintaan_RowRenderer extends DefaultTableCellRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
        setBorder(noFocusBorder);
        TableColumn tc = table.getColumnModel().getColumn(column);
        table.setRowSelectionAllowed(false);
        table.getParent().setBackground(new Color(170,193,193));
        int tableWidth = table.getParent().getWidth();
        switch(column){
            case 0: //NO
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.05*tableWidth));
                break;
            case 1: //NAMA
                this.setHorizontalAlignment(LEFT);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.20*tableWidth)-2);
                break;
            case 2: //TGL
                this.setHorizontalAlignment(CENTER);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.15*tableWidth));
                break;
            case 3: //PEKERJAAN
                this.setHorizontalAlignment(LEFT);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.23*tableWidth));
                break;
            case 4: //KUANTA
                this.setHorizontalAlignment(RIGHT);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.07*tableWidth));
                break;
            case 5: //HARGA SATUAN
                this.setHorizontalAlignment(RIGHT);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.16*tableWidth));
                break;
            case 6: //NILAI
                this.setHorizontalAlignment(RIGHT);
                tc.setCellRenderer(this);
                tc.setPreferredWidth((int) Math.round(0.14*tableWidth));
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
