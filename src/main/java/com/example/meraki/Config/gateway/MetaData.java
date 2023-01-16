package com.example.meraki.Config.gateway;

import lombok.Data;

@Data
public class MetaData {
    private String key;
    private String value;

    public MetaData() {
    }

    public MetaData(String key, String value) {
        this.key = key;
        this.value = value;
    }

}
