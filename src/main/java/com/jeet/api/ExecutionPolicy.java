package com.jeet.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Aroras on 7/6/2016.
 */
@XmlType
@XmlEnum(String.class)
public enum ExecutionPolicy {
    @XmlEnumValue("SERIAL")
    SERIAL,
    @XmlEnumValue("PARALLEL")
    PARALLEL
}
