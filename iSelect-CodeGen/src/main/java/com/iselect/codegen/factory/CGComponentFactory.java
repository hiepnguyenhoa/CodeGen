/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.factory;

import com.iselect.codegen.component.CGComponentType;
import com.iselect.codegen.component.CGPropertyComponent;
import com.iselect.codegen.parser.component.CGPropertyInfo;

/**
 *
 * @author Hiep
 * @param <T> CGParserComponent
 * @param <P>
 */
public interface CGComponentFactory<T extends CGComponentType, P extends CGPropertyComponent> {
    public T getBuildType(CGPropertyInfo compValue);
    public P buildComponent(CGPropertyInfo compValue);
}
