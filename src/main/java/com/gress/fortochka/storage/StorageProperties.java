package com.gress.fortochka.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Roman_Radetskiy.
 */
@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}