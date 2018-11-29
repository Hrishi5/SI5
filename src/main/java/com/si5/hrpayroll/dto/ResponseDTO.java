package com.si5.hrpayroll.dto ;



public class ResponseDTO {

    private Object response ;
    private int statusId ;
    private String message ;

    public ResponseDTO() {
        this.statusId = 0 ;
    }
    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public Object getResponse() {
        return response;
    }


    public void setResponse(Object response) {
        this.response = response;
    }


    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return super.toString();
    }


}