import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss'],
})
export class MenuComponent {
  nome: string;
  nivel = 1;

  constructor(public dialogRef: MatDialogRef<MenuComponent>) {}

  start() {
    const data = {nome: this.nome, nivel: this.nivel};
    this.dialogRef.close(data);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
  setNivel(nivel) {
    this.nivel = nivel;
  }
}
