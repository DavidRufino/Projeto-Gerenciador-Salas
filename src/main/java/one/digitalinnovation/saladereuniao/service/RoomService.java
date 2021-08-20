package one.digitalinnovation.saladereuniao.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.saladereuniao.dto.request.RoomDTO;
import one.digitalinnovation.saladereuniao.dto.response.MessageResponseDTO;
import one.digitalinnovation.saladereuniao.entity.Room;
import one.digitalinnovation.saladereuniao.exception.RoomNotFoundException;
import one.digitalinnovation.saladereuniao.mapper.RoomMapper;
import one.digitalinnovation.saladereuniao.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomService {

    private RoomRepository roomRepository;

    private final RoomMapper roomMapper = RoomMapper.INSTANCE;

    //  Criar uma Room
    public MessageResponseDTO createRoom(RoomDTO roomDTO) {
        System.out.println("roomDTO getDate: " + roomDTO.getDate());
        var roomToSave = roomMapper.toModel(roomDTO); // Converter DTO para Entity
        System.out.println("roomToSave getDate: " + roomToSave.getDate());
        var savedRoom = roomRepository.save(roomToSave); // Salvar o valor convertido
        return createMessageResponse("Created Room with ID: ", savedRoom);
    }

    //  Obter todas as Rooms
    public List<RoomDTO> getAllRoms() {
        var allRoom = roomRepository.findAll();

        //  Converter a List de Entity para DTO
        return allRoom.stream().map(roomMapper::toDTO).collect(Collectors.toList());
    }

    public MessageResponseDTO getRoomById(Long idRoom) throws RoomNotFoundException {
        Room room = verifyIfExists(idRoom);

        return createMessageResponse("Room with ID: ", room);
    }

    public MessageResponseDTO updateRoomById(Long idRoom, RoomDTO roomDTO) throws RoomNotFoundException {
        verifyIfExists(idRoom);

        var roomToUpdate = roomMapper.toModel(roomDTO); // Converter DTO para Entity
        roomRepository.save(roomToUpdate); // Salvar o valor convertido

        return createMessageResponse("Updated Room with ID: ", roomToUpdate);
    }

    public MessageResponseDTO deleteRoom(Long idRoom) throws RoomNotFoundException {
        var result = verifyIfExists(idRoom);
        roomRepository.deleteById(idRoom);
        return createMessageResponse("Deteled Room with ID: ", result);
    }

    /*  Privaters */

    private Room verifyIfExists(Long id) throws RoomNotFoundException {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(String msg, Room room) {
        return MessageResponseDTO
                .builder()
                .message(msg + room.getId())
                .object(room)
                .build();
    }
}
