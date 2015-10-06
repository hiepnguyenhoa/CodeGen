/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.factory;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hiep
 */
public class FactoryProducer {

    static Map<Integer, CGComponentFactory> factories = new HashMap<>();

    public static CGComponentFactory getFactory(FactoryType ftype) {
        CGComponentFactory factory = null;
        switch (ftype) {
            case FACTORY_XML:
                factory = factories.get(FactoryType.FACTORY_XML);
                if(factory==null){
                    factory = new CGComponentFactoryImpl();
                    factories.put(ftype.getId(), factory);
                }
                break;
        }
        return factory;
    }
}
