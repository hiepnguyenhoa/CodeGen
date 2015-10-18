/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.factory;

/**
 *
 * @author Hiep
 */
public class FactoryProducer {

    public static CGComponentFactory getFactory(FactoryType ftype) {
        CGComponentFactory factory = null;
        switch (ftype) {
            case FACTORY_XML:
                factory = CGComponentFactoryImpl.getInstance();
                break;
        }
        return factory;
    }
}
