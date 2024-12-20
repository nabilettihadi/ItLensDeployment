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
    date = "2024-12-20T16:41:16+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
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
        surveyDTO.setDescription( survey.getDescription() );
        surveyDTO.setId( survey.getId() );
        surveyDTO.setTitle( survey.getTitle() );

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
        survey.setDescription( dto.getDescription() );
        survey.setId( dto.getId() );
        survey.setTitle( dto.getTitle() );

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
