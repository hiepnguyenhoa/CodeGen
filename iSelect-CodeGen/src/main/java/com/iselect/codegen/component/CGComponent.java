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
public interface CGComponent {
    public void setName(String name);
    public String getName();
    
    public void setDbName(String dbName);
    public String getDbName();
    
    public void setInherit(String inherit);
    public String getInherit();
}
