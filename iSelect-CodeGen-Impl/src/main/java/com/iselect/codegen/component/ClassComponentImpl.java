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
public class ClassComponentImpl extends CGClassComponentAbs<CGPropertyComponentAbs> {
    
    public static final String TEMP_ID = "CLASS_TEMP";

    public ClassComponentImpl() {
    }

    public ClassComponentImpl(String name) {
        super(name);
    }

    public ClassComponentImpl(String name, String inherit) {
        super(name, inherit);
    }

    public ClassComponentImpl(String name, String dbName, String inherit) {
        super(name, dbName, inherit);
    }

    public ClassComponentImpl(String packageName, String name, String dbName, String inherit) {
        super(packageName, name, dbName, inherit);
    }

}
