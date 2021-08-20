import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Room } from 'src/app/shared/models/room';
import { RoomService } from 'src/app/shared/services/room.service';

@Component({
  selector: 'app-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.scss']
})
export class CreateRoomComponent implements OnInit {

  room: Room = {} as Room;;
  submitted: Boolean = false;

  constructor(private roomService: RoomService, private router: Router) { }

  ngOnInit() {
  }

  newRoom(): void {
    this.submitted = false;
    this.room = {} as Room;;
  }

  save() {
    this.roomService.createRoom(this.room)
      .subscribe(
        data => console.log(data),
        error => console.log(error)
      );
    this.room = {} as Room;;
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/rooms']);
  }
}
