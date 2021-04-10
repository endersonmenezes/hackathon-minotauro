import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Doors, Room } from 'src/app/model/room';

@Injectable({ providedIn: 'root', deps: [HttpClient] })
export class RoomService {
  constructor(private http: HttpClient) {}

  initGame(name: string, nivel: number) {
    const body = { nomeJogador: name, dificuldade: nivel };
    return this.http
      .post<Room>('http://04da12d25650.ngrok.io/api/partida', body)
      .toPromise();
  }

  getPosicaoAtual(roomId: number) {
    return this.http
      .get<Doors>(`http://04da12d25650.ngrok.io/api/partida/${roomId}`)
      .toPromise();
  }

  mudaPosicao(roomId: number, escolha: number) {
    return this.http
      .get<Doors>(`http://04da12d25650.ngrok.io/api/partida/${roomId}/${escolha}`)
      .toPromise();
  }
}
