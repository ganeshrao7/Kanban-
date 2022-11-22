import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { Kanban } from '../model-classes/Kanban';
import { KanbanServiceService } from '../services/kanban-service.service';
import { TaskServiceService } from '../services/task-service.service';
import { TaskDialogComponent } from '../task-dialog/task-dialog.component';
import { Task } from '../model-classes/Task';
import { UpdateTaskDialogComponent } from '../update-task-dialog/update-task-dialog.component';
import { AuthenticationService } from '../services/authentication.service';
/* import { TaskStatus } from '../model-classes/TaskStatus'; */


@Component({
  selector: 'app-columns-of-task',
  templateUrl: './columns-of-task.component.html',
  styleUrls: ['./columns-of-task.component.css']
})
export class ColumnsOfTaskComponent {
  kanban!: Kanban;
  todos: Task[] = [];
  inprogress: Task[] = [];
  dones: Task[] = [];
  archives:Task[]=[];
  emailId!:any;



  constructor(
    private kanbanService: KanbanServiceService,
    private taskService: TaskServiceService,
    private route: ActivatedRoute,
    private dialog: MatDialog,
    private router:Router,
    private auth:AuthenticationService
  ) { 
    this.emailId=sessionStorage.getItem('email');
  }


  ngOnInit() {
    this.getKanban();
  }

  drop(event: CdkDragDrop<any>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      this.updateTaskStatusAfterDragDrop(event);
      transferArrayItem(event.previousContainer.data,
                        event.container.data,
                        event.previousIndex,
                        event.currentIndex);
    }
  }

  openDialogForNewTask(): void {
    this.openDialog('Create New Task', new Task());
  }

  openTaskDialog(event:any): void {
    let taskId = event.target.taskId;

    this.taskService.getTaskById(taskId).subscribe(
      response => {
        this.openDialog('Update Task', response);
      }
    );
  }

  idkanban!:any
  private getKanban(): void {
    const kanbanId = this.route.snapshot.params['kanbanId'];
    this.idkanban=kanbanId;
    sessionStorage.setItem('idkanban',this.idkanban);
    this.kanbanService.retrieveKanbanById(kanbanId).subscribe(
      (response)=> {
        this.kanban = response;
        this.splitTasksByStatus(response);
      }
    )
  }

  private splitTasksByStatus(kanban: Kanban): void {
    this.todos = kanban.tasks.filter(t=>t.taskStatus==='TODO');
    this.inprogress = kanban.tasks.filter(t=>t.taskStatus==='INPROGRESS');
    this.dones = kanban.tasks.filter(t=>t.taskStatus==='DONE');
    this.archives = kanban.tasks.filter(t=>t.taskStatus==='ARCHIVE');
  }

  private updateTaskStatusAfterDragDrop(event: CdkDragDrop<string[], string[]>) {
    let taskId = event.item.element.nativeElement.id;
    console.log(taskId);

    let kanbanId = this.route.snapshot.params['kanbanId'];
    let containerId = event.container.id;


    this.kanbanService.retrieveKanbanById(kanbanId).subscribe(
      response => {
        this.updateTaskStatus(response, containerId, taskId);
      }
    );
  }
  
  private updateTaskStatus(kanban: Kanban, containerId: string, taskId: any): void {

    kanban.tasks.forEach(function (task) {
      if (task.taskId == taskId) {
        if (containerId == 'todo') {
          console.log('Specific Task :: ' + task.taskName);
          task.taskStatus = 'TODO';
        }
        else if (containerId == 'inpro') {

          task.taskStatus = 'INPROGRESS';
        }
        else if(containerId == 'done'){
          task.taskStatus = 'DONE';
        }
        else{
          task.taskStatus = 'ARCHIVE';
        }
      }
    });
    this.kanbanService.updateKanban(kanban).subscribe(
      (data:{})=>{  
    });
    window.location.reload();
  }

  private openDialog(title: string, task: Task): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      title: title,
      task: task,
      kanbanId: this.kanban.kanbanId
    };
    this.dialog.open(TaskDialogComponent, dialogConfig)
  }

  update(task:Task){
    this.dialog.open(UpdateTaskDialogComponent,{
     width: '330px',
     height: '500px',
     data: task 
   });
 }

 
  onBack()
  {
    this.router.navigate(['/kanban']);
  }
  logoutbutton(){
    this.auth.logout();
  }
}
