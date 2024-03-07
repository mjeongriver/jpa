package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MBR")
public class Member {

    @Id
    private Long id;

    //DDL을 자동 생성할 때만 사용 되고 실행 로직에는 영향을 주지 않는다.
    @Column(unique = true, length = 10)
    private String name;
    private int age;

    //기본 생성자
    public Member() {
    }
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
