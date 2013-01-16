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


public class SessionProviderAction extends StandardAction {
    SessionProvider provider;

    public SessionProviderAction(SessionProvider provider) {
        this.provider = provider;
        putValue(Action.NAME, provider.getName());
        putValue(Action.SMALL_ICON, provider.getSmallIcon());
        putValue(LARGE_ICON, provider.getLargeIcon());
        putValue(Action.SHORT_DESCRIPTION, provider.getDescription());
        putValue(Action.LONG_DESCRIPTION, provider.getDescription());
        putValue(Action.MNEMONIC_KEY, new Integer(provider.getMnemonic()));
        putValue(Action.ACTION_COMMAND_KEY, provider.getName());
        putValue(StandardAction.ON_MENUBAR, new Boolean(true));
        putValue(StandardAction.MENU_NAME, "Tools");
        putValue(StandardAction.MENU_ITEM_GROUP, new Integer(10));
        putValue(StandardAction.MENU_ITEM_WEIGHT, new Integer(70));
        putValue(StandardAction.ON_TOOLBAR, new Boolean(true));
        putValue(StandardAction.TOOLBAR_GROUP, new Integer(40));
        putValue(StandardAction.TOOLBAR_WEIGHT, new Integer(20));
    }

    public SessionProvider getProvider() {
        return provider;
    }
}
