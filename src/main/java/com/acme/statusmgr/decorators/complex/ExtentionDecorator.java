package com.acme.statusmgr.decorators.complex;

import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.Decoratorbase;

/**
 * adds information about extentions to the complex factory
 */
public class ExtentionDecorator extends Decoratorbase {
    protected Decoratorbase base;
    public ExtentionDecorator( Decoratorbase base){

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
       return base.getStatusDesc()+", and is using these extensions - " + super.serverManager.getExtensions();
    }
}
