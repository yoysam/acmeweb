package com.acme.statusmgr.decorators.simple;

import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.Decoratorbase;

/**
 * adds information about operations for the simple factory the id is set to 0 and the header to null so they wont shpw up
 */
public class simpleoperationsdecorator extends Decoratorbase {
    Decoratorbase base;
    public simpleoperationsdecorator(Decoratorbase base){
        this.base=base;
    }
    @Override
    public String getStatusDesc() {
        return base.getStatusDesc()+ ", and " + ServerManager.getOperations();
    }
}
