import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MessageResponseDTO, Room } from '../models/room';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private baseUrl = 'http://localhost:8081/api/v1/rooms';

  constructor(private http: HttpClient) { }

  createRoom(room: Room) : Observable<Room> {
    return this.http.post<Room>(`${this.baseUrl}`, room);
  }

  getRoomList(): Observable<Room[]>{
    return this.http.get<Room[]>(`${this.baseUrl}`)
  }

  getRoom(id: number) : Observable <MessageResponseDTO> {
    return this.http.get<MessageResponseDTO>(`${this.baseUrl}/${id}`);
  }

  updateRoom(id: number, value: Room) : Observable<MessageResponseDTO> {
    return this.http.put<MessageResponseDTO>(`${this.baseUrl}/${id}`, value);
  }

  deleteRoom(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

}
