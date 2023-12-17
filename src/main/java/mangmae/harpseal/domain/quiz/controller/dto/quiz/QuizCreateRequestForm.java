package mangmae.harpseal.domain.quiz.controller.dto.quiz;


import lombok.*;
import mangmae.harpseal.domain.quiz.service.dto.quiz.QuizCreateServiceDto;

@Data
public class QuizCreateRequestForm {

    private String title; //퀴즈 이름
    private String password; //비밀번호
    private String description;

    public QuizCreateServiceDto toServiceDto() {
        return QuizCreateServiceDto.builder()
            .title(title)
            .password(password)
            .description(description)
            .build();
    }

}