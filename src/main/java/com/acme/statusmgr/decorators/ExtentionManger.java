package com.acme.statusmgr.decorators;

import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.Decoratorbase;

public class ExtentionManger extends Decoratorbase {
    protected Decoratorbase base;
    public ExtentionManger (long id,String header, Decoratorbase base){
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
       return base.getStatusDesc()+", and is using these extensions - " + ServerManager.getExtensions();
    }
}
