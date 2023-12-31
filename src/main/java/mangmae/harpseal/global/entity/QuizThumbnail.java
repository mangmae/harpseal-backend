package mangmae.harpseal.global.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class QuizThumbnail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    private String filePath;

    public QuizThumbnail(String filePath) {
        this.filePath = filePath;
    }

    public void changeQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

}
