package com.acme.servermgr;

/**
 * Manage all servers (service providers) being tracked by the Acme server tracking system
 * For now just some simple static methods for use in school project
 */
public class ServerManager implements  mangers {

    /**
     * Get the status of this server
     * @return a descriptive string about the servers status
     */
    @Override
     public String returnstatus() {
        return "Server is up";
    }

    /**
     * Find out if this server is operating normally
     * @return Boolean indicating if server is operating normally
     */
    static public Boolean isOperatingNormally()
    {
        return true;
    }
}
