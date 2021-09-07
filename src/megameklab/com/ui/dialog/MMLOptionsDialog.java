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
package megameklab.com.ui.dialog;

import megamek.client.ui.dialogs.suiteOptionsDialogs.MMOptionsDialog;
import megamek.client.ui.enums.ValidationState;
import megamek.common.util.EncodeControl;
import megameklab.com.ui.panes.MMLOptionsPane;

import javax.swing.*;
import java.util.ResourceBundle;

public class MMLOptionsDialog extends MMOptionsDialog {
    //region Variable Declarations
    private MMLOptionsPane mmlOptionsPane;

    private final ResourceBundle mmlResources = ResourceBundle.getBundle("megameklab.resources.Dialogs", new EncodeControl());
    //endregion Variable Declarations

    //region Constructors
    public MMLOptionsDialog(final JFrame frame) {
        this(frame, "MMLOptionsDialog");
        setTitle(mmlResources.getString("MMLOptionsDialog.title"));
    }

    protected MMLOptionsDialog(final JFrame frame, final String name) {
        super(frame, name);
    }
    //endregion Constructors

    //region Getters/Setters
    public MMLOptionsPane getMMLOptionsPane() {
        return mmlOptionsPane;
    }

    public void setMMLOptionsPane(final MMLOptionsPane mmlOptionsPane) {
        this.mmlOptionsPane = mmlOptionsPane;
    }
    //endregion Getters/Setters

    //region Initialization
    @Override
    protected JTabbedPane createCenterPane() {
        super.createCenterPane();

        setMMLOptionsPane(new MMLOptionsPane(getFrame()));
        getTabbedPane().addTab(mmlResources.getString("mmlOptionsPane.title"), getMMLOptionsPane());
        return getTabbedPane();
    }
    //endregion Initialization

    //region Button Actions
    @Override
    protected void okAction() {
        super.okAction();
        getMMLOptionsPane().save();
    }

    @Override
    protected ValidationState validateAction(final boolean display) {
        final ValidationState currentState = super.validateAction(display);
        if (currentState.isFailure()) {
            return currentState;
        }

        final ValidationState state = getMMLOptionsPane().validateData(display, getOkButton());
        return state.isSuccess() ? currentState : state;
    }
    //endregion Button Actions
}
