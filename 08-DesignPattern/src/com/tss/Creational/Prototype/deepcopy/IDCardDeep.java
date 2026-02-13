package com.tss.Creational.Prototype.deepcopy;

public class IDCardDeep implements Prototype<IDCardDeep> {

    private String companyName;
    private String companyLogo;
    private String employeeName;
    private SecurityPolicy securityPolicy; // mutable object

    public IDCardDeep(String companyName, String companyLogo,
                      SecurityPolicy securityPolicy, String employeeName) {
        this.companyName = companyName;
        this.companyLogo = companyLogo;
        this.securityPolicy = securityPolicy;
        this.employeeName = employeeName;
    }

    // Deep copy constructor
    private IDCardDeep(IDCardDeep card) {
        this.companyName = card.companyName;
        this.companyLogo = card.companyLogo;
        this.employeeName = card.employeeName;
        this.securityPolicy = new SecurityPolicy(card.securityPolicy); // NEW object
    }

    @Override
    public IDCardDeep clone() {
        return new IDCardDeep(this);
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
