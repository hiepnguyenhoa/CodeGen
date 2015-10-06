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
public enum CGComponentTypeImpl implements CGComponentType {
    CLASS(1),
    IDENTIFY(2),
    ONE_ONE(3),
    ONE_MANY(4),
    MANY_ONE(5),
    MANY_MANY(6),
    PROPERTY(7),
    INNER_PROPERTY(8),
    SUPER_PROPERTY(9);
    
    private final int value;

    private CGComponentTypeImpl(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
    
}
