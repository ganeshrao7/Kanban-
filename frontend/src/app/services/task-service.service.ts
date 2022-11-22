import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import{Task} from '../model-classes/Task'
@Injectable({
  providedIn: 'root'
})
export class TaskServiceService {
  private taskurl= 'http://localhost:8083/task-service/api/v1/';


  constructor(private http: HttpClient) { }

  updateTask(data:any): Observable<any> {
    let headers = new HttpHeaders({'Content-Type': 'application/json' });
    return this.http.post<Task>(
      this.taskurl +  data+'update/' ,
     JSON.stringify(data),
      { headers: headers });
  }
  

  getTaskById(data:any): Observable<any> {
  /*   return this.http.get<Task>(`${this.taskurl}tasks/${taskId}`); */
  console.log(data);
  
  return this.http.get<Task>(this.taskurl+ data + '/tasks' );
  }


  deleteTaskById(taskId:number):Observable<any>{
    return this.http.delete(`${this.taskurl}delete-task/${taskId}`, { responseType: 'text' });
  }

}

