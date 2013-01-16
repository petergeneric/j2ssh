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

import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.math.BigInteger;


/**
 *
 *
 * @author $author$
 * @version $Revision: 1.16 $
 */
public class ByteArrayReader extends ByteArrayInputStream {
    /**
     * Creates a new ByteArrayReader object.
     *
     * @param data
     */
    public ByteArrayReader(byte[] data) {
        super(data);
    }

    /**
     *
     *
     * @param data
     * @param start
     *
     * @return
     */
    public static long readInt(byte[] data, int start) {
        long ret = (((long) (data[start] & 0xFF) << 24) & 0xFFFFFFFF) |
            ((data[start + 1] & 0xFF) << 16) | ((data[start + 2] & 0xFF) << 8) |
            ((data[start + 3] & 0xFF) << 0);

        return ret;
    }

    /**
     *
     *
     * @return
     *
     * @throws IOException
     */
    public long readInt() throws IOException {
        byte[] raw = new byte[4];
        read(raw);

        long ret = (((long) (raw[0] & 0xFF) << 24) & 0xFFFFFFFF) |
            ((raw[1] & 0xFF) << 16) | ((raw[2] & 0xFF) << 8) | (raw[3] & 0xFF);

        return ret;
    }

    /**
     *
     *
     * @return
     *
     * @throws IOException
     */
    public UnsignedInteger32 readUINT32() throws IOException {
        return new UnsignedInteger32(readInt());
    }

    /**
     *
     *
     * @return
     *
     * @throws IOException
     */
    public UnsignedInteger64 readUINT64() throws IOException {
        byte[] raw = new byte[8];
        read(raw);

        return new UnsignedInteger64(raw);
    }

    /**
     *
     *
     * @param data
     * @param start
     *
     * @return
     */
    public static String readString(byte[] data, int start) {
        int len = (int) readInt(data, start);
        byte[] chars = new byte[(int) len];
        System.arraycopy(data, start + 4, chars, 0, len);

        return new String(chars);
    }

    /**
     *
     *
     * @return
     *
     * @throws IOException
     */
    public BigInteger readBigInteger() throws IOException {
        int len = (int) readInt();
        byte[] raw = new byte[len];
        read(raw);

        return new BigInteger(raw);
    }

    /**
     *
     *
     * @return
     *
     * @throws IOException
     */
    public byte[] readBinaryString() throws IOException {
        long len = readInt();
        byte[] raw = new byte[(int) len];
        read(raw);

        return raw;
    }

    /**
     *
     *
     * @return
     *
     * @throws IOException
     */
    public String readString() throws IOException {
        long len = readInt();
        byte[] raw = new byte[(int) len];
        read(raw);

        return new String(raw);
    }
}
