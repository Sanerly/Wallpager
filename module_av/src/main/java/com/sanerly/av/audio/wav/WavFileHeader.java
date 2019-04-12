package com.sanerly.av.audio.wav;

/**
 * 作者：Sanerly
 * 时间：2019/4/10 11:11
 * https://blog.51cto.com/ticktick/1752947
 */
public class WavFileHeader {

    public static final int WAV_FILE_HEADER_SIZE = 44;
    public static final int WAV_CHUNKSIZE_EXCLUDE_DATA = 36;

    public static final int WAV_CHUNKSIZE_OFFSET = 4;
    public static final int WAV_SUB_CHUNKSIZE1_OFFSET = 16;
    public static final int WAV_SUB_CHUNKSIZE2_OFFSET = 40;


    /**********************头文件第一部分**********************/

    /**
     * 注明“RIFF”格式的文件
     */
    public String mChunkID = "RIFF";
    /**
     * 记录整个 wav 文件的字节数
     */
    public int mChunkSize = 0;
    /**
     * 通过“Format”填入“WAVE”来标识这是一个 wav 格式
     */
    public String mFormat = "WAVE";

    /**********************头文件第二部分**********************/
    /**
     * 属于“fmt”信息块，主要记录了本 wav 音频文件的详细音频参数信息
     */
    public String mSubChunk1ID = "fmt ";
    /**
     * 16用于PCM  这是Subchunk其余部分的大小
     */
    public int mSubChunk1Size = 16;
    /**
     * PCM = 1(即线性量化)值以外的值表示某种形式的压缩。
     */
    public short mAudioFormat = 1;
    /**
     * 声道数 双声道和单声道
     */
    public short mNumChannel = 1;
    /**
     * 采样率 8kHz==8000Hz
     */
    public int mSampleRate = 8000;

    /**
     * 码率 ：采样率* 声道个数* 采样位数/8  每秒数据字节数
     * mByteRate==SampleRate * NumChannels * BitsPerSample / 8
     */
    public int mByteRate = 0;

    /**
     * 每次采样的大小：声道数*位宽/8
     * mBlockAlign=NumChannels * BitsPerSample / 8
     */
    public short mBlockAlign = 0;

    /**
     * 表示位宽 8bit= 8，16bit= 16
     */
    public short mBitsPerSample = 8;

    /**********************头文件第三部分**********************/
    /**
     * “data”信息块
     */
    public String mSubChunk2ID = "data";
    /**
     * 记录后面存储的二进制原始音频数据的长度
     */
    public int mSubChunk2Size = 0;

    public WavFileHeader() {

    }

    public WavFileHeader(int sampleRateInHz, int bitsPerSample, int channels) {
        mSampleRate = sampleRateInHz;
        mBitsPerSample = (short) bitsPerSample;
        mNumChannel = (short) channels;
        mByteRate = mSampleRate * mNumChannel * mBitsPerSample / 8;
        mBlockAlign = (short) (mNumChannel * mBitsPerSample / 8);
    }
}
