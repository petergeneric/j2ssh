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
package com.sshtools.j2ssh.transport.publickey;

import com.sshtools.j2ssh.util.Hash;

import java.security.NoSuchAlgorithmException;


/**
 *
 *
 * @author $author$
 * @version $Revision: 1.24 $
 */
public abstract class SshPublicKey {
    /**
     *
     *
     * @return
     */
    public abstract String getAlgorithmName();

    /**
     *
     *
     * @return
     */
    public abstract int getBitLength();

    /**
     *
     *
     * @return
     */
    public abstract byte[] getEncoded();

    /**
     *
     *
     * @return
     */
    public String getFingerprint() {
        try {
            Hash md5 = new Hash("MD5");
            md5.putBytes(getEncoded());

            byte[] digest = md5.doFinal();
            int bits = getBitLength();
            bits = (((bits % 8) != 0) ? (bits += (bits % 8)) : bits);

            String ret = String.valueOf(bits);

            for (int i = 0; i < digest.length; i++) {
                ret += (((i == 0) ? ":" : "") + " " +
                Integer.toHexString(digest[i] & 0xFF));
            }

            return ret;
        } catch (NoSuchAlgorithmException nsae) {
            return null;
        }
    }

    /**
     *
     *
     * @param obj
     *
     * @return
     */
    public boolean equals(Object obj) {
        if (obj instanceof SshPublicKey) {
            return (getFingerprint().compareTo(((SshPublicKey) obj).getFingerprint()) == 0);
        }

        return false;
    }

    /**
     *
     *
     * @return
     */
    public int hashCode() {
        return getFingerprint().hashCode();
    }

    /**
     *
     *
     * @param signature
     * @param exchangeHash
     *
     * @return
     *
     * @throws InvalidSshKeySignatureException
     */
    public abstract boolean verifySignature(byte[] signature,
        byte[] exchangeHash) throws InvalidSshKeySignatureException;
}
