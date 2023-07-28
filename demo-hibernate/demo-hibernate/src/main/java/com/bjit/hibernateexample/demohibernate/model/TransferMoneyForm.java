package com.bjit.hibernateexample.demohibernate.model;

public class TransferMoneyForm {
    private Long senderId;
    private Long receiverId;
    private Long amount;

    public TransferMoneyForm() {
    }

    public TransferMoneyForm(Long senderId, Long receiverId, Long amount) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
