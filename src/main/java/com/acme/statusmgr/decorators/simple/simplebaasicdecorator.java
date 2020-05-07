package com.acme.statusmgr.decorators.simple;

import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.Decoratorbase;

/**
 * the simple base for the simple factory the id is set to 0 and the header to null so they wont shpw up
 */
public class simplebaasicdecorator extends Decoratorbase {
    public simplebaasicdecorator (long id,String header){
        super(id,header);
    }
    @Override
    public String getStatusDesc() {
        return ServerManager.returnstatus();
}}
