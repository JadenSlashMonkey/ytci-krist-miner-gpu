package com.ytci.kristminer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Lignum
 */
public class KristMinerConsole implements Observer {
    public static void main(String[] args) {
        new KristMiner(new KristMinerConfig(args));
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO
	}
}
