package com.acme.statusmgr.decorators.simple;

import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.Decoratorbase;

/**
 * adds information about memory for the simple factory the id is set to 0 and the header to null so they wont shpw up
 */
public class simplememorydecorator extends Decoratorbase {
    Decoratorbase base;
    public simplememorydecorator(Decoratorbase base){
        this.base=base;
    }
    @Override
    public String getStatusDesc() {
        return base.getStatusDesc()+ ", and its " + ServerManager.getMemory();
    }
}
