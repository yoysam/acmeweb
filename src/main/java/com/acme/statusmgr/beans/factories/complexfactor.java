package com.acme.statusmgr.beans.factories;

import com.acme.servermgr.BadRequestException;
import com.acme.statusmgr.beans.Decoratorbase;
import com.acme.statusmgr.decorators.complex.ExtentionDecorator;
import com.acme.statusmgr.decorators.complex.basicdecorator;
import com.acme.statusmgr.decorators.complex.memorydecorator;
import com.acme.statusmgr.decorators.complex.operationsdecorator;

import java.util.List;

/**
 * complex facroty has a id and header
 */
public class complexfactor implements Factory {
    @Override
    public  Decoratorbase create(long id, String header, List<String> details) {
        Decoratorbase base=new basicdecorator(id,header);
        for (String s : details) {
            if (s.equalsIgnoreCase("operations")) {
                base = new operationsdecorator(base);
            } else if (s.equalsIgnoreCase("memory")) {
                base = new memorydecorator(base);
            } else if (s.equalsIgnoreCase("extensions")) {
                base = new ExtentionDecorator(base);
            } else {
                throw new BadRequestException(s + " is not a valid details option");
            }
        }
        return base;
    }
    }

