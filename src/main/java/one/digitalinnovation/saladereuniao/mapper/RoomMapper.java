package one.digitalinnovation.saladereuniao.mapper;

import one.digitalinnovation.saladereuniao.dto.request.RoomDTO;
import one.digitalinnovation.saladereuniao.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(target = "date", source = "date", dateFormat = "dd/MM/yyyy")
    Room toModel(RoomDTO roomDTO); //  Room DTO para Room Entity

    @Mapping(target = "date", source = "date", dateFormat = "dd/MM/yyyy")
    RoomDTO toDTO(Room room); //  Room Entity para Room DTO
}
