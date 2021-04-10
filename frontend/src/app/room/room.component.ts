import {
  Component,
  EventEmitter,
  HostListener,
  Input,
  OnInit,
  Output,
  TemplateRef,
} from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { RoomService } from 'src/service/room.service';
import { MapaModalComponent } from '../mapa/mapa-modal.component';
import { DoorsPosition } from '../model/room';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.scss'],
})
export class RoomComponent implements OnInit {
  @Input() roomId: number;
  @Input() temPortaAtras: boolean;
  @Input() temPortaFrente: boolean;
  @Input() temPortaDireita: boolean;
  @Input() temPortaEsquerda: boolean;

  modalRef: BsModalRef;
  doors = DoorsPosition;
  direcao = 'norte';

  @Output() escolhaRealizada = new EventEmitter<number>();

  constructor(private roomService: RoomService, protected dialog: MatDialog) {}

  ngOnInit(): void {}

  mudaPosicao(posicao: number) {
    this.roomService.mudaPosicao(this.roomId, posicao).then((roo) => {
      this.temPortaDireita = roo.direita;
      this.temPortaEsquerda = roo.esquerda;
      this.temPortaFrente = roo.frente;
      this.temPortaAtras = roo.atras;
      this.direcao = roo.direcao;
    });
  }

  @HostListener('document:keydown', ['$event'])
  getKeypress(event) {
    console.log(event);
    switch (event.key) {
      case 'ArrowUp':
        this.mudaPosicao(this.doors.FRENTE);
        break;
      case 'ArrowDown':
        this.mudaPosicao(this.doors.ATRAS);
        break;
      case 'ArrowRight':
        this.mudaPosicao(this.doors.DIREITA);
        break;
      case 'ArrowLeft':
        this.mudaPosicao(this.doors.ESQUERDA);
        break;
      default:
        break;
    }
  }

  abrirMapa(){
    this.dialog.open(MapaModalComponent, {
      data: {
        title: 'taporra',
        mapaUrl: 'teste',
      },
    })
  }
}
