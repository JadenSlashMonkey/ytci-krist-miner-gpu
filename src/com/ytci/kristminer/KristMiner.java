package com.ytci.kristminer;

import java.util.Observable;

public class KristMiner extends Observable {
    public boolean paused = false;
    public final Object newBlockReady = new Object();
    public final Object pausedLock = new Object();
    public final Object submitReady = new Object();
    public final Object hashesDoneLock = new Object();
    public final Object blocksDoneLock = new Object();

    public String nonceSubmission = "";
    public long hashesDone = 0;
    public int blocksDone = 0;
    public long startTime = 0;

    public String block;
    public int work;
    public int balance;

    public KristMinerConfig theConfig;
    public CLContext theCLContext = new CLContext();

    public KristMiner(KristMinerConfig config) {
        theConfig = config;

        if (!theConfig.didSucceed()) {
            System.err.println("Command line failed! Specify --help/-? for help.");
            System.exit(1);
            return;
        }

        startTime = System.currentTimeMillis();

        System.out.print("Getting sync node... ");
        APICalls.updateSyncNode();
        System.out.println("DONE");

        String address = theConfig.getAddress();
        System.out.println("Mining for address "+address);
        
        // Start mining with OpenCL
        theCLContext = new CLContext(); // Initialises an OpenCL context.
    }

    public void addHashesDone(int amt) {
        synchronized(hashesDoneLock) {
            hashesDone += amt;
        }
    }

    public double getHPS() {
        synchronized(hashesDoneLock) {
            return ((double)hashesDone)/(System.currentTimeMillis() - startTime) * 1000;
        }
    }

    public void addBlocksDone(int amt) {
        synchronized(blocksDoneLock) {
            blocksDone += amt;
        }
    }

    public int getBlocksDone() {
        synchronized(blocksDoneLock) {
            return blocksDone;
        }
    }

    public double getBPM() {
        synchronized(blocksDoneLock) {
            return ((double)blocksDone)/(System.currentTimeMillis() - startTime) * 1000 * 60;
        }
    }

    public boolean isPaused() {
        synchronized(pausedLock) {
            return paused;
        }
    }

    public void pause(boolean p) {
        synchronized(pausedLock) {
            paused = p;
        }
    }

    public void blockChanged(String block) {
        System.out.println("Block changed! New block: " + block);
        this.block = block;
    }

    public void workChanged(int work) {
        System.out.println("Work changed! New work: " + work);
    }

    public void balanceChanged(int balance) {
        this.balance = balance;
    }

    public void submitBlock(String nonce) {
        nonceSubmission = nonce;
        synchronized(submitReady) {
            submitReady.notify();
        }
    }
    
    @Override
    public void notifyObservers(Object arg) {
    	// TODO
    }
}