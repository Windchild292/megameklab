/*
 * MegaMekLab - Copyright (C) 2008
 *
 * Original author - jtighe (torren@users.sourceforge.net)
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 */

package megameklab.com.ui.Mek.views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import megamek.common.EquipmentType;
import megamek.common.Mech;
import megamek.common.MiscType;
import megamek.common.Mounted;
import megamek.common.verifier.EntityVerifier;
import megamek.common.verifier.TestEntity;
import megamek.common.verifier.TestMech;
import megameklab.com.util.IView;
import megameklab.com.util.UnitUtil;

public class SummaryView extends IView{

    /**
     * 
     */
    private static final long serialVersionUID = -8492419359401770037L;
    
    private JTextField txtStructTon = new JTextField("?");
    private JTextField txtEngineTon = new JTextField("?");
    private JTextField txtGyroTon = new JTextField("?");
    private JTextField txtCockpitTon = new JTextField("?");
    private JTextField txtHeatTon = new JTextField("?");
    private JTextField txtArmorTon = new JTextField("?");
    private JTextField txtEnhanceTon = new JTextField("?");
    private JTextField txtJumpTon = new JTextField("?");
    private JTextField txtEquipTon = new JTextField("?");
    private JTextField txtOtherTon = new JTextField("?");
    
    private JTextField txtStructCrit = new JTextField("?");
    private JTextField txtEngineCrit = new JTextField("?");
    private JTextField txtGyroCrit = new JTextField("?");
    private JTextField txtCockpitCrit = new JTextField("?");
    private JTextField txtHeatCrit = new JTextField("?");
    private JTextField txtArmorCrit = new JTextField("?");
    private JTextField txtEnhanceCrit = new JTextField("?");
    private JTextField txtJumpCrit = new JTextField("?");
    private JTextField txtEquipCrit = new JTextField("?");
    private JTextField txtOtherCrit = new JTextField("?");
    
    private JTextField txtStructAvail = new JTextField("?");
    private JTextField txtEngineAvail = new JTextField("?");
    private JTextField txtGyroAvail = new JTextField("?");
    private JTextField txtCockpitAvail = new JTextField("?");
    private JTextField txtHeatAvail = new JTextField("?");
    private JTextField txtArmorAvail = new JTextField("?");
    private JTextField txtEnhanceAvail = new JTextField("?");
    private JTextField txtJumpAvail = new JTextField("?");
    private JTextField txtEquipAvail = new JTextField("?");
    private JTextField txtOtherAvail = new JTextField("?");

    private EntityVerifier entityVerifier = new EntityVerifier(new File("data/mechfiles/UnitVerifierOptions.xml"));
    
    public SummaryView(Mech unit) {
        super(unit);
    
        Vector<JTextField> valueFields = new Vector<JTextField>();

        valueFields.add(txtStructTon);
        valueFields.add(txtEngineTon);
        valueFields.add(txtGyroTon);
        valueFields.add(txtCockpitTon);
        valueFields.add(txtHeatTon);
        valueFields.add(txtArmorTon);
        valueFields.add(txtEnhanceTon);
        valueFields.add(txtJumpTon);
        valueFields.add(txtEquipTon);
        valueFields.add(txtOtherTon);
        
        valueFields.add(txtStructCrit);
        valueFields.add(txtEngineCrit);
        valueFields.add(txtGyroCrit);
        valueFields.add(txtCockpitCrit);
        valueFields.add(txtHeatCrit);
        valueFields.add(txtArmorCrit);
        valueFields.add(txtEnhanceCrit);
        valueFields.add(txtJumpCrit);
        valueFields.add(txtEquipCrit);
        valueFields.add(txtOtherCrit);

        Dimension size = new Dimension(45,25);
        for(JTextField field : valueFields) {
            field.setEditable(false);
            field.setSize(size);
            field.setPreferredSize(size);
            field.setMinimumSize(size);
            field.setMaximumSize(size);
            field.setHorizontalAlignment(JTextField.RIGHT);
        }
        
        valueFields.removeAllElements();
        
        valueFields.add(txtStructAvail);
        valueFields.add(txtEngineAvail);
        valueFields.add(txtGyroAvail);
        valueFields.add(txtCockpitAvail);
        valueFields.add(txtHeatAvail);
        valueFields.add(txtArmorAvail);
        valueFields.add(txtEnhanceAvail);
        valueFields.add(txtJumpAvail);
        valueFields.add(txtEquipAvail);
        valueFields.add(txtOtherAvail);

        size = new Dimension(80,25);
        for(JTextField field : valueFields) {
            field.setEditable(false);
            field.setSize(size);
            field.setPreferredSize(size);
            field.setMinimumSize(size);
            field.setMaximumSize(size);
        }
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        size = new Dimension(120,25);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,0,5);
        this.add(createLabel("Category", size, JLabel.CENTER), gbc);
        gbc.gridy = 1;
        this.add(createLabel("Internal Structure:", size, JLabel.RIGHT), gbc);
        gbc.gridy = 2;
        this.add(createLabel("Engine:", size, JLabel.RIGHT), gbc);
        gbc.gridy = 3;
        this.add(createLabel("Gyro:", size, JLabel.RIGHT), gbc);
        gbc.gridy = 4;
        this.add(createLabel("Cockpit:", size, JLabel.RIGHT), gbc);
        gbc.gridy = 5;
        this.add(createLabel("Heat Sinks:", size, JLabel.RIGHT), gbc);
        gbc.gridy = 6;
        this.add(createLabel("Armor:", size, JLabel.RIGHT), gbc);
        gbc.gridy = 7;
        this.add(createLabel("Enhancements:", size, JLabel.RIGHT), gbc);
        gbc.gridy = 8;
        this.add(createLabel("Jump Jets:", size, JLabel.RIGHT), gbc);
        gbc.gridy = 9;
        this.add(createLabel("Equipment", size, JLabel.RIGHT), gbc);
        gbc.gridy = 10;
        this.add(createLabel("Other:", size, JLabel.RIGHT), gbc);
        
        size = new Dimension(45,25);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,0,0);
        this.add(createLabel("Ton", size, JLabel.CENTER), gbc);
        gbc.gridy = 1;
        this.add(txtStructTon, gbc);
        gbc.gridy = 2;
        this.add(txtEngineTon, gbc);
        gbc.gridy = 3;
        this.add(txtGyroTon, gbc);
        gbc.gridy = 4;
        this.add(txtCockpitTon, gbc);
        gbc.gridy = 5;
        this.add(txtHeatTon, gbc);
        gbc.gridy = 6;
        this.add(txtArmorTon, gbc);
        gbc.gridy = 7;
        this.add(txtEnhanceTon, gbc);
        gbc.gridy = 8;
        this.add(txtJumpTon, gbc);
        gbc.gridy = 9;
        this.add(txtEquipTon, gbc);
        gbc.gridy = 10;
        this.add(txtOtherTon, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(createLabel("Crit", size, JLabel.CENTER), gbc);
        gbc.gridy = 1;
        this.add(txtStructCrit, gbc);
        gbc.gridy = 2;
        this.add(txtEngineCrit, gbc);
        gbc.gridy = 3;
        this.add(txtGyroCrit, gbc);
        gbc.gridy = 4;
        this.add(txtCockpitCrit, gbc);
        gbc.gridy = 5;
        this.add(txtHeatCrit, gbc);
        gbc.gridy = 6;
        this.add(txtArmorCrit, gbc);
        gbc.gridy = 7;
        this.add(txtEnhanceCrit, gbc);
        gbc.gridy = 8;
        this.add(txtJumpCrit, gbc);
        gbc.gridy = 9;
        this.add(txtEquipCrit, gbc);
        gbc.gridy = 10;
        this.add(txtOtherCrit, gbc);
        
        size = new Dimension(80,25);
        gbc.gridx = 3;
        gbc.gridy = 0;
        this.add(createLabel("Availability", size, JLabel.CENTER), gbc);
        gbc.gridy = 1;
        this.add(txtStructAvail, gbc);
        gbc.gridy = 2;
        this.add(txtEngineAvail, gbc);
        gbc.gridy = 3;
        this.add(txtGyroAvail, gbc);
        gbc.gridy = 4;
        this.add(txtCockpitAvail, gbc);
        gbc.gridy = 5;
        this.add(txtHeatAvail, gbc);
        gbc.gridy = 6;
        this.add(txtArmorAvail, gbc);
        gbc.gridy = 7;
        this.add(txtEnhanceAvail, gbc);
        gbc.gridy = 8;
        this.add(txtJumpAvail, gbc);
        gbc.gridy = 9;
        this.add(txtEquipAvail, gbc);
        gbc.gridy = 10;
        this.add(txtOtherAvail, gbc);
        
        this.setBorder(BorderFactory.createTitledBorder("Summary"));
        
    }
        
    private JLabel createLabel(String text, Dimension size, int align) {

        JLabel label = new JLabel(text, SwingConstants.TRAILING);

        setFieldSize(label, size);
        label.setHorizontalAlignment(align);
        return label;
    }
    
    public void setFieldSize(JComponent box, Dimension maxSize) {
        box.setPreferredSize(maxSize);
        box.setMaximumSize(maxSize);
        box.setMinimumSize(maxSize);
    }
    
    public void refresh() {
        
        TestMech testMech = new TestMech(getMech(), entityVerifier.mechOption, null);
        
        txtGyroTon.setText(Float.toString(testMech.getWeightGyro()));
        txtEngineTon.setText(Float.toString(testMech.getWeightEngine()));
        txtCockpitTon.setText(Float.toString(testMech.getWeightCockpit()));
        txtHeatTon.setText(Float.toString(testMech.getWeightHeatSinks()));
        txtStructTon.setText(Float.toString(testMech.getWeightStructure()));
        txtArmorTon.setText(Float.toString(testMech.getWeightArmor()));
        txtJumpTon.setText(Float.toString(getWeightJumpJets()));
        txtEnhanceTon.setText(Float.toString(getWeightEnhancements()));
        txtEquipTon.setText(Float.toString(testMech.getWeightWeapon() + testMech.getWeightAmmo() + testMech.getArmoredComponentWeight() + getWeightMiscEquip()));
        txtOtherTon.setText(Float.toString(testMech.getWeightPowerAmp() + testMech.getWeightCarryingSpace() + testMech.getWeightMisc()));

        txtGyroCrit.setText(Integer.toString(getGyroCrits()));
        txtCockpitCrit.setText(Integer.toString(getCockpitCrits()));
        String structName = EquipmentType.getStructureTypeName(getMech().getStructureType());
        txtStructCrit.setText(Integer.toString(EquipmentType.get(structName).getCriticals(getMech())));
        txtArmorCrit.setText(Integer.toString(EquipmentType.get(EquipmentType.getArmorTypeName(unit.getArmorType(0))).getCriticals(unit)));
        
    
    }
    
    private float getWeightMiscEquip() {
        float weightSum = 0.0f;
        for (Mounted m : getMech().getMisc()) {
            MiscType mt = (MiscType) m.getType();
            if (mt.hasFlag(MiscType.F_ENDO_STEEL)
                    || mt.hasFlag(MiscType.F_FERRO_FIBROUS)
                    || mt.hasFlag(MiscType.F_FERRO_LAMELLOR)
                    || mt.hasFlag(MiscType.F_ENDO_COMPOSITE)
                    || mt.hasFlag(MiscType.F_HEAT_SINK)
                    || mt.hasFlag(MiscType.F_DOUBLE_HEAT_SINK)
                    || mt.hasFlag(MiscType.F_IS_DOUBLE_HEAT_SINK_PROTOTYPE)
                    || mt.hasFlag(MiscType.F_JUMP_JET)
                    || mt.hasFlag(MiscType.F_JUMP_BOOSTER)
                    || mt.hasFlag(MiscType.F_TSM)
                    || mt.hasFlag(MiscType.F_INDUSTRIAL_TSM)
                    || mt.hasFlag(MiscType.F_MASC)) {
                continue;
            }
            weightSum += mt.getTonnage(getMech(), m.getLocation());
        }
        return weightSum;
    }
        
    private float getWeightEnhancements() {
        float weightSum = 0.0f;
        for (Mounted m : getMech().getMisc()) {
            MiscType mt = (MiscType) m.getType();
            if (mt.hasFlag(MiscType.F_TSM)
                    || mt.hasFlag(MiscType.F_INDUSTRIAL_TSM)
                    || mt.hasFlag(MiscType.F_MASC)) {
                weightSum += mt.getTonnage(getMech(), m.getLocation());
            }
            
        }
        return weightSum;
    }
    
    private float getWeightJumpJets() {
        float weightSum = 0.0f;
        for (Mounted m : getMech().getMisc()) {
            MiscType mt = (MiscType) m.getType();
            if (mt.hasFlag(MiscType.F_JUMP_JET)
                    || mt.hasFlag(MiscType.F_JUMP_BOOSTER)) {
                weightSum += mt.getTonnage(getMech(), m.getLocation());
            }
        }
        return weightSum;
    }
    
    private int getGyroCrits() {
        switch(getMech().getGyroType()) {
        case Mech.GYRO_COMPACT:
            return 2;
        case Mech.GYRO_XL:
            return 6;
        default:
            return 4;
        }
    }
    
    private int getCockpitCrits() {
        switch(getMech().getCockpitType()) {
        case Mech.COCKPIT_COMMAND_CONSOLE:
            return 2;
        default:
            return 1;
        }
    }

}
