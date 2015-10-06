/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.component;

import java.util.List;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface CGClassComponent<T extends CGPropertyComponent> extends CGComponent {
    public String getPackageName();
    public void setPackageName(String packageName);
    
    public void addPropertyComponent(T t);
    public List<T> getPropertyComponents();
}
