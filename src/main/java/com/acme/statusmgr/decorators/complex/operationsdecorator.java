package com.acme.statusmgr.decorators.complex;

import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.Decoratorbase;

/**
 * adds infromation about operation for the complex factory
 */
public class operationsdecorator extends Decoratorbase {
    protected Decoratorbase base;
    public operationsdecorator( Decoratorbase base){

        this.base=base;
    }

    @Override
    public String getStatusDesc() {
        return base.getStatusDesc()+ ", and " + ServerManager.getOperations();
    }

    @Override
    public long getId() {
        return base.getId();
    }

    @Override
    public String getContentHeader() {
        return base.getContentHeader();
    }
}
