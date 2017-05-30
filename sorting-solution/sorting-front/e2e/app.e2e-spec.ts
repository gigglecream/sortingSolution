import { SortingFrontPage } from './app.po';

describe('sorting-front App', () => {
  let page: SortingFrontPage;

  beforeEach(() => {
    page = new SortingFrontPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
