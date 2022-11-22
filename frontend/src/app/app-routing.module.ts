import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { ColumnsOfTaskComponent } from './columns-of-task/columns-of-task.component';
import { ListOfKanbansComponent } from './list-of-kanbans/list-of-kanbans.component';
import { LoginComponent } from './login/login.component';
import { PrivacyPolicyComponent } from './privacy-policy/privacy-policy.component';
import { RegisterComponent } from './register/register.component';
import { AuthService } from './services/service/auth.service';
import { AuthguardService } from './services/service/authguard.service';

/* 
{
  path:"",
  component:LoginComponent

},
{
  path:"register",
  component:RegisterComponent
},
{
  path:"task",
  component:ColumnsOfTaskComponent
}
,
{
  path:"kanban",
  component:ListOfKanbansComponent
}];
 */
const routes: Routes = [
  {
    path: '', 
     redirectTo:'/kanban',
     pathMatch:'full'},
     {
       path:'kanban',
       component:ListOfKanbansComponent,   canActivate:[AuthguardService]
     },
  {
     path: 'login',
   component: LoginComponent
   },
/*   {
    path:'logout', 
    component:LogoutComponent
  }, */
  {
    path: 'register',
      component:RegisterComponent 
     },

    {
    path: 'kanbans/:kanbanId',  
     component: ColumnsOfTaskComponent ,
      canActivate:[AuthguardService]
     },
     {
       path:'about-us',
       component:AboutUsComponent,
       canActivate:[AuthguardService]
     },
     {
       path:'privacy-policy',
       component:PrivacyPolicyComponent,
       canActivate:[AuthguardService]
     }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
