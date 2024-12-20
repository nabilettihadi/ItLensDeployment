package ma.nabil.ITLens.mapper;

import javax.annotation.processing.Generated;
import ma.nabil.ITLens.dto.AnswerDTO;
import ma.nabil.ITLens.entity.Answer;
import ma.nabil.ITLens.entity.Question;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-20T16:41:16+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public AnswerDTO toDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerDTO answerDTO = new AnswerDTO();

        answerDTO.setQuestionId( answerQuestionId( answer ) );
        answerDTO.setId( answer.getId() );
        answerDTO.setPercentage( answer.getPercentage() );
        answerDTO.setSelectionCount( answer.getSelectionCount() );
        answerDTO.setText( answer.getText() );

        return answerDTO;
    }

    @Override
    public Answer toEntity(AnswerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setQuestion( answerDTOToQuestion( dto ) );
        answer.setId( dto.getId() );
        answer.setPercentage( dto.getPercentage() );
        answer.setSelectionCount( dto.getSelectionCount() );
        answer.setText( dto.getText() );

        return answer;
    }

    private Integer answerQuestionId(Answer answer) {
        if ( answer == null ) {
            return null;
        }
        Question question = answer.getQuestion();
        if ( question == null ) {
            return null;
        }
        Integer id = question.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Question answerDTOToQuestion(AnswerDTO answerDTO) {
        if ( answerDTO == null ) {
            return null;
        }

        Question question = new Question();

        question.setId( answerDTO.getQuestionId() );

        return question;
    }
}
