package com.acme.statusmgr.decorators;

import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.Decoratorbase;

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
       return base.getStatusDesc()+", and is using these extensions - " + ServerManager.getExtensions();
    }
}
