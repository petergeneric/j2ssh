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
package com.sshtools.j2ssh.transport;

import com.sshtools.j2ssh.io.ByteArrayReader;
import com.sshtools.j2ssh.io.ByteArrayWriter;

import java.io.IOException;


/**
 *
 *
 * @author $author$
 * @version $Revision: 1.20 $
 */
public class SshMsgUnimplemented extends SshMessage {
    /**  */
    protected final static int SSH_MSG_UNIMPLEMENTED = 3;

    // The sequence no of the message
    private long sequenceNo;

    /**
     * Creates a new SshMsgUnimplemented object.
     *
     * @param sequenceNo
     */
    public SshMsgUnimplemented(long sequenceNo) {
        super(SSH_MSG_UNIMPLEMENTED);
        this.sequenceNo = sequenceNo;
    }

    /**
     * Creates a new SshMsgUnimplemented object.
     */
    public SshMsgUnimplemented() {
        super(SSH_MSG_UNIMPLEMENTED);
    }

    /**
     *
     *
     * @return
     */
    public String getMessageName() {
        return "SSH_MSG_UNIMPLEMENTED";
    }

    /**
     *
     *
     * @return
     */
    public long getSequenceNo() {
        return sequenceNo;
    }

    /**
     *
     *
     * @param baw
     *
     * @throws InvalidMessageException
     */
    protected void constructByteArray(ByteArrayWriter baw)
        throws InvalidMessageException {
        try {
            baw.writeInt(sequenceNo);
        } catch (IOException ioe) {
            throw new InvalidMessageException(
                "Error extracting SSH_MSG_UNIMPLMENTED, expected int value");
        }
    }

    /**
     *
     *
     * @param bar
     *
     * @throws InvalidMessageException
     */
    protected void constructMessage(ByteArrayReader bar)
        throws InvalidMessageException {
        try {
            sequenceNo = bar.readInt();
        } catch (IOException ioe) {
            throw new InvalidMessageException(
                "Error contructing SSH_MSG_UNIMPLEMENTED, expected int value");
        }
    }
}
