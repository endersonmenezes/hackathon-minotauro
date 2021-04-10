import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Doors, Room } from 'src/app/model/room';

@Injectable({ providedIn: 'root', deps: [HttpClient] })
export class RoomService {
  constructor(private http: HttpClient) {}

  initGame(name: string, nivel: number) {
    const body = { nomeJogador: name, dificuldade: nivel };
    return this.http
      .post<Room>('http://localhost:8080/api/partida', body)
      .toPromise();
  }

  getFirstRoom(roomId: number) {
    return this.http
      .get<Doors>(`http://localhost:8080/api/init/${roomId}`)
      .toPromise();
  }

  clickDoor(roomId: number) {}
}
