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

import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.KeyStroke;


/**
 *
 *
 * @author $author$
 * @version $Revision: 1.14 $
 */
public abstract class ConnectionPropertiesAction extends StandardAction {
    /**
* Creates a new ConnectionPropertiesAction object.
*/
    public ConnectionPropertiesAction() {
        putValue(Action.NAME, "Connection Settings");
        putValue(Action.SMALL_ICON,
            getIcon("/com/sshtools/common/ui/properties.png"));
        putValue(Action.SHORT_DESCRIPTION, "Connection settings");
        putValue(Action.LONG_DESCRIPTION,
            "Change the current connecting settings");
        putValue(Action.MNEMONIC_KEY, new Integer('t'));
        putValue(Action.ACCELERATOR_KEY,
            KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.ALT_MASK));
        putValue(Action.ACTION_COMMAND_KEY, "connect-properties-command");
        putValue(StandardAction.ON_MENUBAR, new Boolean(true));
        putValue(StandardAction.MENU_NAME, "Edit");
        putValue(StandardAction.MENU_ITEM_GROUP, new Integer(80));
        putValue(StandardAction.MENU_ITEM_WEIGHT, new Integer(10));
        putValue(StandardAction.ON_TOOLBAR, new Boolean(true));
        putValue(StandardAction.TOOLBAR_GROUP, new Integer(15));
        putValue(StandardAction.TOOLBAR_WEIGHT, new Integer(10));
    }
}
