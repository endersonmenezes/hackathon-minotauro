import { Component, Inject } from '@angular/core'
import { MAT_DIALOG_DATA } from '@angular/material/dialog'

interface DialogData {
  title: string
  mapaUrl: string
  noButton?: string
  yesButton?: string
}

@Component({
  selector: 'iad-mapa-modal',
  templateUrl: './mapa-modal.component.html',
  styleUrls: ['./mapa-modal.component.scss'],
})
export class MapaModalComponent {
  title = ''
  mapaUrl = ''
  noButton = 'Não'
  yesButton = 'Sim'

  constructor(@Inject(MAT_DIALOG_DATA) public data: DialogData) {
    this.title = data.title
    this.mapaUrl = data.mapaUrl
    this.noButton = data.noButton || 'Não'
    this.yesButton = data.yesButton || 'Sim'
  }
}
