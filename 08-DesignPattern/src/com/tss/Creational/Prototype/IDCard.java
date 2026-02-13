package com.tss.Creational.Prototype;

public class IDCard implements Prototype<IDCard> {

    private String companyName;
    private String companyLogo;
    private String securityLevel;
    private String employeeName;

    public IDCard(String companyName, String companyLogo,
                  String securityLevel, String employeeName) {
        this.companyName = companyName;
        this.companyLogo = companyLogo;
        this.securityLevel = securityLevel;
        this.employeeName = employeeName;
    }

//    public IDCard(String employeeName) {
//        this.companyName = Database.getCompanyName();  // DB call
//        this.companyLogo = ApiService.getLogo();       // API call
//        this.securityLevel = SecurityService.generateLevel();
//        this.employeeName = employeeName;
//    }

    // Copy Constructor
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

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    public void showCard() {
        System.out.println("Company: " + companyName +
                ", Logo: " + companyLogo +
                ", Security: " + securityLevel +
                ", Employee: " + employeeName);
    }
}
