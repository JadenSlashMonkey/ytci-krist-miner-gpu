package com.ytci.kristminer;

public class KristMiner {

    static boolean paused = false;
    static final Object newBlockReady = new Object();
    static final Object pausedLock = new Object();
    static final Object submitReady = new Object();
    static final Object hashesDoneLock = new Object();
    static final Object blocksDoneLock = new Object();

    static String nonceSubmission = "";
    static long hashesDone = 0;
    static int blocksDone = 0;
    static long startTime = 0;

    static String block;
    static int work;
    static int balance;

    static KristConfig theConfig;
    static CLContext theCLContext = new CLContext();

    public static void main(String[] args) {
        theConfig = new KristConfig(args);

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

    public static void addHashesDone(int amt) {
        synchronized(hashesDoneLock) {
            hashesDone += amt;
        }
    }

    public static double getHPS() {
        synchronized(hashesDoneLock) {
            return ((double)hashesDone)/(System.currentTimeMillis() - startTime) * 1000;
        }
    }

    public static void addBlocksDone(int amt) {
        synchronized(blocksDoneLock) {
            blocksDone += amt;
        }
    }

    public static int getBlocksDone() {
        synchronized(blocksDoneLock) {
            return blocksDone;
        }
    }

    public static double getBPM() {
        synchronized(blocksDoneLock) {
            return ((double)blocksDone)/(System.currentTimeMillis() - startTime) * 1000 * 60;
        }
    }

    public static boolean isPaused() {
        synchronized(pausedLock) {
            return paused;
        }
    }

    public static void pause(boolean p) {
        synchronized(pausedLock) {
            paused = p;
        }
    }

    public static void blockChanged(String block) {
        System.out.println("Block changed! New block: " + block);
        KristMiner.block = block;
    }

    public static void workChanged(int work) {
        System.out.println("Work changed! New work: " + work);
    }

    public static void balanceChanged(int balance) {
        KristMiner.balance = balance;
    }

    public static void submitBlock(String nonce) {
        nonceSubmission = nonce;
        synchronized(submitReady) {
            submitReady.notify();
        }
    }
}