package com.tss.Creational.Prototype;

public class IDCard implements Prototype<IDCard> {

    private String companyName;
    private String companyLogo;
    private String securityLevel;
    private String employeeName;

    // Normal Constructor (Used for creating template)
    public IDCard(String companyName, String companyLogo,
                  String securityLevel, String employeeName) {
        this.companyName = companyName;
        this.companyLogo = companyLogo;
        this.securityLevel = securityLevel;
        this.employeeName = employeeName;
    }

    // Copy Constructor (Used for cloning)
    private IDCard(IDCard card) {
        this.companyName = card.companyName;
        this.companyLogo = card.companyLogo;
        this.securityLevel = card.securityLevel;
        this.employeeName = card.employeeName;
    }

    // Clone method
    @Override
    public IDCard clone() {
        return new IDCard(this);
    }

    // Setter to modify clone
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    // Display method
    public void showCard() {
        System.out.println("Company: " + companyName +
                ", Logo: " + companyLogo +
                ", Security: " + securityLevel +
                ", Employee: " + employeeName);
    }
}
