package com.tss.Creational.Prototype.shallowcopy;

public class IDCardShallow implements Prototype<IDCardShallow> {

    private String companyName;
    private String companyLogo;
    private String employeeName;
    private SecurityPolicy securityPolicy; // mutable object

    public IDCardShallow(String companyName, String companyLogo,
                         SecurityPolicy securityPolicy, String employeeName) {
        this.companyName = companyName;
        this.companyLogo = companyLogo;
        this.securityPolicy = securityPolicy;
        this.employeeName = employeeName;
    }

    // Shallow copy constructor
    private IDCardShallow(IDCardShallow card) {
        this.companyName = card.companyName;
        this.companyLogo = card.companyLogo;
        this.employeeName = card.employeeName;
        this.securityPolicy = card.securityPolicy; // same reference
    }

    @Override
    public IDCardShallow clone() {
        return new IDCardShallow(this);
    }

    public void setEmployeeName(String name) {
        this.employeeName = name;
    }

    public void setSecurityLevel(String level) {
        this.securityPolicy.level = level;
    }

    public void showCard() {
        System.out.println("Company: " + companyName +
                ", Logo: " + companyLogo +
                ", Security: " + securityPolicy +
                ", Employee: " + employeeName);
    }
}
