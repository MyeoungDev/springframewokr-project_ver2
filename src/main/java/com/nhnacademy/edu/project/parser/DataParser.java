package com.nhnacademy.edu.project.parser;

import java.util.Collection;

public interface DataParser {
    public void parse(String fileLocation);

    public Collection<WaterBill> findAll();
}
