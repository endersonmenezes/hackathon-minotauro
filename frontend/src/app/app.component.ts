import { Component, OnInit } from '@angular/core';
import { RoomService } from 'src/service/room.service';

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

  constructor(private roomService: RoomService) {}

  ngOnInit(): void {
    this.roomService
      .initGame('Pedro', 1)
      .then((room) => {
        this.roomId = room.id;
        //   this.roomService.getFirstRoom(this.roomId);
      })
      .catch((err) => {
        return err;
      });
  }
}
