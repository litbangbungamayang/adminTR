/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class PrintCompleteMonitor extends PrintJobAdapter{
    
    private boolean completed = false;

    @Override
    public void printJobCanceled(PrintJobEvent pje) {
        super.printJobCanceled(pje); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printJobCompleted(PrintJobEvent pje) {
        super.printJobCompleted(pje); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printJobFailed(PrintJobEvent pje) {
        super.printJobFailed(pje); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printJobNoMoreEvents(PrintJobEvent pje) {
        super.printJobNoMoreEvents(pje); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void signalCompletion(){
        synchronized (PrintCompleteMonitor.this){
            completed = true;
            PrintCompleteMonitor.this.notify();
        }
    }
    
    public synchronized void waitForComplete(){
        try{
            while (!completed){
                wait();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(PrintCompleteMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
