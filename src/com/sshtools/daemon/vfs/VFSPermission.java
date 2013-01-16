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
package com.sshtools.daemon.vfs;


/**
 *
 *
 * @author $author$
 * @version $Revision: 1.12 $
 */
public class VFSPermission {
    private boolean canRead;
    private boolean canWrite;
    private boolean canExecute;
    private String name;

    /**
 * Creates a new VFSPermission object.
 *
 * @param name
 * @param permissions
 */
    public VFSPermission(String name, String permissions) {
        this.name = name;
        setPermissions(permissions);
    }

    /**
 * Creates a new VFSPermission object.
 *
 * @param name
 */
    public VFSPermission(String name) {
        this.name = name;
        setPermissions("rwx");
    }

    /**
 *
 *
 * @return
 */
    public String getName() {
        return name;
    }

    /**
 *
 *
 * @param permissions
 */
    public void setPermissions(String permissions) {
        canRead = false;
        canWrite = false;
        canExecute = false;

        for (int i = 0; i < permissions.length(); i++) {
            switch (permissions.charAt(i)) {
            case 'r': {
                canRead = true;

                break;
            }

            case 'w': {
                canWrite = true;

                break;
            }

            case 'x': {
                canExecute = true;

                break;
            }
            }
        }
    }

    /**
 *
 *
 * @return
 */
    public String getPermissions() {
        return (canRead ? "r" : "") + (canWrite ? "w" : "") +
        (canExecute ? "x" : "");
    }

    /**
 *
 *
 * @param permissions
 *
 * @return
 */
    public boolean verifyPermissions(String permissions) {
        String tmp = getPermissions();
        String ch;

        for (int i = 0; i < permissions.length(); i++) {
            ch = permissions.substring(i, 1);

            if (tmp.indexOf(ch) == -1) {
                return false;
            }
        }

        return true;
    }

    /**
 *
 *
 * @return
 */
    public boolean canRead() {
        return canRead;
    }

    /**
 *
 *
 * @return
 */
    public boolean canWrite() {
        return canWrite;
    }

    /**
 *
 *
 * @return
 */
    public boolean canExecute() {
        return canExecute;
    }
}
