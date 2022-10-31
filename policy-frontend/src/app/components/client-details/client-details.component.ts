import { Component, OnInit } from '@angular/core';
import {Client} from "../../model/client";
import {AdminSvcService} from "../../services/admin-svc.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-client-details',
  templateUrl: './client-details.component.html',
  styleUrls: ['./client-details.component.css']
})
export class ClientDetailsComponent implements OnInit {
  currentClient: Client = {
    clientId: undefined,
    firstName: '',
    lastName: '',
    email: '',
    age: undefined,
    gender: '',
    contactNo: undefined,
    policyNo: ''
  };
  message = '';

  constructor(
    private adminService: AdminSvcService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.message = '';
    this.getClient(this.route.snapshot.params['clientId']);
  }

  getClient(clientId: number): void{
    this.adminService.getClient(clientId)
      .subscribe(
        data => {
          this.currentClient = data;
          console.log(data);
        },
          error => {
          console.log(error);
        });
  }

  updateClient(): void {
    this.message = '';
    this.adminService.update(this.currentClient.clientId, this.currentClient)
      .subscribe(
        response => {
          console.log(response);
          this.message = response.message ? response.message : 'Client [ ' + this.currentClient.clientId + ' ] was updated successfully...!';
        },
          error => {
          console.log(error);
        });
  }

  deleteClient(): void {
    this.adminService.delete(this.currentClient.clientId)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/']);
        },
          error => {
          console.log(error)
        });
  }

}
