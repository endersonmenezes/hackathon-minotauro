import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { ModalModule } from 'ngx-bootstrap/modal';
import { AppComponent } from './app.component';
import { RoomComponent } from './room/room.component';
import { ControlComponent } from './control/control.component';

@NgModule({
  declarations: [AppComponent, RoomComponent, ControlComponent],
  imports: [
    BrowserModule,
    CommonModule,
    HttpClientModule,
    ModalModule.forRoot(),
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
