package com.acme.statusmgr.beans;

import com.acme.Application;
import com.acme.servermgr.*;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Arrays;
import java.util.List;

/**
 * A POJO that represents Server Status and can be used to generate JSON for that status
 */
public abstract class Decoratorbase {

    private  long id;
    private String contentHeader;
    private String statusDesc = "Unknown";
    /**
     * This will refer to an instance of the ServerManager class (no longer static)
     */
    protected ServerManager serverManager;
    /**
     * Construct a ServerStatus using info passed in for identification, and obtaining current
     * server status from the appropriate Manager class.
     *
     * @param id                a numeric identifier/counter of which request this
     * @param contentHeader     info about the request
     */
    public Decoratorbase(long id, String contentHeader) {
        this.id = id;
        this.contentHeader = contentHeader;

        // Obtain current status of server
        // Obtain and save reference to the ServerManager
        serverManager = (ServerManager) Application.getApplicationContext().getBean("serverManager");
    }
public Decoratorbase(){

}



    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public long getId() {
        return id;
    }
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public String getContentHeader() {

        return contentHeader;
    }


    public String getStatusDesc() {
        return serverManager.getCurrentServerStatus();

    }


}
