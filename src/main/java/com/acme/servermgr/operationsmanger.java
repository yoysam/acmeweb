package com.acme.servermgr;

public class operationsmanger extends decratedManger {

public operationsmanger(mangers submit){
    super(submit);
}
    @Override
    public String returnstatus() {
        return decorated.returnstatus()+ ", and is operating normally";
    }
}
