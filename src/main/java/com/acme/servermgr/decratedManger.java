package com.acme.servermgr;

public abstract class decratedManger implements mangers {
    protected mangers decorated;
    public decratedManger(mangers decorated){
        this.decorated=decorated;
    }
    public String returnstatus() {
        return null;
    }
}
