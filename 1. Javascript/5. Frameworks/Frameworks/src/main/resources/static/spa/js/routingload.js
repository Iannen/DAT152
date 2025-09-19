import '../components/pagecomponentload/pagecomponentload.js';
import Router from '../js/modules/router.js';

const pagemanager = {
    init() {
        this._page = document.querySelector("page-component");

        this._router = new Router;
        this._router.addRoute('main', { title: 'Main page', header: 'Welcome to then main page', info: 'This is the main page.' });
        this._router.addRoute('/pageone', { title: 'Page one', header: 'Welcome to page one', info: 'Page one contains interesting stuff.' });
        this._router.addRoute('/pagetwo', { title: 'Page two', header: 'Welcome to page two', info: 'Here on page two you find more interesting stuff.' });
        this.updatepage();
    },

    updatepage: function() {
        const content = this._router.getContent();
        this._page.setHeader(content.header);
        this._page.setInfo(content.info);
        document.title = content.title
    }
}

pagemanager.init();

