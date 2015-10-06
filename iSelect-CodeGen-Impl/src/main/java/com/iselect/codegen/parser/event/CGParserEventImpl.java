/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.parser.event;

import com.iselect.codegen.parser.component.CGComponent;

/**
 *
 * @author Hiep
 * @param <CGParserEventType>
 * @param <CGParserComponent>
 */
public class CGParserEventImpl implements CGParserEvent<CGParserEventType, CGComponent>{
    private final CGParserEventType eventType;
    private final CGComponent component;

    public CGParserEventImpl(CGParserEventType eventType, CGComponent component) {
        this.eventType = eventType;
        this.component = component;
    }

    @Override
    public CGParserEventType getEventType() {
        return this.eventType;
    }

    @Override
    public CGComponent getComponent() {
        return this.component;
    }

    
}
