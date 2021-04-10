import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { BrowserModule } from '@angular/platform-browser';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { ModalModule } from 'ngx-bootstrap/modal';
import { AppComponent } from './app.component';
import { MapaModalComponent } from './mapa/mapa-modal.component';
import { MenuComponent } from './menu/menu.component';
import { RoomComponent } from './room/room.component';
import { VitoriaComponent } from './vitoria/vitoria.component';

@NgModule({
  declarations: [
    AppComponent,
    RoomComponent,
    MapaModalComponent,
    MenuComponent,
    VitoriaComponent,
  ],
  imports: [
    FormsModule,
    BrowserModule,
    CommonModule,
    HttpClientModule,
    ModalModule.forRoot(),
    ReactiveFormsModule,
    NoopAnimationsModule,
    MatDialogModule,
    MatButtonModule,
    MatInputModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
