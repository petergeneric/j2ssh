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
package com.sshtools.j2ssh.connection;


/**
 * <p>
 * Title:
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 *
 * <p>
 * Company:
 * </p>
 *
 * @author Lee David Painter
 * @version $Id: ChannelEventAdapter.java,v 1.8 2003/09/11 15:35:06 martianx Exp $
 */
public abstract class ChannelEventAdapter implements ChannelEventListener {
    /**
     * Creates a new ChannelEventAdapter object.
     */
    public ChannelEventAdapter() {
    }

    /**
     *
     *
     * @param channel
     */
    public void onChannelOpen(Channel channel) {
    }

    /**
     *
     *
     * @param channel
     */
    public void onChannelEOF(Channel channel) {
    }

    /**
     *
     *
     * @param channel
     */
    public void onChannelClose(Channel channel) {
    }

    /**
     *
     *
     * @param channel
     * @param data
     */
    public void onDataReceived(Channel channel, byte[] data) {
    }

    /**
     *
     *
     * @param channel
     * @param data
     */
    public void onDataSent(Channel channel, byte[] data) {
    }
}
