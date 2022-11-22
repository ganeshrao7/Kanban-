import { Component, Inject, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatCalendarCellClassFunction } from '@angular/material/datepicker';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Task } from '../model-classes/Task';
import { KanbanServiceService } from '../services/kanban-service.service';
import { TaskServiceService } from '../services/task-service.service';
import { TaskDialogComponent } from '../task-dialog/task-dialog.component';

@Component({
  selector: 'app-update-task-dialog',
  templateUrl: './update-task-dialog.component.html',
  styleUrls: ['./update-task-dialog.component.css']
})
export class UpdateTaskDialogComponent implements OnInit {
  @Input() min: any;
  minDate:Date = new Date();
  dialogTitle: String;
   kanbanId: number;
  // task: Task;
  id!:any;
  task:Task ={
    taskId: 0,
    taskName: "",
    taskDescription: "",
    userName: "",
    taskStatus: "",
    dueDate: ''
  }
    
  form!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<TaskDialogComponent>,
    @Inject(MAT_DIALOG_DATA) data:any,
    
    private kanbanService: KanbanServiceService,

    private taskService: TaskServiceService) {
      console.log(data);
      
     this.dialogTitle = data.title;
     this.kanbanId = data.kanbanId;
    

  this.createTaskForm();

  this.form.setValue(data);
  this.minDate.setDate(this.minDate.getDate() );

   }

   createTaskForm() :void{
    this.form=new FormGroup({
      "taskId":new FormControl (0),
      "taskName":new FormControl(this.task.taskName,[Validators.required]),
       "taskDescription":new FormControl(this.task.taskDescription,[Validators.required]),
       "userName":new FormControl(this.task.userName,[Validators.required]),
       "taskStatus":new FormControl(this.task.taskStatus,[Validators.required]),
       "dueDate":new FormControl(this.task.dueDate,[Validators.required])
    });
  }

  dateClass: MatCalendarCellClassFunction<Date> = (cellDate, view) => {
    // Only highligh dates inside the month view.
    if (view === 'month') {
      const date = cellDate.getDate();

      // Highlight the 1st and 20th day of each month.
      return date === 1 || date === 20 ? 'example-custom-date-class' : '';
    }

    return '';
  };

  ngOnInit() {

 
  }


  update(){
    this.mapFormToTaskModel();
    this.id=sessionStorage.getItem('idkanban');
    const Observable= this.kanbanService.updateTaskToKanban(this.id,this.form.value);
    Observable.subscribe((data:{}) =>{
      
      console.log(data);
      
    });
 
  this.dialogRef.close();
  window.location.reload();
}



  close() {
      this.dialogRef.close();
  } 

  private mapFormToTaskModel(): void {

    this.task.taskName = this.form.value;
    this.task.taskDescription= this.form.value;
    this.task.userName = this.form.value;
    this.task.taskStatus = this.form.value;

  }

  delete(){
    this.mapFormToTaskModel();
    this.id=sessionStorage.getItem('idkanban');
    const Observable= this.kanbanService.deleteTaskFromKanban(this.id,this.form.controls['taskId'].value);
    Observable.subscribe((data:{}) =>{
      console.log(data);
    });
  this.dialogRef.close();
  
  
  }



}