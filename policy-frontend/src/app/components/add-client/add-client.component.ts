import { Component, OnInit } from '@angular/core';
import {Client} from "../../model/client";
import {AdminSvcService} from "../../services/admin-svc.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})
export class AddClientComponent implements OnInit {
  client: Client = {
    clientId: undefined,
    firstName: '',
    lastName: '',
    email: '',
    age: undefined,
    gender: '',
    contactNo: undefined,
    policyNo: ''
  };

  submitted = false;
  file: any;

  constructor(
    private adminService: AdminSvcService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  selectFile(event: any) {
    this.file = event.target.files[0];
    console.log(this.file);
  }

  // uploadFile(){
  //   let formData = new FormData();
  //   formData.append('file', this.file);
  //   this.adminService.upload(formData).subscribe(
  //     data => {
  //       console.log(data);
  //     },
  //     error => {
  //       console.log(error);
  //     }
  //   );
  // }

  saveClint(): void {
    const data = {
      firstName: this.client.firstName,
      lastName: this.client.lastName,
      email: this.client.email,
      age: this.client.age,
      gender: this.client.gender,
      contactNo: this.client.contactNo,
      policyNo: this.client.policyNo
    };
    this.adminService.create(data)
      .subscribe(
        (response: any) => {
          console.log(response);
          this.submitted =true;
          this.goToClientList();
        },
        (error: any) => {
          console.log(error)
        });
  }

  goToClientList() {
    this.router.navigate(['/client']);
  }

  newClient(): void {
    this.submitted = false;
    this.client = {
      clientId: undefined,
      firstName: '',
      lastName: '',
      email: '',
      age: undefined,
      gender: '',
      contactNo: undefined,
      policyNo: ''
    };
  }

}
