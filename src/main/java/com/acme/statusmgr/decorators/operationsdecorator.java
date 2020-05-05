package com.acme.statusmgr.decorators;

import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.Decoratorbase;

public class operationsdecorator extends Decoratorbase {
    protected Decoratorbase base;
    public operationsdecorator(long id, String header, Decoratorbase base){
        super(id,header);
        this.base=base;
    }

    @Override
    public String getStatusDesc() {
        return base.getStatusDesc()+ ", and " + ServerManager.getOperations();
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public String getContentHeader() {
        return super.getContentHeader();
    }
}
