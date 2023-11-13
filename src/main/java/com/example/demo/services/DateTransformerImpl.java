package com.example.demo.services;

import java.util.Date;

public class DateTransformerImpl implements DateTransformer{
    @Override
    public Date transform(Date date) {
        var now = new Date();
        return date.after(now) ? now : date;
    }
}
