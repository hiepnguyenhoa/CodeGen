/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.parser.util;

import com.iselect.codegen.parser.component.CGPropertyInfo;
import com.iselect.codegen.component.CGComponentTypeImpl;

/**
 *
 * @author Hiep
 */
public class ParserUtil {

    public static CGComponentTypeImpl getPropertyType(CGPropertyInfo prop) {
        if ("PK".equalsIgnoreCase(prop.getConstraint())) {
            return CGComponentTypeImpl.IDENTIFY;
        }
        if ("InnerClass".equalsIgnoreCase(prop.getInherit())) {
            return CGComponentTypeImpl.INNER_PROPERTY;
        }
        if (prop.getInherit() != null) {
            if ("ONE_ONE".equalsIgnoreCase(prop.getConstraint())) {
                return CGComponentTypeImpl.ONE_ONE;
            } else if ("ONE_MANY".equalsIgnoreCase(prop.getConstraint())) {
                return CGComponentTypeImpl.ONE_MANY;
            } else if ("MANY_ONE".equalsIgnoreCase(prop.getConstraint())) {
                return CGComponentTypeImpl.MANY_ONE;
            } else if ("MANY_MANY".equalsIgnoreCase(prop.getConstraint())) {
                return CGComponentTypeImpl.MANY_MANY;
            } else {
                return CGComponentTypeImpl.SUPER_PROPERTY;
            }
        }
        return CGComponentTypeImpl.PROPERTY;
    }
}
