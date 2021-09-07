/*
 * Copyright (c) 2021 - The MegaMek Team. All Rights Reserved.
 *
 * This file is part of MegaMekLab.
 *
 * MegaMekLab is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MegaMekLab is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MegaMekLab. If not, see <http://www.gnu.org/licenses/>.
 */
package megameklab.com.ui.panes;

import megamek.client.ui.baseComponents.AbstractTabbedPane;
import megamek.client.ui.enums.ValidationState;

import javax.swing.*;

public final class MMLOptionsPane extends AbstractTabbedPane {
    //region Variable Declarations
    //endregion Variable Declarations

    //region Constructors
    public MMLOptionsPane(final JFrame frame) {
        super(frame, "MMLOptionsPane");
        initialize();
    }
    //endregion Constructors

    //region Getters/Setters
    //endregion Getters/Setters

    //region Initialization
    @Override
    protected void initialize() {
        setPreferences();
    }
    //endregion Initialization
    public ValidationState validateData(final boolean display, final JButton btnOk) {

    }

    public void save() {

    }
}
