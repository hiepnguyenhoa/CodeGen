/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.parser.component;

/**
 *
 * @author Hiep
 */
public class CGPropertyInfoImpl extends CGParserComponentAbst implements CGPropertyInfo{
    
    private String type;
    private String constraint;

    public CGPropertyInfoImpl() {
    }

    public CGPropertyInfoImpl(String name, String type, String constraint, String inherit) {
        this.name = name;
        this.type = type;
        this.constraint = constraint;
        this.inherit = inherit;
    }

    public CGPropertyInfoImpl(String name, String dbName, String type, String constraint, String inherit) {
        this.name = name;
        this.dbName = dbName;
        this.type = type;
        this.constraint = constraint;
        this.inherit = inherit;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getConstraint() {
        return constraint;
    }

    @Override
    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }

    
}
