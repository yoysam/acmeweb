package com.acme.statusmgr.beans.factories;

import com.acme.statusmgr.beans.Decoratorbase;

import java.util.List;

/**
 * template for the factories
 */
public interface Factory {
    public  Decoratorbase create (long id, String header, List<String> details);
}
