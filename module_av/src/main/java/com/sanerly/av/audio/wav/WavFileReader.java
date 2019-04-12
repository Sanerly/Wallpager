package com.sanerly.av.audio.wav;

import android.util.Log;

import com.sanerly.base.util.ByteUtils;
import com.sanerly.base.util.LogUtils;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 作者：Sanerly
 * 时间：2019/4/10 16:15
 */
public class WavFileReader {
    private static final String TAG = "WavFileReader";
    private DataInputStream mStream;
    private WavFileHeader mHeader;

    public WavFileReader() {
    }

    public boolean openFile(String filepath) throws IOException {
        if (mStream != null) {
            closeFile();
        }

        mStream = new DataInputStream(new FileInputStream(filepath));

        return readHead();
    }


    public void closeFile() throws IOException {
        if (mStream == null) {
            return;
        }
        mStream.close();
        mStream = null;

    }

    public int readData(byte[] buffer, int offset, int count) {
        if (mHeader == null || mStream == null) {
            return -1;
        }
        try {
            int b = mStream.read(buffer, offset, count);
            if (b == -1) {
                return 0;
            }
            return b;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    private boolean readHead() {
        if (mStream == null) {
            return false;
        }
        WavFileHeader header = new WavFileHeader();

        byte[] intValue = new byte[4];
        byte[] shortValue = new byte[2];

        try {
            header.mChunkID = "" + (char) mStream.readByte() + (char) mStream.readByte() + (char) mStream.readByte() + (char) mStream.readByte();
            LogUtils.e("Read file chunkID:" + header.mChunkID);

            mStream.read(intValue);
            header.mChunkSize = ByteUtils.byteArrayToInt(intValue);
            LogUtils.e("Read file chunkSize:" + header.mChunkSize);

            header.mFormat = "" + (char) mStream.readByte() + (char) mStream.readByte() + (char) mStream.readByte() + (char) mStream.readByte();
            LogUtils.e("Read file format:" + header.mFormat);

            header.mSubChunk1ID = "" + (char) mStream.readByte() + (char) mStream.readByte() + (char) mStream.readByte() + (char) mStream.readByte();
            LogUtils.e("Read fmt subChunkID:" + header.mSubChunk1ID);

            mStream.read(intValue);
            header.mSubChunk1Size = ByteUtils.byteArrayToInt(intValue);
            LogUtils.e("Read fmt subChunkSize:" + header.mSubChunk1Size);

            mStream.read(shortValue);
            header.mAudioFormat = ByteUtils.byteArrayToShort(shortValue);
            LogUtils.e("Read audioFormat:" + header.mAudioFormat);

            mStream.read(shortValue);
            header.mNumChannel = ByteUtils.byteArrayToShort(shortValue);
            LogUtils.e("Read channel number:" + header.mNumChannel);

            mStream.read(intValue);
            header.mSampleRate = ByteUtils.byteArrayToInt(intValue);
            LogUtils.e("Read samplerate:" + header.mSampleRate);

            mStream.read(intValue);
            header.mByteRate = ByteUtils.byteArrayToInt(intValue);
            LogUtils.e("Read byterate:" + header.mByteRate);

            mStream.read(shortValue);
            header.mBlockAlign = ByteUtils.byteArrayToShort(shortValue);
            LogUtils.e("Read blockalign:" + header.mBlockAlign);

            mStream.read(shortValue);
            header.mBitsPerSample = ByteUtils.byteArrayToShort(shortValue);
            LogUtils.e("Read bitspersample:" + header.mBitsPerSample);

            header.mSubChunk2ID = "" + (char) mStream.readByte() + (char) mStream.readByte() + (char) mStream.readByte() + (char) mStream.readByte();
            LogUtils.e("Read data chunkID:" + header.mSubChunk2ID);

            mStream.read(intValue);
            header.mSubChunk2Size = ByteUtils.byteArrayToInt(intValue);
            LogUtils.e("Read data chunkSize:" + header.mSubChunk2Size);

            LogUtils.e("Read wav file duration:"+(header.mSubChunk2Size/header.mByteRate));

            LogUtils.e("Read wav file success !");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        mHeader = header;

        return true;
    }

    public WavFileHeader getHeader() {
        return mHeader;
    }
}
