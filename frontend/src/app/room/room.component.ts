import {
  Component,
  EventEmitter,
  HostListener,
  Input,
  OnInit,
  Output,
  TemplateRef,
} from '@angular/core';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { DoorsPosition } from '../model/room';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.scss'],
})
export class RoomComponent implements OnInit {
  @Input() temPortaFrente: boolean;
  @Input() temPortaDireita: boolean;
  @Input() temPortaEsquerda: boolean;
  modalRef: BsModalRef;
  doors = DoorsPosition;
  position: 'norte' | 'sul' | 'leste' | 'oeste' = 'norte';

  @Output() escolhaRealizada = new EventEmitter<number>();

  constructor(private modalService: BsModalService) {}

  ngOnInit(): void {}

  registraEscolha(escolha: number) {
    this.escolhaRealizada.emit(escolha);
  }

  @HostListener('document:keydown', ['$event'])
  getKeypress(event) {
    console.log(event);
    switch (event.key) {
      case 'ArrowUp':
        this.position = 'norte';
        this.escolhaRealizada.emit(this.doors.FRENTE);
        break;
      case 'ArrowDown':
        this.position = 'sul';
        this.escolhaRealizada.emit(this.doors.ATRAS);
        break;
      case 'ArrowRight':
        this.position = 'oeste';
        this.escolhaRealizada.emit(this.doors.DIREITA);
        break;
      case 'ArrowLeft':
        this.position = 'leste';
        this.escolhaRealizada.emit(this.doors.ESQUERDA);
        break;
      default:
        break;
    }
  }
}
