package io.github.asiftasleem.myretail.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.asiftasleem.myretail.model.Host;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * @author muhammad.tasleem
 *
 */
@RestController()
public class StatusController {

    @RequestMapping(value = "/status", method = RequestMethod.GET, produces = "application/json")
    public Host getCustomer(HttpServletRequest request) {
        return new Host(request.getLocalAddr(), request.getLocalPort(), getHostName());
    }

    private String getHostName() {
        InetAddress addr;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return addr.getHostName();
    }

}