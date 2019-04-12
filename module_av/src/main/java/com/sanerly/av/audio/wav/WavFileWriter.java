package com.sanerly.av.audio.wav;

import com.sanerly.base.util.ByteUtils;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 作者：Sanerly
 * 时间；2019/4/10 12:02
 */
public class WavFileWriter {

    private String mFilepath;
    private int mDataSize = 0;
    private DataOutputStream mDataOutputStream;

    public boolean openFile(String filepath, int sampleRateInHz, int channels, int bitsPerSample) throws IOException {
        if (mDataOutputStream != null) {
            closeFile();
        }
        mFilepath = filepath;
        mDataSize = 0;

        mDataOutputStream = new DataOutputStream(new FileOutputStream(filepath));
        return writeHeader(sampleRateInHz, bitsPerSample, channels);
    }

    public boolean closeFile() throws IOException {
        boolean ret = true;
        if (mDataOutputStream != null) {
            ret = writeDataSize();
            mDataOutputStream.close();
            mDataOutputStream = null;
        }
        return ret;
    }

    public boolean writeData(byte[] buffer, int offset, int count) {
        if (mDataOutputStream == null) {
            return false;
        }

        try {
            //写入文件数据
            mDataOutputStream.write(buffer, offset, count);
            mDataSize += count;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private boolean writeHeader(int sampleRateInHz, int channels, int bitsPerSample) {
        if (mDataOutputStream == null) {
            return false;
        }

        WavFileHeader header = new WavFileHeader(sampleRateInHz, channels, bitsPerSample);

        try {
            mDataOutputStream.writeBytes(header.mChunkID);
            mDataOutputStream.write(ByteUtils.intToByteArray(header.mChunkSize), 0, 4);
            mDataOutputStream.writeBytes(header.mFormat);
            mDataOutputStream.writeBytes(header.mSubChunk1ID);
            mDataOutputStream.write(ByteUtils.intToByteArray(header.mSubChunk1Size), 0, 4);
            mDataOutputStream.write(ByteUtils.shortToByteArray(header.mAudioFormat), 0, 2);
            mDataOutputStream.write(ByteUtils.shortToByteArray(header.mNumChannel), 0, 2);
            mDataOutputStream.write(ByteUtils.intToByteArray(header.mSampleRate), 0, 4);
            mDataOutputStream.write(ByteUtils.intToByteArray(header.mByteRate), 0, 4);
            mDataOutputStream.write(ByteUtils.shortToByteArray(header.mBlockAlign), 0, 2);
            mDataOutputStream.write(ByteUtils.shortToByteArray(header.mBitsPerSample), 0, 2);
            mDataOutputStream.writeBytes(header.mSubChunk2ID);
            mDataOutputStream.write(ByteUtils.intToByteArray(header.mSubChunk2Size), 0, 4);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * “r” 以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。
     * “rw” 打开以便读取和写入。如果该文件尚不存在，则尝试创建该文件。
     * “rws” 打开以便读取和写入，对于 “rw”，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备。
     * “rwd” 打开以便读取和写入，对于 “rw”，还要求对文件内容的每个更新都同步写入到底层存储设备。
     */
    private boolean writeDataSize() {
        if (mDataOutputStream == null) {
            return false;
        }

        try {
            RandomAccessFile wavFile = new RandomAccessFile(mFilepath, "rw");
            wavFile.seek(WavFileHeader.WAV_CHUNKSIZE_OFFSET);
            wavFile.write(ByteUtils.intToByteArray((mDataSize + WavFileHeader.WAV_CHUNKSIZE_EXCLUDE_DATA)), 0, 4);
            wavFile.seek(WavFileHeader.WAV_SUB_CHUNKSIZE2_OFFSET);
            wavFile.write(ByteUtils.intToByteArray((mDataSize)), 0, 4);
            wavFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


}
