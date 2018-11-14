package com.si5.hrpayroll.dto ;



public class ResponseDTO {

    private Object response ;
    private int statusId ;
    private String message ;

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the response
     */
    public Object getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(Object response) {
        this.response = response;
    }

    /**
     * @return the statusId
     */
    public int getStatusId() {
        return statusId;
    }
    /**
     * @param statusId the statusId to set
     */
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return super.toString();
    }


}