import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.scss'],
})
export class RoomComponent implements OnInit {
  @Input() temPortaFrente: boolean;
  @Input() temPortaDireita: boolean;
  @Input() temPortaEsquerda: boolean;

  constructor() {}

  ngOnInit(): void {}
}
