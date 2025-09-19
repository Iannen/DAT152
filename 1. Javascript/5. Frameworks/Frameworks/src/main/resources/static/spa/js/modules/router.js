export default class {
    _routes = new Map();

    addRoute(route, content) {
        this._routes.set(route, content);
    }

    getContent() {
        const result = this.filter(String(window.location));
        if (this._routes.has(result)) {
            return (this._routes.get(result));
        } else {
            return (this._routes.get("main"));
        }
    }

    filter(url) {
        const result = url.match(/^.*\/spa\/routing(load)?(.*)$/); if (result !== null) {
            return (result[2]);
        }
    }
}
