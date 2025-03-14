package ma.nabil.ITLens.service.impl;

import lombok.extern.slf4j.Slf4j;
import ma.nabil.ITLens.dto.SubjectDTO;
import ma.nabil.ITLens.entity.Subject;
import ma.nabil.ITLens.exception.ResourceNotFoundException;
import ma.nabil.ITLens.mapper.SubjectMapper;
import ma.nabil.ITLens.repository.SubjectRepository;
import ma.nabil.ITLens.repository.SurveyEditionRepository;
import ma.nabil.ITLens.service.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class SubjectServiceImpl extends GenericServiceImpl<Subject, SubjectDTO, Integer> implements SubjectService {
    private final SurveyEditionRepository surveyEditionRepository;
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(
            SubjectRepository repository,
            SubjectMapper mapper,
            SurveyEditionRepository surveyEditionRepository) {
        super(repository, mapper);
        this.surveyEditionRepository = surveyEditionRepository;
        this.subjectRepository = repository;
    }

    @Override
    public SubjectDTO create(SubjectDTO dto) {
        validateSurveyEdition(dto.getSurveyEditionId());
        if (dto.getParentId() != null) {
            validateParentSubject(dto.getParentId());
        }
        return super.create(dto);
    }

    @Override
    public List<SubjectDTO> getRootSubjects(Integer surveyEditionId) {
        validateSurveyEdition(surveyEditionId);
        return subjectRepository.findByParentIsNullAndSurveyEditionId(surveyEditionId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubjectDTO> getChildSubjects(Integer parentId) {
        validateParentSubject(parentId);
        return subjectRepository.findByParentId(parentId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDTO addChildSubject(Integer parentId, SubjectDTO childDTO) {
        validateParentSubject(parentId);
        childDTO.setParentId(parentId);
        return create(childDTO);
    }

    @Override
    protected String getEntityName() {
        return "Subject";
    }

    @Override
    protected void setEntityId(Subject entity, Integer id) {
        entity.setId(id);
    }

    private void validateSurveyEdition(Integer surveyEditionId) {
        if (!surveyEditionRepository.existsById(surveyEditionId)) {
            throw new ResourceNotFoundException("SurveyEdition", surveyEditionId);
        }
    }

    private void validateParentSubject(Integer parentId) {
        if (!repository.existsById(parentId)) {
            throw new ResourceNotFoundException("Parent Subject", parentId);
        }
    }
}