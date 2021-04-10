import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { RoomService } from 'src/service/room.service';
import { MenuComponent } from './menu/menu.component';
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

  constructor(private roomService: RoomService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.abrirMenu();
  }
  abrirMenu() {
    const dialogRef = this.dialog.open(MenuComponent, {
      data: {
        title: 'inicio',
        mapaUrl: 'jornada',
      }, disableClose: true
    });
    dialogRef.afterClosed().subscribe((data) => {
      this.startGame(data);
    });
  }

  startGame(data: { nome: string; nivel: number }) {
    this.roomService
      .initGame(data.nome, data.nivel)
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
