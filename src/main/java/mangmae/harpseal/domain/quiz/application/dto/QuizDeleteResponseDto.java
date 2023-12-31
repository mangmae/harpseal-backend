package mangmae.harpseal.domain.quiz.application.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mangmae.harpseal.domain.quiz.repository.dto.QuizDeleteRepositoryResponse;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuizDeleteResponseDto {

    private Long id;
    private String message;

    public static QuizDeleteResponseDto fromRepositoryDto(QuizDeleteRepositoryResponse dto) {
        return new QuizDeleteResponseDto(dto.getId(), "퀴즈 삭제에 성공하였습니다.");
    }
}
