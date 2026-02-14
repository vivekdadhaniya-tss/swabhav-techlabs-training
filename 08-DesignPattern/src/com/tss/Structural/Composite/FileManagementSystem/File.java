package com.tss.Structural.Composite.FileManagementSystem;

public class File implements FileSystemItem{

    private String name;
    private int size;

    public File(String name, int size){
        this.name = name;
        this.size = size;
    }

    @Override
    public void ls(int indent) {
        printIndent(indent);
        System.out.println(name + " (" + size + " KB)");
    }

    @Override
    public void openAll() {
        System.out.println("Opening file: " + name);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public FileSystemItem cd(String name) {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isFolder() {
        return false;
    }

    private void printIndent(int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("    ");
        }
    }
}
