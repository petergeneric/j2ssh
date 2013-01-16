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
 * @version $Revision: 1.21 $
 */
public class SshMsgServiceRequest extends SshMessage {
    /**  */
    public final static int SSH_MSG_SERVICE_REQUEST = 5;
    private String serviceName;

    /**
     * Creates a new SshMsgServiceRequest object.
     *
     * @param serviceName
     */
    public SshMsgServiceRequest(String serviceName) {
        super(SSH_MSG_SERVICE_REQUEST);
        this.serviceName = serviceName;
    }

    /**
     * Creates a new SshMsgServiceRequest object.
     */
    public SshMsgServiceRequest() {
        super(SSH_MSG_SERVICE_REQUEST);
    }

    /**
     *
     *
     * @return
     */
    public String getMessageName() {
        return "SSH_MSG_SERVICE_REQUEST";
    }

    /**
     *
     *
     * @return
     */
    public String getServiceName() {
        return serviceName;
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
            baw.writeString(serviceName);
        } catch (IOException ioe) {
            throw new InvalidMessageException("Error writing message data");
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
            serviceName = bar.readString();
        } catch (IOException ioe) {
            throw new InvalidMessageException("Error reading message data");
        }
    }
}
