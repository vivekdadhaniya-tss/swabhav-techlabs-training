package com.tss.Behavioral.Observer;

public class EmailNotifier implements Notifier {

    private String email;

    public  EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void update(Account account, String message) {
        System.out.println("Sending email to " + email +
                " | Account No: " + account.getAccountNo() +
                " | Holder: " + account.getName() +
                " | Message: " + message);
    }
}
