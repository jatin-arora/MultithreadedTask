package com.jeet.config;

import com.jeet.api.ExecutionPolicy;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static logs.Logger.log;

/**
 * Created by Aroras on 7/6/2016.
 */
public class Parser {
    private Config config;
    public Parser parse(String xml){
        try {
            File file = new File(xml);
            JAXBContext jaxbContext = JAXBContext.newInstance(Config.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            config = (Config) jaxbUnmarshaller.unmarshal(file);
            System.out.println(config.getExecutionPolicy().toString()+ "");
            System.out.println(config.getExecutionPolicy() == ExecutionPolicy.PARALLEL);
        }catch(Exception exp){
            log(this, "Exception");
            exp.printStackTrace();
        }
        return this;
    }

    public Config getConfig() {
        if( config == null){
            throw new RuntimeException("Config is not parsed yet..");
        }
        return config;
    }
}
