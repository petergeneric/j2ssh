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

import javax.swing.Action;


/**
 *
 *
 * @author $author$
 * @version $Revision: 1.13 $
 */
public class OptionsAction extends StandardAction {
    /**
* Creates a new OptionsAction object.
*/
    public OptionsAction() {
        putValue(Action.NAME, "Options");
        putValue(Action.SMALL_ICON,
            getIcon("/com/sshtools/common/ui/options.png"));
        putValue(Action.SHORT_DESCRIPTION, "Application options");
        putValue(Action.LONG_DESCRIPTION, "Edit the application options");
        putValue(Action.MNEMONIC_KEY, new Integer('o'));
        putValue(Action.ACTION_COMMAND_KEY, "options-command");
        putValue(StandardAction.ON_MENUBAR, new Boolean(true));
        putValue(StandardAction.MENU_NAME, "Tools");
        putValue(StandardAction.MENU_ITEM_GROUP, new Integer(90));
        putValue(StandardAction.MENU_ITEM_WEIGHT, new Integer(99));
        putValue(StandardAction.ON_TOOLBAR, new Boolean(true));
        putValue(StandardAction.TOOLBAR_GROUP, new Integer(90));
        putValue(StandardAction.TOOLBAR_WEIGHT, new Integer(0));
    }
}
