package com.tss.Structural.Proxy.ProtectionProxy;

public class DocumentProxy implements Document{

    private RealDocument realDocument;
    private String userRole;

    public DocumentProxy(String fileName, String userRole){
        this.realDocument = new RealDocument(fileName);
        this.userRole = userRole;
    }

    @Override
    public void view() {
        realDocument.view();
    }

    @Override
    public void delete() {
        if(userRole.equalsIgnoreCase("manager")){
            realDocument.delete();
        } else {
            System.out.println("Access Denied! Only MANAGER can delete documents.");
        }
    }
}
