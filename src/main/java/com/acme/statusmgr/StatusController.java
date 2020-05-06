package com.acme.statusmgr;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.acme.servermgr.BadRequestException;
import com.acme.statusmgr.beans.Decoratorbase;
import com.acme.statusmgr.decorators.ExtentionDecorator;
import com.acme.statusmgr.decorators.basicdecorator;
import com.acme.statusmgr.decorators.memorydecorator;
import com.acme.statusmgr.decorators.operationsdecorator;
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

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();


    @RequestMapping("/status")
    public Decoratorbase GenerateStatus(@RequestParam(value="name", defaultValue="Anonymous") String name ) {

        return new basicdecorator(counter.incrementAndGet(),
                String.format(template, name)); }
    @RequestMapping(value = "/status/detailed", method = RequestMethod.GET)
    public Decoratorbase showServerStatusDetails(@RequestParam(value = "details") List<String> details,
                                                 @RequestParam(value = "name", required = false, defaultValue = "Anonymous") String name) throws BadRequestException {
        System.out.println("*** DEBUG INFO ***" + name + "  details=  " + details);
        if (details == null) {
            throw new BadRequestException("Required List parameter 'details' is not present\",\"path\":\"/server/status/detailed\"");
        }
        long id=counter.incrementAndGet();
        String header= String.format(template,name);

        Decoratorbase base = new basicdecorator(id,header);

        Decoratorbase decoratedBase = decorate(id,header,details,base);

        return decoratedBase;
    }

    private Decoratorbase decorate(long id, String header, List<String> details, Decoratorbase base) {
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

