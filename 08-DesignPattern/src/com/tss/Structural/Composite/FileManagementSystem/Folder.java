package com.tss.Structural.Composite.FileManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemItem {

    private String name;
    private List<FileSystemItem> items = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemItem item) {
        items.add(item);
    }

    @Override
    public void ls(int indent) {
        printIndent(indent);
        System.out.println("+ " + name);

        for (FileSystemItem item : items) {
            item.ls(indent + 1);
        }
    }

    @Override
    public void openAll() {
        for (FileSystemItem item : items) {
            item.openAll();
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemItem item : items) {
            totalSize += item.getSize();
        }
        return totalSize;
    }

    @Override
    public FileSystemItem cd(String name) {
        for (FileSystemItem item : items) {
            if (item.getName().equalsIgnoreCase(name) && item.isFolder()) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isFolder() {
        return true;
    }

    private void printIndent(int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("    ");
        }
    }
}
