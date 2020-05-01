package com.acme.servermgr;

public class extentionmanger extends decratedManger {

    public extentionmanger(mangers submit){
        super(submit);

    }
    @Override
    public String returnstatus() {
       return decorated.returnstatus()+", and is using these extensions - [Hypervisor, Kubernetes, RAID-6]";
    }
}
