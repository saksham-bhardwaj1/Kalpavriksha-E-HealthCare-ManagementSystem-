// display-html.component.ts
import { Component, OnInit } from '@angular/core';
import { ApiService } from '../html.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css'],
})
export class DisplayHtmlComponent implements OnInit {
  htmlContent: string;
  id: number;

  constructor(private apiService: ApiService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.fetchHtmlFromApi();
  }

  fetchHtmlFromApi() {
    this.apiService.fetchHTMLFromAPI(this.id).subscribe(
      (data: string) => {
        this.htmlContent = data;
      },
      (error) => {
        console.error('Error fetching HTML:', error);
        // Handle error as needed
      }
    );
  }
}
