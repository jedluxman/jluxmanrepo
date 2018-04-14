import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { FormContactComponent } from './component/form-contact/form-contact.component';
import { ListContactComponent } from './component/list-contact/list-contact.component';
import { AboutComponent } from './component/about/about.component';

const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'contact',component:FormContactComponent},
  {path:'list',component:ListContactComponent},
  {path:'about',component:AboutComponent},
  {path: '',redirectTo: '/home',pathMatch: 'full'},
  {path: '**',redirectTo: '/home',pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [HomeComponent,FormContactComponent,ListContactComponent,AboutComponent];
