package one.digitalinnovation.saladereuniao.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.saladereuniao.dto.request.RoomDTO;
import one.digitalinnovation.saladereuniao.dto.response.MessageResponseDTO;
import one.digitalinnovation.saladereuniao.exception.RoomNotFoundException;
import one.digitalinnovation.saladereuniao.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomController {

    private RoomService roomService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createRoom(@RequestBody @Valid RoomDTO roomDTO) {
        return roomService.createRoom(roomDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<RoomDTO> getAllRooms() {
        return roomService.getAllRoms(); //  Obter todas as Rooms
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{idRoom}")
    public MessageResponseDTO getRoomById(@PathVariable Long idRoom) throws RoomNotFoundException {
        return roomService.getRoomById(idRoom);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{idRoom}")
    public MessageResponseDTO updateRoomById(@PathVariable Long idRoom, @RequestBody @Valid RoomDTO roomDTO) throws RoomNotFoundException {
        return roomService.updateRoomById(idRoom, roomDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{idRoom}")
    public MessageResponseDTO deleteRoom(@PathVariable Long idRoom) throws RoomNotFoundException {
        return roomService.deleteRoom(idRoom);
    }
}
