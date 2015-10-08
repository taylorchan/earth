
package com.cq.model.celue;

public class AThread extends Thread {
    
    private final Sample sample;
    
    public AThread(Sample sample) {
        this.sample = sample;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sample.A();
        }
    }
}
