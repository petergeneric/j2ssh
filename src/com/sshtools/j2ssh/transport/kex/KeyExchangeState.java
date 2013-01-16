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
package com.sshtools.j2ssh.transport.kex;

import java.math.*;


/**
 *
 *
 * @author $author$
 * @version $Revision: 1.16 $
 */
public class KeyExchangeState {
    /**  */
    public final static int IN_PROGRESS = 0;

    /**  */
    public final static int COMPLETE = 1;

    /**  */
    public final static int FAILED = 2;
    private BigInteger secret;
    private String reason;
    private byte[] exchangeHash;
    private byte[] hostKey;
    private byte[] signature;
    private int state = IN_PROGRESS;

    /**
     * Creates a new KeyExchangeState object.
     */
    public KeyExchangeState() {
    }

    /**
     *
     *
     * @param exchangeHash
     * @param hostKey
     * @param signature
     * @param secret
     */
    public final synchronized void setComplete(byte[] exchangeHash,
        byte[] hostKey, byte[] signature, BigInteger secret) {
        this.exchangeHash = exchangeHash;
        this.hostKey = hostKey;
        this.signature = signature;
        this.secret = secret;
        state = COMPLETE;
        notifyAll();
    }

    /**
     *
     *
     * @return
     */
    public byte[] getExchangeHash() {
        return exchangeHash;
    }

    /**
     *
     *
     * @param reason
     */
    public final synchronized void setFailed(String reason) {
        this.reason = reason;
        state = FAILED;
        notifyAll();
    }

    /**
     *
     *
     * @return
     */
    public byte[] getHostKey() {
        return hostKey;
    }

    /**
     *
     *
     * @return
     */
    public BigInteger getSecret() {
        return secret;
    }

    /**
     *
     *
     * @return
     */
    public byte[] getSignature() {
        return signature;
    }

    /**
     *
     *
     * @return
     */
    public synchronized int getState() {
        return state;
    }

    /**
     *
     */
    public final synchronized void waitForCompletion() {
        while (state == IN_PROGRESS) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     *
     *
     * @return
     */
    public synchronized String getFailureReason() {
        return reason;
    }
}
