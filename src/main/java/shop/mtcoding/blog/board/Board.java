package shop.mtcoding.blog.board;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.user.User;

import java.sql.Timestamp;

@NoArgsConstructor // 빈 생성자 만들어 줘야 함
@Data
@Table(name = "board_tb")
@Entity
public class Board { // Entity 무조건 기본 생성자가 있어야 오류 나지 않음 @NoArgsConstructor
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String username;

    // @JoinColumn(name = "user_id") // 카멜 표기법 써서 DB에 직접 하고 싶으면 userId
    @ManyToOne // user_id 유저명의 id(유저의 pk) 필드로 만들어 줄께
    private User user; // 유저 객체를 넣음

    @CreationTimestamp // pc -> db (날짜주입)
    private Timestamp createdAt;

    // 생성자 빌더 패턴으로 받기
    @Builder
    public Board(Integer id, String title, String content, String username, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;
        this.createdAt = createdAt;
    }
}
