package ma.nabil.ITLens.mapper;

import javax.annotation.processing.Generated;
import ma.nabil.ITLens.dto.AnswerDTO;
import ma.nabil.ITLens.entity.Answer;
import ma.nabil.ITLens.entity.Question;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-26T15:08:33+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
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
        answerDTO.setText( answer.getText() );
        answerDTO.setSelectionCount( answer.getSelectionCount() );
        answerDTO.setPercentage( answer.getPercentage() );

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
        answer.setText( dto.getText() );
        answer.setSelectionCount( dto.getSelectionCount() );
        answer.setPercentage( dto.getPercentage() );

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
