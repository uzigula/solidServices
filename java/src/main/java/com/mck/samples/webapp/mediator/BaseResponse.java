package com.mck.samples.webapp.mediator;

import lombok.Getter;

@Getter
public final class BaseResponse<TContent>{
    protected final boolean success;
    protected final String message;
    protected TContent content;

    public BaseResponse(TContent content){
        this.success = true;
        this.message = "Great!!";
        this.content = content;
    }
    public BaseResponse(TContent content, String message){
        this.message = message;
        this.success = false;
        this.content = content;

    }

    public BaseResponse(Exception e){
        this.message = e.getMessage();
        this.success = false;
        this.content = null;

    }
}
