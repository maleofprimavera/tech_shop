package com.normdevstorm.never_give_up.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.query.sqm.TemporalUnit;

import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.Calendar;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "verification_token")
public class VerificationToken {

    private static final int EXPIRATION_TIME = 10;

    @Id
    @Column(name = "token_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "token")
    private String token;

    @Column(name = "expiration_time")
    private java.util.Date expirationTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false,foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN"))
    private User user;

    public VerificationToken(String token, User user) {
        this.token = token;
        this.expirationTime = calculateExpirationTime(EXPIRATION_TIME);
        this.user = user;
    }

    public VerificationToken(String token){
        this.token= token;
        this.expirationTime= calculateExpirationTime(EXPIRATION_TIME);
    }



    Date calculateExpirationTime(int expirationDuration)
    {
        ///TODO: TO CONVERT TO LOCALDATETIME LATER ON
        // use calendar for adding interval while using Date as a data type to saave in db
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, expirationDuration);
        // double getTime to convert Epoch -> 1970
        return new Date (calendar.getTime().getTime());
    }
}
