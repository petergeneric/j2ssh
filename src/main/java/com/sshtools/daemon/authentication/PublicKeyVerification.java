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
package com.sshtools.daemon.authentication;

import java.io.*;


/**
 *
 *
 * @author $author$
 * @version $Revision: 1.13 $
 */
public interface PublicKeyVerification {
    /**
 *
 *
 * @param username
 * @param algorithm
 * @param encoded
 * @param service
 * @param sessionId
 * @param signature
 *
 * @return
 *
 * @throws IOException
 */
    public boolean verifyKeySignature(String username, String algorithm,
        byte[] encoded, String service, byte[] sessionId, byte[] signature)
        throws IOException;

    /**
 *
 *
 * @param username
 * @param algorithm
 * @param encoded
 *
 * @return
 *
 * @throws IOException
 */
    public boolean acceptKey(String username, String algorithm, byte[] encoded)
        throws IOException;
}
