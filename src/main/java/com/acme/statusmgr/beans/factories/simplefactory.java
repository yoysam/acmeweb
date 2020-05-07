package com.acme.statusmgr.beans.factories;

import com.acme.servermgr.BadRequestException;
import com.acme.statusmgr.beans.Decoratorbase;
import com.acme.statusmgr.decorators.complex.ExtentionDecorator;
import com.acme.statusmgr.decorators.complex.basicdecorator;
import com.acme.statusmgr.decorators.complex.memorydecorator;
import com.acme.statusmgr.decorators.complex.operationsdecorator;
import com.acme.statusmgr.decorators.simple.simpleExtentionDecorator;
import com.acme.statusmgr.decorators.simple.simplebaasicdecorator;
import com.acme.statusmgr.decorators.simple.simplememorydecorator;
import com.acme.statusmgr.decorators.simple.simpleoperationsdecorator;

import java.util.List;

/**
 * simple factory has id set to 0 and header set to null so they wont show up
 */
public class simplefactory implements Factory {
    @Override
    public Decoratorbase create(long id, String header, List<String> details) {
        Decoratorbase base=new simplebaasicdecorator(id,header);
        for (String s : details) {
            if (s.equalsIgnoreCase("operations")) {
                base = new simpleoperationsdecorator(base);
            } else if (s.equalsIgnoreCase("memory")) {
                base = new simplememorydecorator(base);
            } else if (s.equalsIgnoreCase("extensions")) {
                base = new simpleExtentionDecorator(base);
            } else {
                throw new BadRequestException(s + " is not a valid details option");
            }
        }
        return base;
    }
    }

