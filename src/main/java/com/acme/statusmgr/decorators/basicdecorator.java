package com.acme.statusmgr.decorators;

import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.Decoratorbase;

public class basicdecorator extends Decoratorbase {
    public basicdecorator(long id, String header){
                super(id,header);
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
        return ServerManager.returnstatus();
    }
}
