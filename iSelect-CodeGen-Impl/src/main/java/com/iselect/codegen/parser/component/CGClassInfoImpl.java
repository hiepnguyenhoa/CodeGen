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
public class CGClassInfoImpl extends CGParserComponentAbst implements CGClassInfo{
    
    private String packageName;

    public CGClassInfoImpl() {
    }

    public CGClassInfoImpl(String pack, String name){
        this(pack, name, null, null);
    }

    public CGClassInfoImpl(String pack, String name, String inherit) {
        this(pack, name, null, inherit);
    }

    public CGClassInfoImpl(String pack, String name, String dbName, String inherit) {
        super(name, dbName, inherit);
        this.packageName=pack;
        
    }
    
    @Override
    public String getPackageName() {
        return packageName;
    }

    @Override
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    
}
