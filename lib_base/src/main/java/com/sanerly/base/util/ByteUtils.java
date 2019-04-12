package com.sanerly.base.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 作者：Sanerly
 * 时间；2019/4/10 11:13
 */
public class ByteUtils {

    public static byte[] intToByteArray(int data) {

        return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(data).array();
    }


    public static byte[] shortToByteArray(short data) {

        return ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort(data).array();
    }


    public static int byteArrayToInt(byte[] data) {

        return ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    public static short byteArrayToShort(byte[] data) {
        return ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getShort();
    }
}
