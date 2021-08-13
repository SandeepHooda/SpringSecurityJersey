import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import ResponseVO from '../common/vo/response.vo'
import { Observable } from 'rxjs';
import { Constants } from '../common/vo/constant';

@Injectable({
  providedIn: 'root'
})
export class AddService {

  constructor(private httpClient: HttpClient) { }

  addData(data:any){
   return this.httpClient.post<Number>(Constants.appContext+"/math/add",data);
  }
}
