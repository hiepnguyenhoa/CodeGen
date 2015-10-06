/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.parser.event;

import com.iselect.codegen.parser.component.CGPropertyInfo;

/**
 *
 * @author Hiep
 */
public class CGNewPropertyEventImpl extends CGParserEventAbst<CGParserEventType, CGPropertyInfo>{

    public CGNewPropertyEventImpl(CGParserEventType type, CGPropertyInfo component) {
        super(type, component);
    }

    
}
