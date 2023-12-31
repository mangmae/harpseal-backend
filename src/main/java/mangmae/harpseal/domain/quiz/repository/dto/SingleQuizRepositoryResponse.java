package mangmae.harpseal.domain.quiz.repository.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SingleQuizRepositoryResponse {
    private Long id;
    private String title;
    private String description;
    private String thumbnailPath;
}
