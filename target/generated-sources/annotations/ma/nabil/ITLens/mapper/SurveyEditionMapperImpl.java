package ma.nabil.ITLens.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ma.nabil.ITLens.dto.SubjectDTO;
import ma.nabil.ITLens.dto.SurveyEditionDTO;
import ma.nabil.ITLens.entity.Subject;
import ma.nabil.ITLens.entity.Survey;
import ma.nabil.ITLens.entity.SurveyEdition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-26T15:08:33+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class SurveyEditionMapperImpl implements SurveyEditionMapper {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public SurveyEditionDTO toDto(SurveyEdition surveyEdition) {
        if ( surveyEdition == null ) {
            return null;
        }

        SurveyEditionDTO surveyEditionDTO = new SurveyEditionDTO();

        surveyEditionDTO.setSurveyId( surveyEditionSurveyId( surveyEdition ) );
        surveyEditionDTO.setSubjects( subjectListToSubjectDTOList( surveyEdition.getSubjects() ) );
        surveyEditionDTO.setId( surveyEdition.getId() );
        surveyEditionDTO.setCreationDate( surveyEdition.getCreationDate() );
        surveyEditionDTO.setStartDate( surveyEdition.getStartDate() );
        surveyEditionDTO.setYear( surveyEdition.getYear() );

        return surveyEditionDTO;
    }

    @Override
    public SurveyEdition toEntity(SurveyEditionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SurveyEdition surveyEdition = new SurveyEdition();

        surveyEdition.setSurvey( surveyEditionDTOToSurvey( dto ) );
        surveyEdition.setSubjects( subjectDTOListToSubjectList( dto.getSubjects() ) );
        surveyEdition.setId( dto.getId() );
        surveyEdition.setCreationDate( dto.getCreationDate() );
        surveyEdition.setStartDate( dto.getStartDate() );
        surveyEdition.setYear( dto.getYear() );

        return surveyEdition;
    }

    private Integer surveyEditionSurveyId(SurveyEdition surveyEdition) {
        if ( surveyEdition == null ) {
            return null;
        }
        Survey survey = surveyEdition.getSurvey();
        if ( survey == null ) {
            return null;
        }
        Integer id = survey.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<SubjectDTO> subjectListToSubjectDTOList(List<Subject> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectDTO> list1 = new ArrayList<SubjectDTO>( list.size() );
        for ( Subject subject : list ) {
            list1.add( subjectMapper.toDto( subject ) );
        }

        return list1;
    }

    protected Survey surveyEditionDTOToSurvey(SurveyEditionDTO surveyEditionDTO) {
        if ( surveyEditionDTO == null ) {
            return null;
        }

        Survey survey = new Survey();

        survey.setId( surveyEditionDTO.getSurveyId() );

        return survey;
    }

    protected List<Subject> subjectDTOListToSubjectList(List<SubjectDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Subject> list1 = new ArrayList<Subject>( list.size() );
        for ( SubjectDTO subjectDTO : list ) {
            list1.add( subjectMapper.toEntity( subjectDTO ) );
        }

        return list1;
    }
}
