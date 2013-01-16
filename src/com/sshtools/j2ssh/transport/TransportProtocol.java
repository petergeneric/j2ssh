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

import java.io.IOException;


/**
 *
 *
 * @author $author$
 * @version $Revision: 1.25 $
 */
public interface TransportProtocol {
    /**
     *
     *
     * @param description
     */
    public void disconnect(String description);

    /**
     *
     *
     * @param store
     *
     * @throws MessageAlreadyRegisteredException
     */
    public void addMessageStore(SshMessageStore store)
        throws MessageAlreadyRegisteredException;

    /**
     *
     *
     * @param ms
     * @param sender
     *
     * @throws IOException
     */
    public void sendMessage(SshMessage ms, Object sender)
        throws IOException;

    /**
     *
     *
     * @param filter
     *
     * @return
     *
     * @throws IOException
     */
    public SshMessage readMessage(int[] filter) throws IOException;

    /**
     *
     *
     * @return
     */
    public byte[] getSessionIdentifier();

    /**
     *
     *
     * @return
     */
    public int getConnectionId();

    public boolean isConnected();

    /**
     *
     *
     * @return
     */
    public TransportProtocolState getState();

    public String getUnderlyingProviderDetail();
}
