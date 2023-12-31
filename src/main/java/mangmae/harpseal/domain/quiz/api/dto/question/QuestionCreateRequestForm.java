package mangmae.harpseal.domain.quiz.api.dto.question;

import lombok.*;
import mangmae.harpseal.domain.choice.dto.ChoiceCreateDto;
import mangmae.harpseal.domain.choice.dto.ChoiceServiceDto;
import mangmae.harpseal.domain.question.dto.QuestionCreateServiceDto;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class QuestionCreateRequestForm {

    private String content;
    private String password;
    private int number;
    private String type;
    private String answer;
    private String attachmentType;
    private List<ChoiceCreateDto> choices;

//    public QuestionCreateRequestForm(String content, int number, String type, String answer) {
//        this.content = content;
//        this.number = number;
//        this.type = type;
//        this.answer = answer;
//    }

    public QuestionCreateServiceDto toServiceDto() {

        List<ChoiceServiceDto> serviceChoices = choices.stream()
            .map(ChoiceCreateDto::toServiceDto)
            .toList();

        return QuestionCreateServiceDto.builder()
            .content(content)
            .password(password)
            .number(number)
            .type(type)
            .answer(answer)
            .attachmentType(attachmentType)
            .choices(serviceChoices)
            .build();
    }


}
