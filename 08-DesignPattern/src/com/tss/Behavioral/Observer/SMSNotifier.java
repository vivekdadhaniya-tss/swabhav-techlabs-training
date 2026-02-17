package com.tss.Behavioral.Observer;

public class SMSNotifier implements Notifier {

    private String phoneNumber;

    public SMSNotifier(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(Account account, String message) {
        System.out.println("Sending SMS to " + phoneNumber +
                " | Account No: " + account.getAccountNo() +
                " | Holder: " + account.getName() +
                " | Message: " + message);
    }
}
