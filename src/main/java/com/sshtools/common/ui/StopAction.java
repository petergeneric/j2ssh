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

import java.awt.event.*;

import javax.swing.*;


/**
 *
 *
 * @author $author$
 * @version $Revision: 1.13 $
 */
public class StopAction extends StandardAction {
    private final static String ACTION_COMMAND_KEY_STOP = "stop-command";
    private final static String NAME_STOP = "Stop";
    private final static String SMALL_ICON_STOP = "/com/sshtools/common/ui/stop.png";
    private final static String LARGE_ICON_STOP = "";
    private final static String SHORT_DESCRIPTION_STOP = "Stop recording";
    private final static String LONG_DESCRIPTION_STOP = "Stop recording output to file";
    private final static int MNEMONIC_KEY_STOP = 's';

    /**
* Creates a new StopAction object.
*/
    public StopAction() {
        putValue(Action.NAME, NAME_STOP);
        putValue(Action.SMALL_ICON, getIcon(SMALL_ICON_STOP));
        putValue(LARGE_ICON, getIcon(LARGE_ICON_STOP));
        putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION_STOP);
        putValue(Action.LONG_DESCRIPTION, LONG_DESCRIPTION_STOP);
        putValue(Action.ACCELERATOR_KEY,
            KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.ALT_MASK));
        putValue(Action.MNEMONIC_KEY, new Integer(MNEMONIC_KEY_STOP));
        putValue(Action.ACTION_COMMAND_KEY, ACTION_COMMAND_KEY_STOP);
        putValue(StandardAction.ON_MENUBAR, new Boolean(true));
        putValue(StandardAction.MENU_NAME, "File");
        putValue(StandardAction.MENU_ITEM_GROUP, new Integer(60));
        putValue(StandardAction.MENU_ITEM_WEIGHT, new Integer(10));
        putValue(StandardAction.ON_TOOLBAR, new Boolean(true));
        putValue(StandardAction.TOOLBAR_GROUP, new Integer(60));
        putValue(StandardAction.TOOLBAR_WEIGHT, new Integer(10));
    }
}
