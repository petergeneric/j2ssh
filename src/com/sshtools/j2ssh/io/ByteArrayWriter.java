/*
 *  SSHTools - Java SSH2 API
 *
 *  Copyright (C) 2002-2003 Lee David Painter and Contributors.
 *
 *  Contributions made by:
 *
 *  Brett Smith
 *  Richard Pernavas
 *  Erwin Bolwidt
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package com.sshtools.j2ssh.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.math.BigInteger;


/**
 *
 *
 * @author $author$
 * @version $Revision: 1.18 $
 */
public class ByteArrayWriter extends ByteArrayOutputStream {
    /**
     * Creates a new ByteArrayWriter object.
     */
    public ByteArrayWriter() {
    }

    /**
     *
     *
     * @param bi
     *
     * @throws IOException
     */
    public void writeBigInteger(BigInteger bi) throws IOException {
        byte[] raw = bi.toByteArray();
        writeInt(raw.length);
        write(raw);
    }

    /**
     *
     *
     * @param b
     *
     * @throws IOException
     */
    public void writeBoolean(boolean b) throws IOException {
        write(b ? 1 : 0);
    }

    /**
     *
     *
     * @param data
     *
     * @throws IOException
     */
    public void writeBinaryString(byte[] data) throws IOException {
        writeInt(data.length);
        write(data);
    }

    /**
     *
     *
     * @param i
     *
     * @throws IOException
     */
    public void writeInt(long i) throws IOException {
        byte[] raw = new byte[4];
        raw[0] = (byte) (i >> 24);
        raw[1] = (byte) (i >> 16);
        raw[2] = (byte) (i >> 8);
        raw[3] = (byte) (i);
        write(raw);
    }

    /**
     *
     *
     * @param i
     *
     * @throws IOException
     */
    public void writeInt(int i) throws IOException {
        byte[] raw = new byte[4];
        raw[0] = (byte) (i >> 24);
        raw[1] = (byte) (i >> 16);
        raw[2] = (byte) (i >> 8);
        raw[3] = (byte) (i);
        write(raw);
    }

    /**
     *
     *
     * @param i
     *
     * @return
     */
    public static byte[] encodeInt(int i) {
        byte[] raw = new byte[4];
        raw[0] = (byte) (i >> 24);
        raw[1] = (byte) (i >> 16);
        raw[2] = (byte) (i >> 8);
        raw[3] = (byte) (i);

        return raw;
    }

    /**
     *
     *
     * @param value
     *
     * @throws IOException
     */
    public void writeUINT32(UnsignedInteger32 value) throws IOException {
        writeInt(value.longValue());
    }

    /**
     *
     *
     * @param value
     *
     * @throws IOException
     */
    public void writeUINT64(UnsignedInteger64 value) throws IOException {
        byte[] raw = new byte[8];
        byte[] bi = value.bigIntValue().toByteArray();
        System.arraycopy(bi, 0, raw, raw.length - bi.length, bi.length);

        // Pad the raw data
        write(raw);
    }

    /**
     *
     *
     * @param array
     * @param pos
     * @param value
     *
     * @throws IOException
     */
    public static void writeIntToArray(byte[] array, int pos, int value)
        throws IOException {
        if ((array.length - pos) < 4) {
            throw new IOException(
                "Not enough data in array to write integer at position " +
                String.valueOf(pos));
        }

        array[pos] = (byte) (value >> 24);
        array[pos + 1] = (byte) (value >> 16);
        array[pos + 2] = (byte) (value >> 8);
        array[pos + 3] = (byte) (value);
    }

    /**
     *
     *
     * @param str
     *
     * @throws IOException
     */
    public void writeString(String str) throws IOException {
        if (str == null) {
            writeInt(0);
        } else {
            /*
            writeInt(str.length());
            // don't use US-ASCII by default!
            write(str.getBytes());
            */
            // patch as of version 0.2.9
            // for UTF-8 length of string is not necessarily
            // equal to number of bytes
            byte[] strBytes = str.getBytes();
            writeInt(strBytes.length);
            write(strBytes);
        }
    }
}
