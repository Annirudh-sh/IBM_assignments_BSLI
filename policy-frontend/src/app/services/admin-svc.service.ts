import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Client} from "../model/client";

const baseUrl = 'http://localhost:8080/api/policy/clients'

@Injectable({
  providedIn: 'root'
})
export class AdminSvcService {

  constructor(private http: HttpClient) { }

  getClients(): Observable<Client[]> {
    return this.http.get<Client[]>(baseUrl);
  }

  getClient(id: any): Observable<Client> {
    //@ts-ignore
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data)
  }

  update(id: any, data: any):Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  // upload(formData: FormData): Observable<any>{
  //   return this.http.post(baseUrl, formData);
  // }
}
