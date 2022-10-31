import { Component, OnInit } from '@angular/core';
import {Client} from "../../model/client";
import {AdminSvcService} from "../../services/admin-svc.service";

@Component({
  selector: 'app-client-page',
  templateUrl: './client-page.component.html',
  styleUrls: ['./client-page.component.css']
})
export class ClientPageComponent implements OnInit {
  clients?: Client[];
  currentClient?: Client;
  currentIndex = -1;

  constructor(private adminService: AdminSvcService) { }

  ngOnInit(): void {
    this.retrieveClients();
  }

  retrieveClients(): void {
    this.adminService.getClients()
      .subscribe(
        data =>{
          this.clients=data;
        },
        error => {
          console.log(error);
        });
  }

  refreshList(): void {
    this.retrieveClients();
    this.currentClient = undefined;
    this.currentIndex = -1;
  }

  setActiveClient(client: Client, index: number): void {
    this.currentClient = client;
    this.currentIndex = index;
  }


}
