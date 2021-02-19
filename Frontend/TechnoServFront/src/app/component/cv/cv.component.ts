import { Component, OnInit } from '@angular/core';
import { JwtclientService } from 'src/app/jwtclient.service';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-cv',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.css']
})
export class CvComponent implements OnInit {
  selectedFiles: FileList;
  constructor(private service:JwtclientService,private router:Router) { }
  currentFile: File;
  progress = 0;
  ngOnInit(): void {
  }
dp()
{
  console.log("hello upload");
  this.progress = 0;
  this.service.upload(this.selectedFiles.item(0)).subscribe(
    event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        alert('File Successfully Uploaded');
        this.router.navigateByUrl['/'];
      }
    },
    err => {
     console.log(err);
    });
}
selectFile(event) {
  this.selectedFiles = event.target.files;
}
}
