package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory,Long> {

  boolean existsByBookNameAndIsReturn(String name,boolean isReturn);

  Optional<UserLoanHistory> findByUserIdAndBookName(long userId, String bookName);
}
