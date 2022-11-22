import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Kanban } from '../model-classes/Kanban';
import { Task } from '../model-classes/Task';
@Injectable({
  providedIn: 'root'
})
export class KanbanServiceService {
  private kanbanurl= 'http://localhost:8082/kanban-service/api/v1/';

  constructor(private http: HttpClient) { }

  retrieveAllKanbanBoards():Observable<Kanban[]>{
    return this.http.get<Kanban[]>(this.kanbanurl+'get-all-kanban/' );
   /*  return this.http.get<Kanban[]>(this.kanbanAppUrl + '/kanbans/'); */
  }

  retrieveKanbanById(kanbanId: number): Observable<any>{
    return this.http.get<Kanban>(this.kanbanurl + 'kanban/' + kanbanId);
    /* return this.http.get<Task>(`${this.kanbanurl}kanban/${kanbanId}`); */
  }

  saveNewKanban(data: any): Observable<string> {
    let headers = new HttpHeaders({'Content-Type': 'application/json' });
    
    return this.http.post<string>(
      this.kanbanurl+'save-new-kanban/',
      JSON.stringify(data) ,
      {'headers':headers}
    );
  }

  saveNewTaskInKanban(kanbanId: number, data: any): Observable<Task> {
    let headers = new HttpHeaders({'Content-Type': 'application/json' });
     console.log(data);

    return this.http.post<Task>(
      this.kanbanurl +  kanbanId +'/add',
      JSON.stringify(data),
      {'headers':headers});
  }
  updateTaskToKanban(kanbanId:number,data:any): Observable<Task>{
    let headers = new HttpHeaders({'Content-Type': 'application/json' });
    
    let options = { headers: headers };
    return this.http.post<Task>(
      this.kanbanurl +  + kanbanId + '/update',
      data,
      options);

  }
  deleteTaskFromKanban(kanbanId:any,data:any):Observable<any> {
    return this.http.delete<Task>( this.kanbanurl + kanbanId + '/delete',data);

  }
  updateKanban(kanban:any): Observable<Kanban> {
    let headers = new HttpHeaders({'Content-Type': 'application/json' });
    return this.http.put<Kanban>(
      this.kanbanurl +'update' ,
      kanban,
      {'headers':headers}
      );
  }

  public getAllKanbanByEmail(email:any): Observable<Kanban[]> {
    const headers = { 'content-type': 'application/json'}  
    
    console.log(email);
    return this.http.get<Kanban[]>(this.kanbanurl + email+'/kanban/');
  }
}