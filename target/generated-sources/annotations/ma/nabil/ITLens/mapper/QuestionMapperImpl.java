package ma.nabil.ITLens.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ma.nabil.ITLens.dto.AnswerDTO;
import ma.nabil.ITLens.dto.QuestionDTO;
import ma.nabil.ITLens.entity.Answer;
import ma.nabil.ITLens.entity.Question;
import ma.nabil.ITLens.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-20T19:50:13+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public QuestionDTO toDto(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionDTO questionDTO = new QuestionDTO();

        questionDTO.setSubjectId( questionSubjectId( question ) );
        questionDTO.setAnswers( answerListToAnswerDTOList( question.getAnswers() ) );
        questionDTO.setId( question.getId() );
        questionDTO.setText( question.getText() );
        questionDTO.setType( question.getType() );
        questionDTO.setAnswerCount( question.getAnswerCount() );

        return questionDTO;
    }

    @Override
    public Question toEntity(QuestionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Question question = new Question();

        question.setSubject( questionDTOToSubject( dto ) );
        question.setAnswers( answerDTOListToAnswerList( dto.getAnswers() ) );
        question.setId( dto.getId() );
        question.setText( dto.getText() );
        question.setType( dto.getType() );
        question.setAnswerCount( dto.getAnswerCount() );

        return question;
    }

    private Integer questionSubjectId(Question question) {
        if ( question == null ) {
            return null;
        }
        Subject subject = question.getSubject();
        if ( subject == null ) {
            return null;
        }
        Integer id = subject.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<AnswerDTO> answerListToAnswerDTOList(List<Answer> list) {
        if ( list == null ) {
            return null;
        }

        List<AnswerDTO> list1 = new ArrayList<AnswerDTO>( list.size() );
        for ( Answer answer : list ) {
            list1.add( answerMapper.toDto( answer ) );
        }

        return list1;
    }

    protected Subject questionDTOToSubject(QuestionDTO questionDTO) {
        if ( questionDTO == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setId( questionDTO.getSubjectId() );

        return subject;
    }

    protected List<Answer> answerDTOListToAnswerList(List<AnswerDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Answer> list1 = new ArrayList<Answer>( list.size() );
        for ( AnswerDTO answerDTO : list ) {
            list1.add( answerMapper.toEntity( answerDTO ) );
        }

        return list1;
    }
}
