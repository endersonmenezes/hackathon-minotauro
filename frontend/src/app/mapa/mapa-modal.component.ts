import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DialogData } from '../model/dialog';

@Component({
  selector: 'iad-mapa-modal',
  templateUrl: './mapa-modal.component.html',
  styleUrls: ['./mapa-modal.component.scss'],
})
export class MapaModalComponent {
  title = '';
  mapaUrl = '';
  noButton = 'Não';
  yesButton = 'Sim';

  hashCode = ''

  constructor(@Inject(MAT_DIALOG_DATA) public data: DialogData) {
    this.title = data.title
    this.mapaUrl = data.mapaUrl
    this.noButton = data.noButton || 'Não'
    this.yesButton = data.yesButton || 'Sim'
    this.hashCode = new Date().toUTCString()
  }
}
