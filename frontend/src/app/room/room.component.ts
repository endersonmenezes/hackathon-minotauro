import {
  Component,
  EventEmitter,
  HostListener,
  Input,
  OnInit,
  Output,
} from '@angular/core';
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

  doors = DoorsPosition;

  @Output() escolhaRealizada = new EventEmitter<number>();

  constructor() {}

  ngOnInit(): void {}

  registraEscolha(escolha: number) {
    this.escolhaRealizada.emit(escolha);
  }

  @HostListener('document:keydown', ['$event'])
  getKeypress(event) {
    console.log(event);
    switch (event.key) {
      case 'ArrowUp':
        this.escolhaRealizada.emit(this.doors.FRENTE);
        break;
      case 'ArrowDown':
        this.escolhaRealizada.emit(this.doors.ATRAS);
        break;
      case 'ArrowRight':
        this.escolhaRealizada.emit(this.doors.DIREITA);
        break;
      case 'ArrowLeft':
        this.escolhaRealizada.emit(this.doors.ESQUERDA);
        break;
      default:
        break;
    }
  }
}
