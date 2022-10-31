import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientListComponent } from './components/client-list/client-list.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { AddClientComponent } from './components/add-client/add-client.component';
import { ClientDetailsComponent } from './components/client-details/client-details.component';
import { AdminLoginComponent } from './components/admin-login/admin-login.component';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { ClientPageComponent } from './components/client-page/client-page.component';
import { ClientInfoComponent } from './components/client-info/client-info.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientListComponent,
    AddClientComponent,
    ClientDetailsComponent,
    AdminLoginComponent,
    AdminPageComponent,
    ClientPageComponent,
    ClientInfoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
