package com.sanerly.av.audio.tester;

import android.media.AudioFormat;
import android.media.MediaRecorder;
import android.os.Environment;

import com.sanerly.av.audio.controller.AudioCapturer;
import com.sanerly.av.audio.wav.WavFileWriter;
import com.sanerly.base.util.LogUtils;

import java.io.IOException;

/**
 * 作者：Sanerly
 * 时间；2019/4/10 11:55
 */
public class CaptureTester extends Tester {


    private AudioCapturer mCapturer;
    private static final String DEFAULT_TEST_FILE = Environment.getExternalStorageDirectory().getPath() + "/audio_test.wav";
    private WavFileWriter mWriter;

    @Override
    public boolean startTesting() {
        mCapturer = new AudioCapturer();
        mWriter = new WavFileWriter();
        LogUtils.i(DEFAULT_TEST_FILE);
        try {
            mWriter.openFile(DEFAULT_TEST_FILE, 44100, 1, 16);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        mCapturer.setOnAudioFrameCapturedListener(mCapturedListener);
        return mCapturer.startCapture(MediaRecorder.AudioSource.MIC, 44100, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
    }

    @Override
    public boolean stopTesting() {
        mCapturer.stopCapture();
        try {
            mWriter.closeFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private AudioCapturer.OnAudioFrameCapturedListener mCapturedListener = new AudioCapturer.OnAudioFrameCapturedListener() {
        @Override
        public void onAudioFrameCaptured(byte[] audioData) {
            mWriter.writeData(audioData, 0, audioData.length);
        }
    };
}
