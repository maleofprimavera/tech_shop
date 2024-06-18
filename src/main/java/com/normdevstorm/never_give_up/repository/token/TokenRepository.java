package com.normdevstorm.never_give_up.repository.token;

import com.normdevstorm.never_give_up.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<VerificationToken, java.lang.Long> {

    @Query("select v  from VerificationToken v where v.token = :token")
    VerificationToken findFirstByTokenContains(@NonNull @Param("token") String token);

    @Query(value = "select (count(v) > 0) from VerificationToken v where v.token = :token")
    boolean existsByToken(@NonNull @Param("token") String token);

/// TODO: TO REVERT CODE LATER ON IN ORDER THAT WE USE BOOLEAN AS A METHOD OF EXISTENCE CHECKING
//    @Query("select (count(v) > 0) from verification_token v where v.token = :token")
//    boolean existsByTokenNotNull(@NonNull @Param("token") String token);
}
