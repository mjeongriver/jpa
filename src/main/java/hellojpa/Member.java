package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@SequenceGenerator(
        name = "member_seq_generator",
        sequenceName = "member_seq", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 50) //시퀀스 한 번 호출에 증가하는 수
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long id;

    @Column(name = "name", nullable = false) //db에 있는 이름이 name
    private String username;

    private Integer age;

    //ORDINAL은 숫자로 들어가기 때문에 순서가 바뀌면 문제가 생길 수 있음
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Lob //varchar보다 큰 데이터를 넣을 때 사용
    private String description;

    @Transient //db에 저장하지 않음, 메모리에서만 사용하고 싶을 때
    private int temp;

    //기본 생성자
    public Member() {
    }

    //getter, setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

}
