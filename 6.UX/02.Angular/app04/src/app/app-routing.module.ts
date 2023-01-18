import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ContactFormComponent } from './contact-form/contact-form.component';
import { ContactsListComponent } from './contacts-list/contacts-list.component';

const routes: Routes = [
  {path:'',pathMatch:'full',redirectTo:'/list'},
  {path:'list',component:ContactsListComponent},
  {path:'add',component:ContactFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
