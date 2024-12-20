package ma.nabil.ITLens.mapper;

import javax.annotation.processing.Generated;
import ma.nabil.ITLens.dto.OwnerDTO;
import ma.nabil.ITLens.entity.Owner;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-20T19:50:13+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class OwnerMapperImpl implements OwnerMapper {

    @Override
    public OwnerDTO toDto(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerDTO ownerDTO = new OwnerDTO();

        ownerDTO.setId( owner.getId() );
        ownerDTO.setName( owner.getName() );

        return ownerDTO;
    }

    @Override
    public Owner toEntity(OwnerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Owner owner = new Owner();

        owner.setId( dto.getId() );
        owner.setName( dto.getName() );

        return owner;
    }
}
