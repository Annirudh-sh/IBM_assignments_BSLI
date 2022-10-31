import { Component, OnInit } from '@angular/core';
import {Client} from "../../model/client";
import {AdminSvcService} from "../../services/admin-svc.service";

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {
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

  removeAllClients(): void {
    this.adminService.deleteAll()
      .subscribe(
        response => {
          console.log(response);
          this.refreshList();
        },
          error => {
            console.log(error);
          });
  }
}
