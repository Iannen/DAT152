export default class {
    #routes = new Map();

    addRoute(route, content) {
        this.#routes.set(route, content);
    }

    getContent() {
        // console.log(location.hash);

        const result = location.hash;
        //console.log(result);
        if (this.#routes.has(result)) {
            return (this.#routes.get(result));
        } else {
            return (this.#routes.get('main'));
        }
    }
}
