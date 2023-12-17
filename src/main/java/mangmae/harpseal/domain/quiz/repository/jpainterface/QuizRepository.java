package mangmae.harpseal.domain.quiz.repository.jpainterface;

import mangmae.harpseal.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long>, QuizQueryRepository {
    public Quiz findByTitle(String title);
}