package ma.nabil.ITLens.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ma.nabil.ITLens.dto.SurveyDTO;
import ma.nabil.ITLens.dto.SurveyEditionDTO;
import ma.nabil.ITLens.entity.Survey;
import ma.nabil.ITLens.entity.SurveyEdition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-20T21:53:56+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class SurveyMapperImpl implements SurveyMapper {

    @Autowired
    private OwnerMapper ownerMapper;
    @Autowired
    private SurveyEditionMapper surveyEditionMapper;

    @Override
    public SurveyDTO toDto(Survey survey) {
        if ( survey == null ) {
            return null;
        }

        SurveyDTO surveyDTO = new SurveyDTO();

        surveyDTO.setOwner( ownerMapper.toDto( survey.getOwner() ) );
        surveyDTO.setEditions( surveyEditionListToSurveyEditionDTOList( survey.getEditions() ) );
        surveyDTO.setId( survey.getId() );
        surveyDTO.setTitle( survey.getTitle() );
        surveyDTO.setDescription( survey.getDescription() );

        return surveyDTO;
    }

    @Override
    public Survey toEntity(SurveyDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Survey survey = new Survey();

        survey.setOwner( ownerMapper.toEntity( dto.getOwner() ) );
        survey.setEditions( surveyEditionDTOListToSurveyEditionList( dto.getEditions() ) );
        survey.setId( dto.getId() );
        survey.setTitle( dto.getTitle() );
        survey.setDescription( dto.getDescription() );

        return survey;
    }

    protected List<SurveyEditionDTO> surveyEditionListToSurveyEditionDTOList(List<SurveyEdition> list) {
        if ( list == null ) {
            return null;
        }

        List<SurveyEditionDTO> list1 = new ArrayList<SurveyEditionDTO>( list.size() );
        for ( SurveyEdition surveyEdition : list ) {
            list1.add( surveyEditionMapper.toDto( surveyEdition ) );
        }

        return list1;
    }

    protected List<SurveyEdition> surveyEditionDTOListToSurveyEditionList(List<SurveyEditionDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<SurveyEdition> list1 = new ArrayList<SurveyEdition>( list.size() );
        for ( SurveyEditionDTO surveyEditionDTO : list ) {
            list1.add( surveyEditionMapper.toEntity( surveyEditionDTO ) );
        }

        return list1;
    }
}
