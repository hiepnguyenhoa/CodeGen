/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hiep
 * @param <T>
 */
public abstract class CGClassComponentAbs<T extends CGPropertyComponentAbs> extends CGComponentAbs implements CGClassComponent<T> {
    
    private String packageName;
    private final List<T> properties = new ArrayList<>();

    public CGClassComponentAbs() {
    }

    public CGClassComponentAbs(String name) {
        super(name);
    }

    public CGClassComponentAbs(String name, String inherit) {
        super(name, inherit);
    }

    public CGClassComponentAbs(String name, String dbName, String inherit) {
        super(name, dbName, inherit);
    }
    
    public CGClassComponentAbs(String packageName, String name, String dbName, String inherit) {
        super(name, dbName, inherit);
        this.packageName=packageName;
    }

    @Override
    public String getPackageName() {
        return packageName;
    }

    @Override
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public void addPropertyComponent(T t) {
        this.properties.add(t);
    }

    @Override
    public List<T> getPropertyComponents() {
        return this.properties;
    }

}
