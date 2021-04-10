import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.scss'],
})
export class RoomComponent implements OnInit {
  @Input() temPortaFrente: boolean;
  @Input() temPortaDireita: boolean;
  @Input() temPortaEsquerda: boolean;

  @Output() escolhaRealizada = new EventEmitter<number>();

  constructor() {}

  ngOnInit(): void {}

  registraEscolha(escolha: number){
    this.escolhaRealizada.emit(escolha)
  }
}
