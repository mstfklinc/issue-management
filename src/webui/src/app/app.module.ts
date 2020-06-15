import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app.routing.module';
import { AppComponent } from './app.component';
import {DashboardModule} from './pages/dashboard/dashboard.module';
import {ProjectModule} from './pages/project/project.module';
import {IssueModule} from './pages/issue/issue.module';


@NgModule({
  declarations: [
    AppComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    DashboardModule,
    ProjectModule,
    IssueModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
