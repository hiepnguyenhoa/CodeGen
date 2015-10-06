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
public abstract class CGPropertyComponentAbs extends CGComponentAbs implements CGPropertyComponent{
    private String type;
    private String constraint;

    public CGPropertyComponentAbs() {
    }
    
    public CGPropertyComponentAbs(String name) {
        super(name);
    }

    public CGPropertyComponentAbs(String name, String inherit) {
        super(name, inherit);
    }

    public CGPropertyComponentAbs(String name, String dbName, String inherit) {
        super(name, dbName, inherit);
    }

    public CGPropertyComponentAbs(String type, String name, String dbName, String inherit) {
        super(name, dbName, inherit);
        this.type = type;
    }

    public CGPropertyComponentAbs(String type, String constraint, String name, String dbName, String inherit) {
        super(name, dbName, inherit);
        this.type = type;
        this.constraint = constraint;
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
