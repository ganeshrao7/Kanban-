import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { KanbanDTO } from '../model-classes/KanbanDTO';
import { KanbanServiceService } from '../services/kanban-service.service';

@Component({
  selector: 'app-kanban-dialog',
  templateUrl: './kanban-dialog.component.html',
  styleUrls: ['./kanban-dialog.component.css']
})
export class KanbanDialogComponent implements OnInit {
  kanbanTitle !: string ;
  details:KanbanDTO={
    kanbanTitle: '',
    email: ''
  }
  form!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<KanbanDialogComponent>,
    @Inject(MAT_DIALOG_DATA) data:any,
    private kanbanService: KanbanServiceService) { 
      this.createForm();
    }

    createForm() :void{
      this.form=new FormGroup({
         "kanbanTitle":new FormControl(this.details.kanbanTitle,[Validators.required]),
         "email":new FormControl(sessionStorage.getItem('email'))
      });
    }

  ngOnInit() {
  }

  close() {
    this.dialogRef.close();
  } 

  save(){

    const Observable= this.kanbanService.saveNewKanban(this.form.value);
    Observable.subscribe((data:{}) =>{
      
    })
    this.dialogRef.close();
    window.location.reload();
  }

}
