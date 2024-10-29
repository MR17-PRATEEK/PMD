package com.example.library;

public class Main {

    public static void main(String[] args) {
        Library library = new Library("Central Library");
        Member member = new Member("John Doe", "1234");

        library.addMember(member);
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));

        library.printInventory();
        library.printMemberDetails("1234");
    }
}
