import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { RoomService } from 'src/service/room.service';
import { DoorsPosition } from './model/room';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  roomId: number;
  temPortaFrente = false;
  temPortaDireita = false;
  temPortaEsquerda = false;
  temPortaAtras = false;

  constructor(private roomService: RoomService) {}

  ngOnInit(): void {
    this.roomService
      .initGame('Pedro', 1)
      .then((room) => {
        this.roomId = room.id;
        this.roomService.getPosicaoAtual(this.roomId).then((roo) => {
          this.temPortaDireita = roo.direita;
          this.temPortaEsquerda = roo.esquerda;
          this.temPortaFrente = roo.frente;
          this.temPortaAtras = roo.atras;
        });
      })
      .catch((err) => {
        return err;
      });
  }
}
