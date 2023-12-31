package mangmae.harpseal.domain.quiz.repository;

import mangmae.harpseal.global.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long>, QuizQueryRepository {
    public Quiz findByTitle(String title);
}
