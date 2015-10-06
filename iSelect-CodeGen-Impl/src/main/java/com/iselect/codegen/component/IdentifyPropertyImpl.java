/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.component;

/**
 *
 * @author Hiep
 */
public class IdentifyPropertyImpl extends CGPropertyComponentAbs{

    public static final String TEMP_ID="ID_TEMP";
    
    public IdentifyPropertyImpl() {
    }

    @Override
    public String getTemplateId() {
        return this.TEMP_ID;
    }

}
