/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.factory;

import com.iselect.codegen.component.IdentifyPropertyImpl;
import com.iselect.codegen.component.SimplePropertyImpl;
import com.iselect.codegen.component.CGPropertyComponentAbs;
import com.iselect.codegen.parser.component.CGPropertyInfo;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Hiep
 */
public class CGComponentFactoryImpl extends CGComponentFactoryAbst<CGPropertyComponentAbs>{

    @Override
    public CGPropertyComponentAbs buildIdentifyComponent(CGPropertyInfo propertyInfo) {
        IdentifyPropertyImpl property = new IdentifyPropertyImpl();
        try {
            BeanUtils.copyProperties(property, propertyInfo);
        } catch (IllegalAccessException | InvocationTargetException ex) {
//            Logger.getLogger(CGComponentFactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return property;
    }

    @Override
    public CGPropertyComponentAbs buildPropertyComponent(CGPropertyInfo propertyInfo) {
        SimplePropertyImpl property = new SimplePropertyImpl();
        try {
            BeanUtils.copyProperties(property, propertyInfo);
        } catch (IllegalAccessException | InvocationTargetException ex) {
//            Logger.getLogger(CGComponentFactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return property;
    }

    @Override
    public CGPropertyComponentAbs buildInnerPropertyComponent(CGPropertyInfo propertyInfo) {
        SimplePropertyImpl property = new SimplePropertyImpl();
        try {
            BeanUtils.copyProperties(property, propertyInfo);
        } catch (IllegalAccessException | InvocationTargetException ex) {
//            Logger.getLogger(CGComponentFactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return property;
    }

    @Override
    public CGPropertyComponentAbs buildSupperPropertyComponent(CGPropertyInfo propertyInfo) {
        SimplePropertyImpl property = new SimplePropertyImpl();
        try {
            BeanUtils.copyProperties(property, propertyInfo);
        } catch (IllegalAccessException | InvocationTargetException ex) {
//            Logger.getLogger(CGComponentFactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return property;
    }

    @Override
    public CGPropertyComponentAbs buildOneOnePropertyComponent(CGPropertyInfo propertyInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CGPropertyComponentAbs buildOneManyPropertyComponent(CGPropertyInfo propertyInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CGPropertyComponentAbs buildManyOnePropertyComponent(CGPropertyInfo propertyInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CGPropertyComponentAbs buildManyManyPropertyComponent(CGPropertyInfo propertyInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
