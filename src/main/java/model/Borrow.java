package model;

import java.sql.Date;

public class Borrow {

    private int borrowId;
    private int memberId;
    private String memberName;
    private int bookId;
    private String bookName;
    private Date borrowDate;
    private Date returnDate;

    public Borrow(){}

    public Borrow(int borrowId, int memberId, int bookId, Date borrowDate, Date returnDate){
        this.borrowId = borrowId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Borrow(int memberId, int bookId, Date borrowDate, Date returnDate){
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Borrow(int memberId, int bookId){
        this.memberId = memberId;
        this.bookId = bookId;
    }

    public Borrow(int borrowId, int memberId ,String memberName, int bookId,String bookName, Date borrowDate, Date returnDate){
        this.borrowId = borrowId;
        this.memberId = memberId;
        this.memberName = memberName;
        this.bookId = bookId;
        this.bookName = bookName;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowId=" + borrowId +
                ", memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }

}
