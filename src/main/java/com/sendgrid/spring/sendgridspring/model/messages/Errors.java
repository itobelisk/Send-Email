package com.sendgrid.spring.sendgridspring.model.messages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Errors {
    @SerializedName("errors")
    @Expose
    private List<Error> errors = null;
}
