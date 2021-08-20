import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MessageResponseDTO, Room } from 'src/app/shared/models/room';
import { RoomService } from 'src/app/shared/services/room.service';

@Component({
  selector: 'app-room-details',
  templateUrl: './room-details.component.html',
  styleUrls: ['./room-details.component.scss']
})
export class RoomDetailsComponent implements OnInit {

  id: number = 0;
  room: Room = {} as Room;
  
  constructor(private route: ActivatedRoute, private router: Router, private roomService: RoomService) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];

    this.roomService.getRoom(this.id)
    .subscribe({
      next: data => {
          this.room = data.object;
          console.log('[RoomDetailsComponent]', data);
      },
      error: error => {
          console.error('There was an error!', error);
      }
  })
  }

  list() {
    this.router.navigate(['rooms']);
  }

}
