package com.acme.statusmgr.decorators;

import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.Decoratorbase;

public class memorydecorator extends Decoratorbase {
    protected Decoratorbase base;
    public memorydecorator(long id, String header, Decoratorbase base){
        super(id,header);
        this.base=base;
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public String getContentHeader() {
        return super.getContentHeader();
    }

    @Override
    public String getStatusDesc() {
        return base.getStatusDesc()+ ", and its " + ServerManager.getMemory();
    }
}
