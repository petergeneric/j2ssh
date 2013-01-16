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
package com.sshtools.common.ui;

import java.lang.reflect.*;


/**
 *
 *
 * @author $author$
 * @version $Revision: 1.13 $
 */
public class SshToolsApplicationException extends Exception {
    /**
* Creates a new SshToolsApplicationException object.
*/
    public SshToolsApplicationException() {
        this(null, null);
    }

    /**
* Creates a new SshToolsApplicationException object.
*
* @param msg
*/
    public SshToolsApplicationException(String msg) {
        this(msg, null);
    }

    /**
* Creates a new SshToolsApplicationException object.
*
* @param cause
*/
    public SshToolsApplicationException(Throwable cause) {
        this(null, cause);
    }

    /**
* Creates a new SshToolsApplicationException object.
*
* @param msg
* @param cause
*/
    public SshToolsApplicationException(String msg, Throwable cause) {
        super(msg);

        if (cause != null) {
            try {
                Method m = getClass().getMethod("initCause",
                        new Class[] { Throwable.class });
                m.invoke(this, new Object[] { cause });
            } catch (Exception e) {
            }
        }
    }
}
