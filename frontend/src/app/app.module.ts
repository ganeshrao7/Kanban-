import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatToolbarModule} from '@angular/material/toolbar';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSelectModule } from '@angular/material/select';
import { MatListModule } from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { AppComponent } from './app.component';
import { TaskDialogComponent } from './task-dialog/task-dialog.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { LayoutModule } from '@angular/cdk/layout';
import { ColumnsOfTaskComponent } from './columns-of-task/columns-of-task.component';
import { ListOfKanbansComponent } from './list-of-kanbans/list-of-kanbans.component';
import { LoginComponent } from './login/login.component';
import {MatChipsModule} from '@angular/material/chips';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import { KanbanDialogComponent } from './kanban-dialog/kanban-dialog.component';
import { UpdateTaskDialogComponent } from './update-task-dialog/update-task-dialog.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { RegisterComponent } from './register/register.component';
import { ToastrModule } from 'ngx-toastr';
import { AboutUsComponent } from './about-us/about-us.component';
import { PrivacyPolicyComponent } from './privacy-policy/privacy-policy.component';
import { MatNativeDateModule } from '@angular/material/core';
import { AuthguardService } from './services/service/authguard.service';
import { AuthenticationService } from './services/authentication.service';



@NgModule({
  declarations: [
    AppComponent,
    ColumnsOfTaskComponent,
    ListOfKanbansComponent,
    LoginComponent,
    RegisterComponent,
    TaskDialogComponent,
    KanbanDialogComponent,
    UpdateTaskDialogComponent,
    AboutUsComponent,
    PrivacyPolicyComponent,
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    HttpClientModule,
    MatSelectModule,
    MatListModule,
    MatButtonModule,
    DragDropModule,
    MatDialogModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatGridListModule,
    MatDatepickerModule,
    MatCardModule ,
    MatMenuModule,
    MatIconModule ,
    LayoutModule,
    MatSlideToggleModule,
    MatChipsModule,
    MatFormFieldModule,
    ToastrModule.forRoot(),
    MatDatepickerModule,
    MatNativeDateModule ,
 
   
],
  providers: [AuthguardService,AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
