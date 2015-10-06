/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.factory;

import com.iselect.codegen.parser.component.CGPropertyInfo;
import com.iselect.codegen.parser.util.ParserUtil;
import com.iselect.codegen.component.CGComponentType;
import com.iselect.codegen.component.CGComponentTypeImpl;
import com.iselect.codegen.component.CGPropertyComponent;

/**
 *
 * @author Hiep
 * @param <P>
 */
public abstract class CGComponentFactoryAbst<P extends CGPropertyComponent> implements CGComponentFactory<CGComponentType, P> {

    @Override
    public CGComponentTypeImpl getBuildType(CGPropertyInfo compValue) {
        return ParserUtil.getPropertyType(compValue);
    }

    @Override
    public P buildComponent(CGPropertyInfo propertyInfo) {
        P propertyComponent = null;

        CGComponentTypeImpl type = getBuildType(propertyInfo);

        switch (type) {
            case IDENTIFY:
                propertyComponent = buildIdentifyComponent(propertyInfo);
                break;
            case PROPERTY:
                propertyComponent = buildPropertyComponent(propertyInfo);
                break;
            case INNER_PROPERTY:
                propertyComponent = buildInnerPropertyComponent(propertyInfo);
                break;
            case SUPER_PROPERTY:
                propertyComponent = buildSupperPropertyComponent(propertyInfo);
                break;
            case ONE_ONE:
                propertyComponent = buildOneOnePropertyComponent(propertyInfo);
                break;
            case ONE_MANY:
                propertyComponent = buildOneManyPropertyComponent(propertyInfo);
                break;
            case MANY_ONE:
                propertyComponent = buildManyOnePropertyComponent(propertyInfo);
                break;
            case MANY_MANY:
                propertyComponent = buildManyManyPropertyComponent(propertyInfo);
                break;
            
        }
        return propertyComponent;
    }

    public abstract P buildIdentifyComponent(CGPropertyInfo propertyInfo);

    public abstract P buildPropertyComponent(CGPropertyInfo propertyInfo);

    public abstract P buildInnerPropertyComponent(CGPropertyInfo propertyInfo);

    public abstract P buildSupperPropertyComponent(CGPropertyInfo propertyInfo);

    public abstract P buildOneOnePropertyComponent(CGPropertyInfo propertyInfo);

    public abstract P buildOneManyPropertyComponent(CGPropertyInfo propertyInfo);

    public abstract P buildManyOnePropertyComponent(CGPropertyInfo propertyInfo);

    public abstract P buildManyManyPropertyComponent(CGPropertyInfo propertyInfo);
}
