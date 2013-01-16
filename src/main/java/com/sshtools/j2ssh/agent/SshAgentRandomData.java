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
package com.sshtools.j2ssh.agent;

import com.sshtools.j2ssh.io.ByteArrayReader;
import com.sshtools.j2ssh.io.ByteArrayWriter;
import com.sshtools.j2ssh.subsystem.SubsystemMessage;
import com.sshtools.j2ssh.transport.InvalidMessageException;

import java.io.IOException;


class SshAgentRandomData extends SubsystemMessage {
    /**  */
    public static final int SSH_AGENT_RANDOM_DATA = 106;
    private byte[] data;

    /**
     * Creates a new SshAgentRandomData object.
     */
    public SshAgentRandomData() {
        super(SSH_AGENT_RANDOM_DATA);
    }

    /**
     * Creates a new SshAgentRandomData object.
     *
     * @param data
     */
    public SshAgentRandomData(byte[] data) {
        super(SSH_AGENT_RANDOM_DATA);
        this.data = data;
    }

    /**
     *
     *
     * @return
     */
    public byte[] getRandomData() {
        return data;
    }

    /**
     *
     *
     * @return
     */
    public String getMessageName() {
        return "SSH_AGENT_RANDOM_DATA";
    }

    /**
     *
     *
     * @param baw
     *
     * @throws java.io.IOException
     * @throws com.sshtools.j2ssh.transport.InvalidMessageException DOCUMENT
     *         ME!
     * @throws InvalidMessageException
     */
    public void constructByteArray(ByteArrayWriter baw)
        throws java.io.IOException, 
            com.sshtools.j2ssh.transport.InvalidMessageException {
        try {
            baw.writeBinaryString(data);
        } catch (IOException ioe) {
            throw new InvalidMessageException(ioe.getMessage());
        }
    }

    /**
     *
     *
     * @param bar
     *
     * @throws java.io.IOException
     * @throws com.sshtools.j2ssh.transport.InvalidMessageException DOCUMENT
     *         ME!
     * @throws InvalidMessageException
     */
    public void constructMessage(ByteArrayReader bar)
        throws java.io.IOException, 
            com.sshtools.j2ssh.transport.InvalidMessageException {
        try {
            data = bar.readBinaryString();
        } catch (IOException ioe) {
            throw new InvalidMessageException(ioe.getMessage());
        }
    }
}
