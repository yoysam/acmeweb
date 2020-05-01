package com.acme.statusmgr.beans;

import com.acme.servermgr.*;

import java.util.Arrays;
import java.util.List;

/**
 * A POJO that represents Server Status and can be used to generate JSON for that status
 */
public class ServerStatus {

    private  long id;
    private String contentHeader;
    private String statusDesc = "Unknown";

    /**
     * Construct a ServerStatus using info passed in for identification, and obtaining current
     * server status from the appropriate Manager class.
     *
     * @param id                a numeric identifier/counter of which request this
     * @param contentHeader     info about the request
     */
    public ServerStatus(long id, String contentHeader) {
        this.id = id;
        this.contentHeader = contentHeader;

        // Obtain current status of server
        this.statusDesc=new ServerManager().returnstatus();
    }

    public ServerStatus() {

    }

    public ServerStatus(long id, String contentHeader, List<String> details) {
        this.id = id;
        this.contentHeader = contentHeader;

        // Obtain current status of server
        mangers Base= new ServerManager();
        for (String s: details){
            if(s.equalsIgnoreCase("operations")){
                Base= new operationsmanger(Base);
            }
            else if(s.equalsIgnoreCase("memory")){
                Base = new memorymanger(Base);
            }
            else if(s.equalsIgnoreCase("extensions")){
                Base = new extentionmanger(Base);
            }
            else{
                throw  new BadRequestException("Invalid details option:"+ s);
            }
        }
        this.statusDesc = Base.returnstatus();
    }

    public long getId() {
        return id;
    }

    public String getContentHeader() {

        return contentHeader;
    }


    public String getStatusDesc() {
        return statusDesc;
    }


}
