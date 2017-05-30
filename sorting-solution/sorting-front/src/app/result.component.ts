/**
 * Created by jurijs.eizvertins on 30.May.17.
 */

import {Component} from '@angular/core';
import {AppService} from './app.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html'
})

export class ResultComponent {

  inputArray: string;
  results: Result[];
  constructor(private appService: AppService) {}

  getResults() {
    this.appService.getResults()
      .subscribe(res => {
        this.results = res;
      });
  }

  clearResults() {
    this.appService.clearResults()
      .subscribe(res => {
        this.results[0] = res;
        return res;
      });
  }

  addSort() {
/*    console.log(this.inputArray);
    console.log(JSON.parse(this.inputArray));*/
    this.appService.addSort('[' + this.inputArray + ']')
      .subscribe((data) => this.inputArray);
    setTimeout(() => this.getResults(), 500);
    this.inputArray = '';
  }
}


export interface Result {
  id: number;
  sortedArray: string;
  changeCount: number;
  timeEstimate: string;
}
