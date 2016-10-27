package io.github.asiftasleem.myretail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author muhammad.tasleem
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Host {

    private String address;
    private int port;
    private String hostName;
}
