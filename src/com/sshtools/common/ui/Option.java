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


/**
 *
 *
 * @author $author$
 * @version $Revision: 1.12 $
 */
public class Option {
    private String text;
    private String toolTipText;
    private int mnemonic;

    /**
* Creates a new Option object.
*
* @param text
* @param toolTipText
* @param mnemonic
*/
    public Option(String text, String toolTipText, int mnemonic) {
        this.text = text;
        this.toolTipText = toolTipText;
        this.mnemonic = mnemonic;
    }

    /**
*
*
* @return
*/
    public String getText() {
        return text;
    }

    /**
*
*
* @return
*/
    public int getMnemonic() {
        return mnemonic;
    }

    /**
*
*
* @return
*/
    public String getToolTipText() {
        return toolTipText;
    }
}
