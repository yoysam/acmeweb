package com.acme.statusmgr.decorators.complex;

import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.Decoratorbase;

/**
 * adds information about memory for the complex factory
 */
public class memorydecorator extends Decoratorbase {
    protected Decoratorbase base;
    public memorydecorator( Decoratorbase base){

        this.base=base;
    }

    @Override
    public long getId() {
        return base.getId();
    }

    @Override
    public String getContentHeader() {
        return base.getContentHeader();
    }

    @Override
    public String getStatusDesc() {
        return base.getStatusDesc()+ ", and its " + super.serverManager.getMemory();
    }
}
