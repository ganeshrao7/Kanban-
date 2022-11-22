import { Component, Inject, Input, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { KanbanServiceService } from '../services/kanban-service.service';
import { TaskServiceService } from '../services/task-service.service';
import { Task } from '../model-classes/Task';
import { NotificationService } from '../services/notification.service';
import { ToastrService } from 'ngx-toastr';
import { MatCalendarCellClassFunction } from '@angular/material/datepicker';
@Component({
  selector: 'app-task-dialog',
  templateUrl: './task-dialog.component.html',
  styleUrls: ['./task-dialog.component.css']
})
export class TaskDialogComponent implements OnInit {
  @Input() min: any;
  minDate:Date = new Date();
  dialogTitle: String;
  kanbanId: number;
/*   task: Task; */

task:Task ={
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
    private taskService: TaskServiceService,
    private notification:NotificationService,
    private toastr:ToastrService) {

    this.dialogTitle = data.title;
    this.kanbanId = data.kanbanId;
   /*  this.task = data.task; */

        this.createForm();
        this.minDate.setDate(this.minDate.getDate() );
   }
 
 

   createForm() :void{
    this.form=new FormGroup({
      "taskName":new FormControl(this.task.taskName,[Validators.required]),
       "taskDescription":new FormControl(this.task.taskDescription,[Validators.required]),
       "userName":new FormControl(this.task.userName,[Validators.required]),
       "taskStatus":new FormControl("TODO"),
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
   ngOnInit(){
 
   }
 

 

  save(){
    this.mapFormToTaskModel();
    if(this.form.value){
      console.log(this.form.value);
      
    const Observable= this.kanbanService.saveNewTaskInKanban(this.kanbanId,this.form.value);
    Observable.subscribe((data:{}) =>{
      
      console.log(data);
      
    });
   
    
      
    
   
  }
  else{
    this.taskService.updateTask(this.form.value).subscribe();
  }
  this.dialogRef.close();
    window.location.reload();
}

close() {
  this.dialogRef.close();
} 

showToasterSuccess()
{
  this.toastr.success("Data saved successfully !!", this.form.controls['taskName'].value);
}

callBoth()
{
  this.save();
  this.showToasterSuccess();
}

  private mapFormToTaskModel(): void {

     this.task.taskName = this.form.value;
     this.task.taskDescription = this.form.value;
     this.task.userName= this.form.value;
    /*  this.task.taskStatus = this.form.value; */

  }


}



