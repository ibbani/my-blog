import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ManageUserComponent } from './admin-resources/manage-user/manage-user.component';
import { ManageCategoryComponent } from './admin-resources/manage-category/manage-category.component';
import { PostCreateComponent } from './post-resources/post-create/post-create.component';
import { PostComponent } from './post-resources/post/post.component';
import { PostSearchComponent } from './post-resources/post-search/post-search.component';
import { AdminComponent } from './admin-resources/admin/admin.component';
import { PostListComponent } from './post-resources/post-list/post-list.component';

const routes: Routes = [
  { path : "", redirectTo: "home", pathMatch : "full"},
  { path : "home", component : HomeComponent},
  { path : "post", component : PostComponent},
  { path : "post-list", component : PostListComponent},
  { path : "new-post", component : PostCreateComponent},
  { path : "search-post", component : PostSearchComponent},
  { path : "admin", component : AdminComponent},
  { path : "muser", component : ManageUserComponent},
  { path : "mcategory", component : ManageCategoryComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
