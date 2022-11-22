import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { KanbanDialogComponent } from '../kanban-dialog/kanban-dialog.component';
import { Kanban } from '../model-classes/Kanban';
import { AuthenticationService } from '../services/authentication.service';
import { KanbanServiceService } from '../services/kanban-service.service';

@Component({
  selector: 'app-list-of-kanbans',
  templateUrl: './list-of-kanbans.component.html',
  styleUrls: ['./list-of-kanbans.component.css']
})
export class ListOfKanbansComponent{

 /*  kanbanList = ['Get to work', 'Pick up groceries', 'Go home', 'Fall asleep']; */
 kanbanList!: Kanban[];
 email!:any;

 constructor(
   private kanbanService: KanbanServiceService,
   private dialog: MatDialog,
   private auth:AuthenticationService
 ) { 
  this.email=sessionStorage.getItem('email');
 }

 ngOnInit() {
  this.getAllKanbanByEmailId();
 }

 openDialogForNewKanban(): void {
   const dialogConfig = new MatDialogConfig();
   dialogConfig.autoFocus = true;
   dialogConfig.data = {
     kanban: new Kanban()
   };
   this.dialog.open(KanbanDialogComponent, dialogConfig)
 }


 private getAllKanbanByEmailId(): void {
  this.kanbanService.getAllKanbanByEmail(this.email).subscribe(
   response => {
      this.kanbanList = response;
     }
  )
 }

 onBack()
 {
   
 }

 log(){
   this.auth.logout();
 }

}
