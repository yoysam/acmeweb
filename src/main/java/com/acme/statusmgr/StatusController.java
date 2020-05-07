package com.acme.statusmgr;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.acme.servermgr.BadRequestException;
import com.acme.statusmgr.beans.Decoratorbase;
import com.acme.statusmgr.beans.factories.Factory;
import com.acme.statusmgr.beans.factories.complexfactor;
import com.acme.statusmgr.beans.factories.simplefactory;
import com.acme.statusmgr.decorators.complex.ExtentionDecorator;
import com.acme.statusmgr.decorators.complex.basicdecorator;
import com.acme.statusmgr.decorators.complex.memorydecorator;
import com.acme.statusmgr.decorators.complex.operationsdecorator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for all web/REST requests about the status of servers
 *
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 *    All start with /server
 *    /status  will give back status of server
 *    a param of 'name' specifies a requestor name to appear in response
 *
 * Examples:
 *    http://localhost:8080/server/status
 *
 *    http://localhost:8080/server/status?name=Noach
 *
 *
 *
 */

@RestController
@RequestMapping("/server")
public class StatusController {
    static {
        // For debug/demo purposes only, dump out class path to stdout to show where resources will come from
        System.out.println("*** JAVA CLASS PATH***\n" +
                System.getProperty("java.class.path").replace  (":", "      :      ") + "***********\n");
    }
    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();


    @RequestMapping("/status")
    public Decoratorbase GenerateStatus(@RequestParam(value="name", defaultValue="Anonymous") String name ) {

        return new basicdecorator(counter.incrementAndGet(),
                String.format(template, name)); }
    @RequestMapping(value = "/status/detailed", method = RequestMethod.GET)

    public Decoratorbase showServerStatusDetails(@RequestParam(value = "details") List<String> details,
                                                @RequestParam(value = "name", required = false, defaultValue = "Anonymous") String name,
                                                @RequestParam(value = "levelOfDetail", required = false, defaultValue = "complex") String levelOfDetail) throws BadRequestException {
        System.out.println("*** DEBUG INFO ***" + name + "  details=  " + details);
        if (details == null) {
            throw new BadRequestException("Required List parameter 'details' is not present\",\"path\":\"/server/status/detailed\"");
        }
        long id=counter.incrementAndGet();
        String header= String.format(template,name);
        Factory factory;
        Decoratorbase base = new basicdecorator(id,header);
        /**
         * checking what facotry to use
         */
        if (levelOfDetail.equalsIgnoreCase("simple")){
            factory=new simplefactory();
            base=factory.create(0,null,details);
        }
        else if (levelOfDetail.equals("complex")){
            factory=new complexfactor();
            base=factory.create(id,header,details);
        }
        else {
            throw new BadRequestException("Not a valid level:" + levelOfDetail);
        }

        return base;
    }


    }

