import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddComponent } from './add/add.component';
import { HomeComponent } from './home/home.component';
import {MatButtonModule} from '@angular/material/button';;
import {CdkAccordionModule} from '@angular/cdk/accordion';
import { SubComponent } from './sub/sub.component';
import { MulComponent } from './mul/mul.component';
import { DivComponent } from './div/div.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    AddComponent,
    HomeComponent,
    SubComponent,
    MulComponent,
    DivComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    CdkAccordionModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
