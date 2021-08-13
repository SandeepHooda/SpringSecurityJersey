import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AddService } from './add.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  constructor(private adSrv:AddService) { }
  public addResult:Number;

  public onSubmit(f:NgForm):void{
    console.log(f)
    this.adSrv.addData(f.value).subscribe( data => {
      console.log(data)
      this.addResult = data;
    }, error => {
      console.log(error)
    });

  }
  ngOnInit(): void {
  }

}
