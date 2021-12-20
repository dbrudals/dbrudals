package com.swh.rabbitmq.project;

import java.io.Serializable;
import lombok.Data;

@Data
public class FileData implements Serializable {
    private String fileName;
    private int data;
    private byte[] data2;
    
    public FileData(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public String toString() {
        return String.format("Body{fileName='%s', data='%s'}", fileName, data);
    }
}