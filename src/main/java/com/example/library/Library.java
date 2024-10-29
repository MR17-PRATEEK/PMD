package com.example.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private String libraryName;
    private List<Book> books;
    private List<Member> members;

    // PMD may flag these unused variables
    private int unusedNumber = 10;
    private String unusedString = "Unused";

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void printInventory() {
        System.out.println("Library Inventory:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

    // PMD may flag unused method
    public void unusedMethod() {
        System.out.println("This is an unused method.");
    }

    public void printMemberDetails(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                System.out.println("Member: " + member.getName());
                return;
            }
        }
    }
}
