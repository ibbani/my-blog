import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { PostComponent } from './post-resources/post/post.component';
import { PostCreateComponent } from './post-resources/post-create/post-create.component';
import { PostListComponent } from './post-resources/post-list/post-list.component';
import { PostSearchComponent } from './post-resources/post-search/post-search.component';
import { AdminComponent } from './admin-resources/admin/admin.component';
import { ManageUserComponent } from './admin-resources/manage-user/manage-user.component';
import { ManageCategoryComponent } from './admin-resources/manage-category/manage-category.component';
import { MenuComponent } from './menu/menu.component';
import { BannerComponent } from './banner/banner.component';
import { AdminMenuComponent } from './admin-resources/admin-menu/admin-menu.component';
import { ProfileComponent } from './profile/profile.component';
import { PostMenuComponent } from './post-resources/post-menu/post-menu.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    PostComponent,
    PostCreateComponent,
    PostListComponent,
    PostSearchComponent,
    AdminComponent,
    ManageUserComponent,
    ManageCategoryComponent,
    MenuComponent,
    BannerComponent,
    AdminMenuComponent,
    ProfileComponent,
    PostMenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
