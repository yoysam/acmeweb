package com.acme.statusmgr.decorators.simple;

import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.Decoratorbase;

/**
 * add information about extentions for the simple factory the id is set to 0 and the header to null so they wont shpw up
 */
public class simpleExtentionDecorator extends Decoratorbase {
    Decoratorbase base;
    public  simpleExtentionDecorator(Decoratorbase base){
        this.base=base;
    }
    @Override
    public String getStatusDesc() {
        return base.getStatusDesc()+", and is using these extensions - " + super.serverManager.getExtensions();
    }
}
