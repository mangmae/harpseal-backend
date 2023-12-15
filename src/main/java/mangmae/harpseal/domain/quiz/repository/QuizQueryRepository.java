package mangmae.harpseal.domain.quiz.repository;

import mangmae.harpseal.domain.quiz.repository.dto.QuizDeleteRepositoryResponse;
import mangmae.harpseal.domain.quiz.repository.dto.QuizSearchRepositoryCond;
import mangmae.harpseal.domain.quiz.repository.dto.QuizSearchRepositoryDto;
import mangmae.harpseal.domain.quiz.repository.dto.SingleQuizRepositoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuizQueryRepository {

    public Page<QuizSearchRepositoryDto> findPlayTimeDesc(QuizSearchRepositoryCond condition, Pageable pageable);

    public Page<QuizSearchRepositoryDto> findPlayTimeAsc(QuizSearchRepositoryCond condition, Pageable pageable);

    public Page<QuizSearchRepositoryDto> findRecentDesc(QuizSearchRepositoryCond condition, Pageable pageable);

    public Page<QuizSearchRepositoryDto> findRecentAsc(QuizSearchRepositoryCond condition, Pageable pageable);

    public SingleQuizRepositoryResponse findSingleQuizById(Long quizId);

    public QuizDeleteRepositoryResponse deleteQuizById(Long quizId);

    public String findPasswordById(Long quizId);

}
