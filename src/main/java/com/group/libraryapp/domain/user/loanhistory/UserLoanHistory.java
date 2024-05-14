package com.group.libraryapp.domain.user.loanhistory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserLoanHistory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id = null;

  private long userId;
  private String bookName;
  private boolean isReturn;

  public Long getId() {
    return id;
  }

  public long getUserId() {
    return userId;
  }

  public String getBookName() {
    return bookName;
  }

  public boolean isReturn() {
    return isReturn;
  }

  public UserLoanHistory(long userId, String bookName) {
    this.userId = userId;
    this.bookName = bookName;
    this.isReturn = false;
  }

  public void doReturn(){
    this.isReturn = true;
  }

  public UserLoanHistory() {

  }
}
