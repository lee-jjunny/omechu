package omechu.omechubackend.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    /** API 제공자  ex) google, facebook, naver */
    private String provider;

    /** API 제공자의 PK ex) 12321453 */
    private String providerId;

    /** 로그인 ID, PK 아님
     * provider_providerId 형식으로 저장 */
    @Column(nullable = false, unique = true)
    private String username;

    /** 회원 가입 당시 email */
    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    /** 회원 등급 */
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @CreationTimestamp //  시간 자동 입력, LocalDateTime으로 바꿀지 논의 필요.
    private Timestamp createDate;


}
