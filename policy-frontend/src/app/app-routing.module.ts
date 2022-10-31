import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ClientListComponent} from "./components/client-list/client-list.component";
import {ClientDetailsComponent} from "./components/client-details/client-details.component";
import {AddClientComponent} from "./components/add-client/add-client.component";
import {AdminPageComponent} from "./components/admin-page/admin-page.component";
import {AdminLoginComponent} from "./components/admin-login/admin-login.component";
import {ClientPageComponent} from "./components/client-page/client-page.component";

const routes: Routes = [
  {path: '', redirectTo: 'client', pathMatch: 'full'},
  { path: 'client', component: ClientListComponent },
  { path: 'admin-page', component: AdminPageComponent},
  {path: 'admin-login', component: AdminLoginComponent},
  {path: 'client-page', component: ClientPageComponent},
  { path: 'client/:clientId', component: ClientDetailsComponent },
  { path: 'add', component: AddClientComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
