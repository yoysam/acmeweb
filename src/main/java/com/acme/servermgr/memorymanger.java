package com.acme.servermgr;

public class memorymanger extends decratedManger {

    public memorymanger(mangers mangers){
        super(mangers);
    }
    @Override
     public String returnstatus(){
        return decorated.returnstatus() + ", and its memory is Running low";
    }
}
