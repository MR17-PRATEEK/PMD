package com.example.library;

public class Member {

    private String name;
    private String memberId;

    // PMD may flag this hardcoded magic number
    private int MAX_BORROW_LIMIT = 5;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void printBorrowLimit() {
        System.out.println("Borrow Limit: " + MAX_BORROW_LIMIT);
    }
}
