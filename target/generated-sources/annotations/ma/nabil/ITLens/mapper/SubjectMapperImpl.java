package ma.nabil.ITLens.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ma.nabil.ITLens.dto.QuestionDTO;
import ma.nabil.ITLens.dto.SubjectDTO;
import ma.nabil.ITLens.entity.Question;
import ma.nabil.ITLens.entity.Subject;
import ma.nabil.ITLens.entity.SurveyEdition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-20T21:53:56+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class SubjectMapperImpl implements SubjectMapper {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public SubjectDTO toDto(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectDTO subjectDTO = new SubjectDTO();

        subjectDTO.setParentId( subjectParentId( subject ) );
        subjectDTO.setSurveyEditionId( subjectSurveyEditionId( subject ) );
        subjectDTO.setQuestions( questionListToQuestionDTOList( subject.getQuestions() ) );
        subjectDTO.setChildren( subjectListToSubjectDTOList( subject.getChildren() ) );
        subjectDTO.setId( subject.getId() );
        subjectDTO.setTitle( subject.getTitle() );

        return subjectDTO;
    }

    @Override
    public Subject toEntity(SubjectDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setParent( subjectDTOToSubject( dto ) );
        subject.setSurveyEdition( subjectDTOToSurveyEdition( dto ) );
        subject.setQuestions( questionDTOListToQuestionList( dto.getQuestions() ) );
        subject.setChildren( subjectDTOListToSubjectList( dto.getChildren() ) );
        subject.setId( dto.getId() );
        subject.setTitle( dto.getTitle() );

        return subject;
    }

    private Integer subjectParentId(Subject subject) {
        if ( subject == null ) {
            return null;
        }
        Subject parent = subject.getParent();
        if ( parent == null ) {
            return null;
        }
        Integer id = parent.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer subjectSurveyEditionId(Subject subject) {
        if ( subject == null ) {
            return null;
        }
        SurveyEdition surveyEdition = subject.getSurveyEdition();
        if ( surveyEdition == null ) {
            return null;
        }
        Integer id = surveyEdition.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<QuestionDTO> questionListToQuestionDTOList(List<Question> list) {
        if ( list == null ) {
            return null;
        }

        List<QuestionDTO> list1 = new ArrayList<QuestionDTO>( list.size() );
        for ( Question question : list ) {
            list1.add( questionMapper.toDto( question ) );
        }

        return list1;
    }

    protected List<SubjectDTO> subjectListToSubjectDTOList(List<Subject> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectDTO> list1 = new ArrayList<SubjectDTO>( list.size() );
        for ( Subject subject : list ) {
            list1.add( toDto( subject ) );
        }

        return list1;
    }

    protected Subject subjectDTOToSubject(SubjectDTO subjectDTO) {
        if ( subjectDTO == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setId( subjectDTO.getParentId() );

        return subject;
    }

    protected SurveyEdition subjectDTOToSurveyEdition(SubjectDTO subjectDTO) {
        if ( subjectDTO == null ) {
            return null;
        }

        SurveyEdition surveyEdition = new SurveyEdition();

        surveyEdition.setId( subjectDTO.getSurveyEditionId() );

        return surveyEdition;
    }

    protected List<Question> questionDTOListToQuestionList(List<QuestionDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Question> list1 = new ArrayList<Question>( list.size() );
        for ( QuestionDTO questionDTO : list ) {
            list1.add( questionMapper.toEntity( questionDTO ) );
        }

        return list1;
    }

    protected List<Subject> subjectDTOListToSubjectList(List<SubjectDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Subject> list1 = new ArrayList<Subject>( list.size() );
        for ( SubjectDTO subjectDTO : list ) {
            list1.add( toEntity( subjectDTO ) );
        }

        return list1;
    }
}
