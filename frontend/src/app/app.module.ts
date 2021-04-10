import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RoomComponent } from './room/room.component';
import { CommonModule } from '@angular/common';

import { HttpClientModule } from '@angular/common/http';
@NgModule({
  declarations: [AppComponent, RoomComponent],
  imports: [BrowserModule, CommonModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
