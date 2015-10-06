/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.parser.event;

import com.iselect.codegen.parser.component.CGClassInfo;

/**
 *
 * @author Hiep
 */
public class CGNewClassEventImpl extends CGParserEventAbst<CGParserEventType, CGClassInfo>{

    public CGNewClassEventImpl(CGParserEventType type, CGClassInfo component) {
        super(type, component);
    }

}
