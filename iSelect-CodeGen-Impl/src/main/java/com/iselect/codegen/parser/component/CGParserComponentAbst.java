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
public abstract class CGParserComponentAbst implements CGComponent{
    
    protected String name;
    protected String dbName;
    protected String inherit;

    public CGParserComponentAbst() {
    }

    public CGParserComponentAbst(String name) {
        this(name, null, null);
    }

    public CGParserComponentAbst(String name, String inherit) {
        this(name, null, inherit);
    }

    public CGParserComponentAbst(String name, String dbName, String inherit) {
        this.name = name;
        this.dbName = dbName;
        this.inherit = inherit;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDbName() {
        return dbName;
    }

    @Override
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public String getInherit() {
        return inherit;
    }

    @Override
    public void setInherit(String inherit) {
        this.inherit = inherit;
    }
    
}
