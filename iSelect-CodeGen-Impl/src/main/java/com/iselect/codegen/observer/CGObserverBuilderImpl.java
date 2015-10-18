/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.observer;

import com.iselect.codegen.Configuration;
import com.iselect.codegen.factory.CGComponentFactory;
import com.iselect.codegen.factory.FactoryProducer;
import com.iselect.codegen.factory.FactoryType;
import com.iselect.codegen.generator.CGCodeGenerator;
import com.iselect.codegen.table.generator.MappingGenerator;
import com.iselect.codegen.table.generator.TxxxGenAreaGenerator;
import com.iselect.codegen.table.generator.TxxxItemDtoGenerator;
import com.iselect.codegen.table.generator.TxxxItemDtoImplGenerator;
import com.iselect.codegen.table.generator.TxxxItemGenerator;
import com.iselect.codegen.table.generator.TxxxItemModelGenerator;
import com.iselect.codegen.table.generator.TxxxItemModelImplGenerator;

/**
 *
 * @author Hiep
 */
public class CGObserverBuilderImpl implements CGObserverBuilder<CGObserverTypeImpl> {

    private final Configuration config;

    public CGObserverBuilderImpl(Configuration config) {
        this.config = config;
    }

    @Override
    public CGObserver buildObserver(CGObserverTypeImpl oType) {
        CGObserver observer = null;
        CGComponentFactory factory = null;
        CGCodeGenerator generator = null;
        String template = null;
        String baseDir = config.getProperty("generation.base.dir");
        String subDir = null;
        switch (oType) {
            case XML_OBSERVER:
                observer = ObserverProducer.getObserver(oType);
                factory = FactoryProducer.getFactory(FactoryType.FACTORY_XML);
                observer.setFactory(factory);
  
                /* Mapping Generation */
                template = config.getProperty("template.table.mapping");
                subDir = config.getProperty("generation.table.mapping");
                generator = new MappingGenerator(template, baseDir, subDir);
                observer.addCodegener(generator);
                
                /*Model Generation*/
//                _template = config.getProperty("template.table.model");
//                _subDir = config.getProperty("generation.table.model");
//                _generator = new MappingGenerator(_template, _baseDir, _subDir);
//                _observer.addCodegener(_generator);
                
                /*GenArea Generation*/
                template = config.getProperty("template.table.tgenarea");
                subDir = config.getProperty("generation.table.model");
                generator = new TxxxGenAreaGenerator(template, baseDir, subDir);
                observer.addCodegener(generator);
                
                /*TxxItem Interface Generation*/
                template = config.getProperty("template.table.titem");
                subDir = config.getProperty("generation.table.TxxItem");
                generator = new TxxxItemGenerator(template, baseDir, subDir);
                observer.addCodegener(generator);
                
                /*TxxItemModel Interface Generation*/
                template = config.getProperty("template.table.titemModel");
                subDir = config.getProperty("generation.table.TxxItemModel");
                generator = new TxxxItemModelGenerator(template, baseDir, subDir);
                observer.addCodegener(generator);
                
                /*TxxItemModel Implement Generation*/
                template = config.getProperty("template.table.titemModelImpl");
                subDir = config.getProperty("generation.table.TxxItemModelImpl");
                generator = new TxxxItemModelImplGenerator(template, baseDir, subDir);
                observer.addCodegener(generator);
                
                /*TxxItemDto Interface Generation*/
                template = config.getProperty("template.table.item.dto");
                subDir = config.getProperty("generation.table.TxxItemDto");
                generator = new TxxxItemDtoGenerator(template, baseDir, subDir);
                observer.addCodegener(generator);
                
                /*TxxItemDto Implement Generation*/
                template = config.getProperty("template.table.item.dtoImpl");
                subDir = config.getProperty("generation.table.TxxItemDtoImpl");
                generator = new TxxxItemDtoImplGenerator(template, baseDir, subDir);
                observer.addCodegener(generator);
                break;
        }
        return observer;
    }

}
