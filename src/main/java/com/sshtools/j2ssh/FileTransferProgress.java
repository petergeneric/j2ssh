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
package com.sshtools.j2ssh;


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
 * @version $Id: FileTransferProgress.java,v 1.10 2003/09/11 15:35:00 martianx Exp $
 */
public interface FileTransferProgress {
    /**
     *
     *
     * @param bytesTotal
     * @param remoteFile
     */
    public void started(long bytesTotal, String remoteFile);

    /**
     *
     *
     * @return
     */
    public boolean isCancelled();

    /**
     *
     *
     * @param bytesSoFar
     */
    public void progressed(long bytesSoFar);

    /**
     *
     */
    public void completed();
}
