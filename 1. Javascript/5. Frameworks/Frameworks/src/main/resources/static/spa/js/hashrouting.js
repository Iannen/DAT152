import '../components/pagehashcomponent/pagehashcomponent.js';
import Router from '../js/modules/hashrouter.js';

const pagemanager = {
    init() {
        this._page = document.querySelector("page-component");

        this._router = new Router;
        this._router.addRoute('main', { title: 'Main page', header: 'Welcome to then main page', info: 'This is the main page.' });
        this._router.addRoute('#pageOne', { title: 'Page one', header: 'Welcome to page one', info: 'Page one contains interesting stuff.' });
        this._router.addRoute('#pageTwo', { title: 'Page two', header: 'Welcome to page two', info: 'Here on page two you find more interesting stuff.' });
        this.updatepage();
        window.addEventListener('hashchange', this.updatepage.bind(this));
    },

    updatepage: function() {
        const content = this._router.getContent();
        this._page.setHeader(content.header);
        this._page.setInfo(content.info);
        document.title = content.title
    }
}

pagemanager.init();

