import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageResponseDTO, Room } from 'src/app/shared/models/room';
import { RoomService } from 'src/app/shared/services/room.service';
import { DatePipe } from '@angular/common'

@Component({
  selector: 'app-update-room',
  templateUrl: './update-room.component.html',
  styleUrls: ['./update-room.component.scss']
})
export class UpdateRoomComponent implements OnInit {

  id: number = 0;
  room: Room = {} as Room;

  submitted: Boolean = false;

  constructor(private route: ActivatedRoute, private router: Router, private roomService: RoomService, private datePipe: DatePipe) { }

  ngOnInit() {
    this.room = {} as Room;
    this.id = this.route.snapshot.params['id'];
    this.roomService.getRoom(this.id).subscribe(data => {
      console.log(data);
      this.room = data.object;

      //  Converter a data
      var date = this.datePipe.transform(this.room.date, 'dd/MM/yyyy') ?? this.room.date;
      console.log('[DATE] : ' + date);
      this.room.date = date;

    }, error => console.log("Error: " + error)
    );
  }

  updateRoom() {
    this.roomService.updateRoom(this.id, this.room)
    .subscribe(data => console.log('[UpdateRoomComponent] ' +data.object), error => console.log("Error: " + error));
    this.room = {} as Room;
    this.gotoList();
  }

  onSubmit() {
    this.updateRoom();
  }

  gotoList() {
    this.router.navigate(['/rooms']);
  }

}
