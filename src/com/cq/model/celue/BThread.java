
package com.cq.model.celue;

public class BThread extends Thread {
    
    private final Sample sample;
    
    public BThread(Sample sample) {
        this.sample = sample;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sample.B();
        }
    }
}
