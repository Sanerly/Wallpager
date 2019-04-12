package com.sanerly.av.audio.tester;

import android.os.Environment;

import com.sanerly.av.audio.controller.AudioPlayer;
import com.sanerly.av.audio.wav.WavFileReader;

import java.io.IOException;

/**
 * 作者：Sanerly
 * 时间：2019/4/10 15:57
 */
public class PlayerTestter extends Tester {
    private static final String DEFAULT_TEST_FILE = Environment.getExternalStorageDirectory().getPath() + "/audio_test.wav";
    private static final int SAMPLES_PER_FRAME = 1024;
    private WavFileReader mReader;
    private AudioPlayer mPlayer;
    private volatile boolean mIsTestingExit = false;

    @Override
    public boolean startTesting() {
        mPlayer = new AudioPlayer();
        mReader = new WavFileReader();
        try {
            mReader.openFile(DEFAULT_TEST_FILE);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        mPlayer.startPlayer();
        new Thread(mRunnable).start();

        return true;
    }

    @Override
    public boolean stopTesting() {
        mIsTestingExit = true;
        return true;
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            byte[] bytes = new byte[SAMPLES_PER_FRAME * 2];
            while (!mIsTestingExit && mReader.readData(bytes, 0, bytes.length) > 0) {
                mPlayer.play(bytes, 0, bytes.length);
            }

            mPlayer.stopPlayer();
            try {
                mReader.closeFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}
