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

import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;


public class BooleanIconRenderer extends DefaultTableCellRenderer {
    //  Private instance variables
    private Icon trueIcon;

    //  Private instance variables
    private Icon falseIcon;

    public BooleanIconRenderer(Icon trueIcon, Icon falseIcon) {
        this.trueIcon = trueIcon;
        this.falseIcon = falseIcon;
        setHorizontalAlignment(JLabel.CENTER);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
            row, column);
        setText(null);
        setIcon(((Boolean) value).booleanValue() ? trueIcon : falseIcon);

        return this;
    }

    public String getText() {
        return null;
    }
}
